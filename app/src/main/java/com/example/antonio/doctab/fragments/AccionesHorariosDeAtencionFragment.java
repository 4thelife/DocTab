package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antonio.doctab.MainRegisterActivity;
import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.helpers.HorarioDeAtencionHelper;

/**
 * Created by Ricardo on 02/03/2018.
 */

public class AccionesHorariosDeAtencionFragment extends Fragment implements View.OnClickListener {

    private static DecodeExtraHelper _MAIN_DECODE;
    private static MainRegisterActivity activityInterface;
    private static Button btnRegistrar;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_formulario_horarios_de_atencion_acciones,container,false);


        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);

        btnRegistrar =(Button) view.findViewById(R.id.btn_accion_horarios_de_atencion);
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

    private void onPreRender(){
        switch (_MAIN_DECODE.getAccionFragmento()){
            case Constants.ACCION_EDITAR:
                btnRegistrar.setText("EDITAR HORARIO");
                break;
            case Constants.ACCION_REGISTRAR:
                btnRegistrar.setText("REGISTRAR HORARIO");
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
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + "Debe de implementar");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accion_horarios_de_atencion:
                switch (_MAIN_DECODE.getAccionFragmento()) {
                    case Constants.ACCION_EDITAR:
                        this.showQuestion();
                        break;
                    case Constants.ACCION_REGISTRAR:
                        if (FormularioHorariosDeAtencionFragment.validarDatosReg())
                            registrar();
                        break;
                }
                break;
        }
    }

    private void showQuestion() {
        AlertDialog.Builder ad = new AlertDialog.Builder(getContext());

        ad.setTitle(_MAIN_DECODE.getTituloActividad());
        ad.setMessage("¿Esta seguro que desea editar?");
        ad.setCancelable(false);
        /**ad.setNegativeButton(getString(R.string.default_alert_dialog_cancelar), this);
        ad.setPositiveButton(getString(R.string.default_alert_dialog_aceptar), this);*/
        ad.show();
    }

    public void onClick(DialogInterface dialog, int which){
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                if (FormularioConsultorioFragment.validarDatosEdicion())
                    editar();
                break;
        }
    }

    private void registrar() {
        /**Transporta la información del objeto a la actividad de registro**/
        HorarioDeAtencionHelper helper = new HorarioDeAtencionHelper();
        helper.setHorariosDeAtencion(FormularioHorariosDeAtencionFragment._horarioDeATencionActual);

        activityInterface.registrarHorariosDeAtencion(helper);
    }

    private void editar(){
        /**Transporta la informacion del objeto a la actividad de registro*/
        HorarioDeAtencionHelper helper = new HorarioDeAtencionHelper();
        helper.setHorariosDeAtencion(FormularioHorariosDeAtencionFragment._horarioDeATencionActual);
        activityInterface.editarHorariosDeAtencion(helper);
    }

}
