package com.example.antonio.doctab.fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.fragments.interfaces.MainRegisterInterface;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Usuarios;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class RegistroDoctoresFragment extends Fragment {


    private MainRegisterInterface activityInterface;

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_doctor, container, false);

        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = (Usuarios) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_SESSION_USER);

        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //FragmentTransaction mainFragment = fragmentManager.beginTransaction();

        /*
        mainFragment.replace(R.id.fragment_registro_doctor_container, new FormularioPromotoresFragment(), Constants.FORMULARIO_PROMOTORES);
        mainFragment.replace(R.id.fragment_acciones_consultorio_container, new AccionesPromotoresFragment(), Constants.FORMULARIO_PROMOTORES_ACCIONES);
        */

        //mainFragment.commit();

        this.onPreRender();

        return view;
    }

    @Override
    public void onStart() {

        super.onStart();
    }


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try {
            activityInterface = (MainRegisterInterface) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "debe implementar");
        }
    }


    public void onPreRender() {
        switch (_MAIN_DECODE.getAccionFragmento()) {
            case Constants.ACCION_EDITAR:
                break;
            case Constants.ACCION_REGISTRAR:
                break;
            default:
                break;
        }
    }

}