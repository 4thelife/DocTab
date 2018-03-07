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
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.DoctoresAdapter;
import com.example.antonio.doctab.adapters.HorariosDeAtencionAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.HorariosDeAtencion;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 07/03/2018.
 */

public class MiPerfilHorarioDoctorPrivadoFragment extends Fragment{
    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    private static LinearLayout linearLayout;

    private static List<HorariosDeAtencion> dataList;
    private static RecyclerView recyclerView;
    private static HorariosDeAtencionAdapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference drDoctores;
    private ValueEventListener listenerDoctores;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horarios_de_atencion, container, false);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        adapter = new HorariosDeAtencionAdapter();


        database = FirebaseDatabase.getInstance();
        drDoctores = database.getReference(Constants.FB_KEY_MAIN_DOCTORES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_DOCTOR);


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

    private void listadoHorariosDeAtencion(){
        listenerDoctores = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter = new HorariosDeAtencionAdapter();
                dataList = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                    HorariosDeAtencion horariosDeAtencion = postSnapshot.getValue(HorariosDeAtencion.class);
                    if (null == horariosDeAtencion.getEstatus())break;

                    switch (horariosDeAtencion.getEstatus()){
                        case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                        case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                            dataList.add(horariosDeAtencion);
                            break;
                        default:
                            break;
                    }

                }
                onPreRenderListadoDoctores();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        drDoctores.addValueEventListener(listenerDoctores);
    }

    private static void onPreRenderListadoDoctores() {
        adapter.addAll(dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onStop() {
        super.onStop();
        drDoctores.removeEventListener(listenerDoctores);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityInterface = (NavigationDrawerInterface) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + "debe implementar");
        }

    }


}
