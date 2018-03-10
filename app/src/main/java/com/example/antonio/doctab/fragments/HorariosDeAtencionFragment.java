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

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.HorariosDeAtencionAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.HorariosDeAtencion;
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
 * Created by Ricardo on 24/02/2018.
 */

public class HorariosDeAtencionFragment extends Fragment implements View.OnClickListener {

    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    private static List<HorariosDeAtencion> dataList;
    private static RecyclerView recyclerView;
    private static HorariosDeAtencionAdapter adapter;

    /**
     * Declaraciones de firebase
     **/
    private FirebaseDatabase database;
    private DatabaseReference drDoctores;
    private ValueEventListener listenerHorariosDeAtencion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horarios_de_atencion,container,false);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_horarios_de_atencion);

        adapter = new HorariosDeAtencionAdapter();
        adapter.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();

        drDoctores = database.getReference(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION);

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
        listadoHorariosDeAtencion();
    }

    public void listadoHorariosDeAtencion(){
        listenerHorariosDeAtencion = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter = new HorariosDeAtencionAdapter();
                dataList = new ArrayList<>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                    HorariosDeAtencion horariosDeAtencion = postSnapshot.getValue(HorariosDeAtencion.class);

                    if (null == horariosDeAtencion.getEstatus())break;

                    switch (horariosDeAtencion.getEstatus()) {
                        case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                        case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                            dataList.add(horariosDeAtencion);
                            break;
                        default:
                            break;
                    }

                }
                onPreRenderListadoHorariosDeAtencion();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        drDoctores.addValueEventListener(listenerHorariosDeAtencion);
    }

    public void onPreRenderListadoHorariosDeAtencion(){


        Collections.sort(dataList, new Comparator<HorariosDeAtencion>() {
            @Override
            public int compare(HorariosDeAtencion o1, HorariosDeAtencion o2) {
                return (o1.getDia().compareTo(o2.getDia()));
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
        drDoctores.removeEventListener(listenerHorariosDeAtencion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityInterface = (NavigationDrawerInterface)getActivity();
        }catch (ClassCastException e){
            throw  new ClassCastException(getActivity().toString() + "debe implementar");
        }
    }

    @Override
    public void onClick(View view) {

    }


    public static void onListenerAction(DecodeItemHelper decodeItem) {
        /**Inicializa DecodeItem en la activity principal**/
        activityInterface.setDecodeItem(decodeItem);

        switch (decodeItem.getIdView()) {
            case R.id.item_btn_editar_dia:
                activityInterface.openExternalActivity(Constants.ACCION_EDITAR, MainRegisterActivity.class);
                break;
            case R.id.item_btn_eliminar_dia:
                activityInterface.showQuestion("Eliminar", "¿Esta seguro que desea eliminar?");
                break;
        }
    }

}
