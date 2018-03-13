package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Usuarios;

/**
 * Created by jvier on 04/09/2017.
 */

public class ListadoSeleccionIndefinidoFragment extends Fragment {

    private static Usuarios _SESSION_USER;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_seleccion_indefinidos, container, false);

        _SESSION_USER = (Usuarios) getActivity().getIntent().getSerializableExtra(Constants.KEY_SESSION_USER);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        switch (Constants.TIPO_COMPILACION) {
            case Constants.USUARIO_COMPILACION_DOCTOR:
                openDoctorForm();
                break;
            case Constants.USUARIO_COMPILACION_PACIENTE:
                openPacienteForm();
                break;
        }
    }

    private void openPacienteForm() {
        DecodeExtraHelper extra = new DecodeExtraHelper();

        extra.setTituloActividad(getString(R.string.default_paciente));
        extra.setTituloFormulario(getString(R.string.default_form_title_new));
        extra.setAccionFragmento(Constants.ACCION_REGISTRAR);
        extra.setFragmentTag(Constants.FRAGMENT_REGISTRO_PACIENTES);

        Intent intent = new Intent(getActivity(), MainRegisterActivity.class);
        intent.putExtra(Constants.KEY_MAIN_DECODE, extra);
        intent.putExtra(Constants.KEY_SESSION_USER, _SESSION_USER);
        startActivity(intent);
    }

    private void openDoctorForm() {
        DecodeExtraHelper extra = new DecodeExtraHelper();

        extra.setTituloActividad(getString(R.string.default_doctor));
        extra.setTituloFormulario(getString(R.string.default_form_title_new));
        extra.setAccionFragmento(Constants.ACCION_REGISTRAR);
        extra.setFragmentTag(Constants.FRAGMENT_REGISTRO_DOCTORES);

        Intent intent = new Intent(getActivity(), MainRegisterActivity.class);
        intent.putExtra(Constants.KEY_MAIN_DECODE, extra);
        intent.putExtra(Constants.KEY_SESSION_USER, _SESSION_USER);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
