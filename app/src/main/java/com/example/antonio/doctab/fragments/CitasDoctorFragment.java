package com.example.antonio.doctab.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.CitasDoctorAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.models.Citas;
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
 * Created by Ricardo on 13/02/2018.
 */

public class CitasDoctorFragment extends Fragment implements View.OnClickListener{
    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    private static List<Citas> dataList;
    private static RecyclerView recyclerView;
    public static CitasDoctorAdapter adapter;

    /**
     * Declaraciones de firabase
     */

    private FirebaseDatabase database;
    private DatabaseReference drCitasDoctor;
    private ValueEventListener listenerCitasDoctor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_citas_doctor, container, false);
        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados1);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_citas_doctor);
        adapter = new CitasDoctorAdapter();
        adapter.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        drCitasDoctor = database.getReference(Constants.FB_KEY_MAIN_DOCTORES);

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
        listadoCitasDoctor();
    }

    private void listadoCitasDoctor() {
        listenerCitasDoctor = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                adapter = new CitasDoctorAdapter();
                dataList = new ArrayList<>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    /*
                    for (DataSnapshot psBodegas : postSnapshot.child(Constants.FB_KEY_MAIN_BODEGAS).getChildren()) {

                        Bodegas bodega = psBodegas.getValue(Bodegas.class);

                        DataSnapshot psCliente = postSnapshot.child(Constants.FB_KEY_ITEM_CLIENTE);
                        Clientes cliente = psCliente.getValue(Clientes.class);

                        if (!Constants.FB_KEY_ITEM_ESTATUS_ACTIVO.equals(cliente.getEstatus()))
                            break;

                        if (_SESSION_USER.getTipoDeUsuario().equals(Constants.FB_KEY_ITEM_TIPO_USUARIO_CLIENTE)) {
                            if (!_SESSION_USER.getFirebaseId().equals(postSnapshot.getKey()))
                                continue;
                        }

                        if (bodega.getEstatus().equals(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO)) {
                            bodega.setFirebaseIdDelCliente(postSnapshot.getKey());
                            bodega.setNombreDeLaBodega(cliente.getNombre() + " - " + bodega.getNombreDeLaBodega());
                            bodegasList.add(bodega);
                        }
                    }
                    */
                }

                onPreRenderListadoCitasDoctor();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        drCitasDoctor.addValueEventListener(listenerCitasDoctor);
    }


    private static void onPreRenderListadoCitasDoctor(){
        Collections.sort(dataList, new Comparator<Citas>() {
        @Override
        public int compare(Citas o1, Citas o2) {
            return (o1.getFireBaseId().compareTo(o2.getFireBaseId()));
        }
        });

        adapter.addAll(dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void onStop() {
        super.onStop();
        drCitasDoctor.removeEventListener(listenerCitasDoctor);
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


}