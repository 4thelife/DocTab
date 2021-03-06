package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.ConsultoriosAdapter;
import com.example.antonio.doctab.adapters.ConsultoriosAdapterVP;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Consultorios;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jvier on 21/12/2017.
 */

public class ConsultoriosFragment extends Fragment implements View.OnClickListener {

    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    private static List<Consultorios> dataList;
    private static RecyclerView recyclerView;
    /**Declaracion de los dos Adapatadores*/
    private static ConsultoriosAdapterVP adapterVP;
    private static ConsultoriosAdapter adapter;

    /**
     * Declaraciones de firebase
     **/
    private FirebaseDatabase database;
    private DatabaseReference drDoctores;
    private ValueEventListener listenerConsultorios;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consultorios, container, false);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_consultorios);

        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                /**Inicializacion de los adaptadores dependiendo del usuario*/
                adapter = new ConsultoriosAdapter();
                adapter.setOnClickListener(this);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                /**Inicializacion de los adaptadores dependiendo del usuario*/
                adapterVP = new ConsultoriosAdapterVP();
                adapterVP.setOnClickListener(this);
                break;
        }



        database = FirebaseDatabase.getInstance();
        /**Se crea la instancia para acceder a la consulta**/
        drDoctores = database.getReference(Constants.FB_KEY_MAIN_DOCTORES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_CONSULTORIOS);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        listadoConsultorios();
    }

    private void listadoConsultorios() {
        listenerConsultorios = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                switch (_SESSION_USER.getTipoDeUsuario()){
                    case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                        /**Se utilizan los adaptadores creados para cada usuario*/
                        adapter = new ConsultoriosAdapter();
                        dataList = new ArrayList<>();

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            /**Se crea un objeto con una variable distinta para ser usado en el caso*/
                            Consultorios consultorio = postSnapshot.getValue(Consultorios.class);

                            if (null == consultorio.getEstatus()) break;

                            switch (consultorio.getEstatus()) {
                                case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                                case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                    /**Se agrega la variable del objeto a la lista*/
                                    dataList.add(consultorio);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                        /**Se utilizan los adaptadores creados para cada usuario*/
                        adapterVP = new ConsultoriosAdapterVP();
                        dataList = new ArrayList<>();

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            /**Se crea un objeto con una variable distinta para ser usado en el caso*/
                            Consultorios consultorio2 = postSnapshot.getValue(Consultorios.class);

                            if (null == consultorio2.getEstatus()) break;

                            switch (consultorio2.getEstatus()) {
                                case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                                case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                    /**Se agrega la variable del objeto a la lista*/
                                    dataList.add(consultorio2);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                }


                onPreRenderListadoConsultorios();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        drDoctores.addValueEventListener(listenerConsultorios);
    }

    private static void onPreRenderListadoConsultorios() {

        Collections.sort(dataList, new Comparator<Consultorios>() {
            @Override
            public int compare(Consultorios o1, Consultorios o2) {
                return (o1.getColonia().compareTo(o2.getColonia()));
            }
        });
        /**Se rellena la vista del listado dependiendo del usuario y se manda a llamar al item*/
        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                adapter.addAll(dataList);
                recyclerView.setAdapter(adapter);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                adapterVP.addAll(dataList);
                recyclerView.setAdapter(adapterVP);
                break;
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onStop() {
        super.onStop();
        drDoctores.removeEventListener(listenerConsultorios);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityInterface = (NavigationDrawerInterface) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "debe implementar");
        }
    }

    @Override
    public void onClick(View v) {

    }

    public static void onListenerAction(DecodeItemHelper decodeItem) {
        /**Inicializa DecodeItem en la activity principal**/
        activityInterface.setDecodeItem(decodeItem);

        switch (decodeItem.getIdView()) {
            case R.id.item_btn_editar_consultorios:
                activityInterface.openExternalActivity(Constants.ACCION_EDITAR, MainRegisterActivity.class);
                break;
            case R.id.item_btn_eliminar_consultorios:
                activityInterface.showQuestion("Eliminar", "¿Esta seguro que desea eliminar?");
                break;
        }
    }
}
