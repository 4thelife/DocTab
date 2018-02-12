package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;

/**
 * Created by Ricardo on 12/02/2018.
 */

public class ListadoEspecialidadesFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_especialidades, container, false);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
/*
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mainFragment = fragmentManager.beginTransaction();
        mainFragment.replace(R.id.listado_especialidades_container. new EspecialidadesFragment(), Constants.FRAGMENT_ESPECIALIDADES);
        mainFragment.commit();

        getActivity().setTitle("Mis Especialidades");*/

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {

    }
}
