package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;

/**
 * Created by GIGABYTE on 06/03/2018.
 */

public class MiPerfilDoctorPrivadoFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_miperfil_doctor_privado, container, false);

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

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mainFragment = fragmentManager.beginTransaction();
        mainFragment.replace(R.id.fragment_miperfil_general_doctor_privado_container, new MiPerfilGeneralDoctorPrivadoFragment(), Constants.FRAGMENT_MI_PERFIL_GENERAL_DOCTOR_PRIVADO);
        mainFragment.replace(R.id.fragment_miperfil_horario_doctor_privado_container, new HorariosDeAtencionFragment(), Constants.FRAGMENT_HORARIOS_DE_ATENCION);
        mainFragment.replace(R.id.fragment_miperfil_direccion_doctor_privado_container,new ConsultoriosFragment(),Constants.FRAGMENT_CONSULTORIOS);
        mainFragment.commit();

        getActivity().setTitle(getString(R.string.default_item_menu_title_consultorios_doctor));

        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}

