package com.example.antonio.doctab.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.ValidationUtils;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Consultorios;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ricardo on 12/02/2018.
 */

public class FormularioConsultorioFragment extends Fragment {

    private static final String TAG = FormularioConsultorioFragment.class.getSimpleName();

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;

    /**
     * Se declaran los elementos del formulario
     **/
    private static TextInputLayout tilNombreConsultorio, tilTelefono1, tilExtencion1, tilCalle;
    /**
     * Se declaran las variables para uso en memoria
     **/
    public static Consultorios _consultorioActual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_consultorios, container, false);

        /**Se inicializan las variables globales**/
        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        /**Se inicializan los elementos del formulario**/
        tilNombreConsultorio = (TextInputLayout) view.findViewById(R.id.til_nombre_consultorio);
        tilTelefono1 = (TextInputLayout) view.findViewById(R.id.til_telefono_uno);
        tilExtencion1 = (TextInputLayout) view.findViewById(R.id.til_telefono_uno_extencion);
        tilCalle = (TextInputLayout) view.findViewById(R.id.til_calle);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        onPreRender();
    }

    private void onPreRender() {
        switch (_MAIN_DECODE.getAccionFragmento()) {
            case Constants.ACCION_EDITAR:
            case Constants.ACCION_VER:
                this.obtenerConsultorio();
                break;
            case Constants.ACCION_REGISTRAR:
                _consultorioActual = new Consultorios();
                break;
            default:
                break;
        }
    }

    private void obtenerConsultorio() {
        /**Obtiene el item selecionado en el fragmento de lista**/
        Consultorios consultorio = (Consultorios) _MAIN_DECODE.getDecodeItem().getItemModel();

        DatabaseReference drConsultorio = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_DOCTORES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_CONSULTORIOS)
                .child(consultorio.getFireBaseId());

        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drConsultorio.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Consultorios consultorio = dataSnapshot.getValue(Consultorios.class);
                /**Se asigna el chofer actual a la memoria**/
                _consultorioActual = consultorio;

                /**Asigna los valores al formulario**/
                tilNombreConsultorio.getEditText().setText(consultorio.getNombreConsultorio());
                tilCalle.getEditText().setText(consultorio.getCalle());
                tilTelefono1.getEditText().setText(consultorio.getTel1());
                tilExtencion1.getEditText().setText(consultorio.getExt1());

                pDialogRender.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Error intentando obtener datos ...");
                pDialogRender.dismiss();
            }
        });
    }

    public static boolean validarDatosRegistro() {
        boolean valido = false;

        String nombreConsultorio = tilNombreConsultorio.getEditText().getText().toString();
        String telefono1 = tilTelefono1.getEditText().getText().toString();
        String extencion1 = tilExtencion1.getEditText().getText().toString();
        String calle = tilCalle.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombreConsultorio, nombreConsultorio);
        boolean b = ValidationUtils.esTelefonoValido(tilTelefono1, telefono1);
        boolean c = ValidationUtils.esTextoValido(tilCalle, calle);

        if (a && b && c) {
            /**Se agregan los campos que el cliente captura**/
            Consultorios data = new Consultorios();
            data.setNombreConsultorio(nombreConsultorio);
            data.setTel1(telefono1);
            data.setExt1(extencion1);
            data.setCalle(calle);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFireBaseIdDoctor(_SESSION_USER.getFirebaseId());

            setConsultorio(data);
            valido = true;
        }

        return valido;
    }

    public static boolean validarDatosEdicion() {
        boolean valido = false;

        String nombreConsultorio = tilNombreConsultorio.getEditText().getText().toString();
        String telefono1 = tilTelefono1.getEditText().getText().toString();
        String extencion1 = tilExtencion1.getEditText().getText().toString();
        String calle = tilCalle.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombreConsultorio, nombreConsultorio);
        boolean b = ValidationUtils.esTelefonoValido(tilTelefono1, telefono1);
        boolean c = ValidationUtils.esTextoValido(tilCalle, calle);

        if (a && b && c) {
            /**Se agregan los campos que el cliente captura**/
            Consultorios data = new Consultorios();
            data.setNombreConsultorio(nombreConsultorio);
            data.setTel1(telefono1);
            data.setExt1(extencion1);
            data.setCalle(calle);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFireBaseIdDoctor(_SESSION_USER.getFirebaseId());
            data.setFireBaseId(_consultorioActual.getFireBaseId());
            data.setEstatus(_consultorioActual.getEstatus());

            setConsultorio(data);
            valido = true;
        }

        return valido;
    }

    public static void setConsultorio(Consultorios data) {
        _consultorioActual.setNombreConsultorio(data.getNombreConsultorio());
        _consultorioActual.setTel1(data.getTel1());
        _consultorioActual.setExt1(data.getExt1());
        _consultorioActual.setTel2(data.getTel2());
        _consultorioActual.setExt2(data.getExt2());
        _consultorioActual.setCalle(data.getCalle());
        _consultorioActual.setColonia(data.getColonia());
        _consultorioActual.setNumeroInt(data.getNumeroInt());
        _consultorioActual.setNumeroExt(data.getNumeroExt());
        _consultorioActual.setCodPostal(data.getCodPostal());
        _consultorioActual.setCiudad(data.getCiudad());
        _consultorioActual.setEstado(data.getEstado());
        /**Se declaran valores que el sistema debe llenar**/
        _consultorioActual.setFireBaseIdDoctor(data.getFireBaseIdDoctor());
        _consultorioActual.setFireBaseId(data.getFireBaseId());
        _consultorioActual.setEstatus(data.getEstatus());
    }
}
