package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.models.Usuarios;

/**
 * Created by jvier on 04/09/2017.
 */

public class ListadoPacientesFragment extends Fragment implements View.OnClickListener {

    private static Usuarios _SESSION_USER;
    private Button btnRegistrar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_pacientes, container, false);

        _SESSION_USER = (Usuarios) getActivity().getIntent().getSerializableExtra(Constants.KEY_SESSION_USER);

        btnRegistrar = (Button) view.findViewById(R.id.btn_agregar_paciente_doctor);
        btnRegistrar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mainFragment = fragmentManager.beginTransaction();
        mainFragment.replace(R.id.listado_pacientes_doctor_container, new ConsultoriosFragment(), Constants.FRAGMENT_CONSULTORIOS);
        mainFragment.commit();

        getActivity().setTitle(getString(R.string.default_item_menu_title_pacientes_doctor));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_agregar_paciente_doctor:

                break;
        }
    }
}
