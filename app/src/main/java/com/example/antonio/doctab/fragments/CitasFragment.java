package com.example.antonio.doctab.fragments;

import android.support.v4.app.Fragment;
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
import com.example.antonio.doctab.adapters.CitasAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
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
 * Created by Ricardo on 13/02/2018.
 */

public class CitasFragment extends Fragment implements View.OnClickListener{

    private Usuarios _SESSION_USER;
    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    private static List<Citas> dataList;
    private static RecyclerView recyclerView;
    public static CitasAdapter adapter;

    /**
     * Declaraciones de firabase
     */

    private FirebaseDatabase database;
    private DatabaseReference drCitas;
    private DatabaseReference drCitasInfo;
    private ValueEventListener listenerCitasInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citas, container, false);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_citas);
        adapter = new CitasAdapter();
        adapter.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();

        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_DOCTORES)
                    .child(_SESSION_USER.getFirebaseId())
                    .child(Constants.FB_KEY_MAIN_CITAS);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_PACIENTES)
                    .child(_SESSION_USER.getFirebaseId())
                    .child(Constants.FB_KEY_MAIN_CITAS);
                break;
        }

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
        listenerCitasInfo = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                adapter = new CitasAdapter();
                dataList = new ArrayList<>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        drCitas.addValueEventListener(listenerCitasInfo);
    }



    public void onStop() {
        super.onStop();
        drCitas.removeEventListener(listenerCitasInfo);
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