package com.example.antonio.doctab.fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.adapters.PacientesAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.models.Pacientes;
import com.example.antonio.doctab.models.Usuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class PacientesFragment extends Fragment implements View.OnClickListener{

    private static Usuarios _SESSION_USER;
    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;
    private static List<Pacientes> dataList;
    private static RecyclerView recyclerView;
    private static PacientesAdapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference drDoctores;
    private ValueEventListener listenerPacientes;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pacientes,container,false);
        
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {

    }


}