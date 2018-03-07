package com.example.antonio.doctab.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.antonio.doctab.adapters.DoctoresAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.Usuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class DoctoresFragment extends Fragment implements View.OnClickListener{

    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    private static List<Doctores> dataList;
    private static RecyclerView recyclerView;
    private static DoctoresAdapter adapter;

    /**
     * Declaraciones de firebase
     **/
    private FirebaseDatabase database;
    private DatabaseReference drDoctores;
    //Aún tengo que revisar estas variables

    //private ValueEventListener listenerConsultorios;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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

    @Override
    public void onStop() {
        super.onStop();
    }
}
