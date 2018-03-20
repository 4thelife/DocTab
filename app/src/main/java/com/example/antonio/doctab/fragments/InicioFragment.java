package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.CitasAdapterVP;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Citas;
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
 * Created by GIGABYTE on 06/03/2018.
 */

public class InicioFragment extends Fragment implements View.OnClickListener {

    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    /**
     * Declaracion de los elementos de la vista
     */
    private static List<Citas> dataList;
    private static RecyclerView recyclerView;
    public static CitasAdapterVP adapter;
    TextView vista;
    /**
     * Declaraciones de firebase
     **/
    private FirebaseDatabase database;
    private DatabaseReference drCitas;
    private ValueEventListener listenerInicio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        vista = (TextView) view.findViewById(R.id.txt_inicio);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_inicio);

        adapter = new CitasAdapterVP();


        database = FirebaseDatabase.getInstance();

        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS);
                vista.setText("Inicio en modo doctor");
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS)
                        .child(_SESSION_USER.getFirebaseId());
                vista.setText("Inicio en modo paciente");
                break;
        }

        return view;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        listadoInicioCitas();

    }

    private void listadoInicioCitas() {
        listenerInicio = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter = new CitasAdapterVP();
                dataList = new ArrayList<>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                    switch (_SESSION_USER.getTipoDeUsuario()){
                        case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                            for(DataSnapshot postSnapshot2 : postSnapshot.getChildren()){

                                Citas citas2 = postSnapshot2.getValue(Citas.class);
                                if (null== citas2.getEstatus()) break;
                                switch (citas2.getEstatus()){
                                    case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                                    case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                        dataList.add(citas2);
                                        break;
                                    default:
                                        break;
                                }

                            }
                            break;
                        case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                            /**Citas citas = postSnapshot.getValue(Citas.class);

                            if (null == citas.getEstatus()) break;

                            switch (citas.getEstatus()){
                                case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                                case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                    dataList.add(citas);
                                    break;
                                default:
                                    break;
                            }*/
                            break;
                    }

                }
                onPreRenderListadoInicio();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        drCitas.addValueEventListener(listenerInicio);
    }


    private void onPreRenderListadoInicio() {
        Collections.sort(dataList, new Comparator<Citas>() {
            @Override
            public int compare(Citas o1, Citas o2) {
                return  (o1.getFechaDeCreacion().compareTo(o2.getFechaDeCreacion()));
            }
        });

        adapter.addAll(dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onStop() {
        super.onStop();
        drCitas.removeEventListener(listenerInicio);
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


    public void onClick(View v) {

    }

    public  static void onListenerAction(DecodeItemHelper decodeItem){
        /**Inicializa DecodeItem en la activity principal*/
        activityInterface.setDecodeItem(decodeItem);

        switch (decodeItem.getIdView()){
            case  R.id.item_btn_editar_citas:
                activityInterface.openExternalActivity(Constants.ACCION_EDITAR, MainRegisterActivity.class);
                break;
            case R.id.item_btn_eliminar_citas:
                activityInterface.showQuestion("Eliminar",
                        "¿Esta seguro que desea eliminar?");
                break;
        }

    }

}
