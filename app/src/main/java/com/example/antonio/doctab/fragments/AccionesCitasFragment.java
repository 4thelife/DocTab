package com.example.antonio.doctab.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.helpers.CitasHelper;
import com.example.antonio.doctab.helpers.ConsultoriosHelper;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;

/**
 * Created by GIGABYTE on 13/03/2018.
 */

public class AccionesCitasFragment extends Fragment implements View.OnClickListener,AlertDialog.OnClickListener {

    private static DecodeExtraHelper _MAIN_DECODE;
    private static MainRegisterActivity activityInterface;
    private static Button btnRegistrar;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_formulario_citas_acciones, container, false);

        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);

        btnRegistrar = (Button) view.findViewById(R.id.btn_accion_citas);
        btnRegistrar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.onPreRender();
    }

    private void onPreRender() {
        switch (_MAIN_DECODE.getAccionFragmento()) {
            case Constants.ACCION_EDITAR:
                btnRegistrar.setText("EDITAR CITA");
                break;
            case Constants.ACCION_REGISTRAR:
                btnRegistrar.setText("REGISTRAR CITA");
                break;
            default:
                view.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityInterface = (MainRegisterActivity) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "debe implementar");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accion_citas:
                switch (_MAIN_DECODE.getAccionFragmento()) {
                    case Constants.ACCION_EDITAR:
                        this.showQuestion();
                        break;
                    case Constants.ACCION_REGISTRAR:
                       if (FormularioCitasFragment.obtenerCita())
                         registrar();
                        break;
                }
                break;
        }
    }

    private void showQuestion() {
        android.support.v7.app.AlertDialog.Builder ad = new android.support.v7.app.AlertDialog.Builder(getContext());

        ad.setTitle(_MAIN_DECODE.getTituloActividad());
        ad.setMessage("¿Esta seguro que desea editar?");
        ad.setCancelable(false);
        ad.setNegativeButton(getString(R.string.default_alert_dialog_cancelar), this);
        ad.setPositiveButton(getString(R.string.default_alert_dialog_aceptar), this);
        ad.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                if (FormularioConsultorioFragment.validarDatosEdicion())
                    editar();
                break;
        }
    }

    private void registrar()
    {
        /**Transporta la información del objeto a la actividad de registro**/
        CitasHelper helper = new CitasHelper();
        helper.setCitas(FormularioCitasFragment._citaActual);

        activityInterface.registrarCita(helper);
    }

    private void editar() {
        /**Transporta la información del objeto a la actividad de registro**/
        ConsultoriosHelper helper = new ConsultoriosHelper();
        helper.setConsultorio(FormularioConsultorioFragment._consultorioActual);

        activityInterface.editarConsultorio(helper);
    }

}
