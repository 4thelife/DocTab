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
import android.widget.Spinner;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.ValidationUtils;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.Indefinido;
import com.example.antonio.doctab.models.Pacientes;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class FormularioDoctoresFragment extends Fragment {

    private static final String TAG = FormularioDoctoresFragment.class.getSimpleName();

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;

    /**
     * Se declaran los elementos del formulario
     **/
    private static TextInputLayout tilNombreDoctor, tilCorreoElectronico, tilEspecialidad, tilCedulaProfesional, tilTelefono;
    private static Spinner spinnerSexo;

    /**
     * Se declaran las variables para uso en memoria
     **/
    public static Doctores _doctorActual;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_doctores, container, false);

        /**Se inicializan las variables globales**/
        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        /**Se inicializan los elementos del formulario**/
        tilNombreDoctor = (TextInputLayout) view.findViewById(R.id.til_nombre_doctor);
        tilCorreoElectronico = (TextInputLayout) view.findViewById(R.id.til_correo_doctor);
        tilEspecialidad = (TextInputLayout) view.findViewById(R.id.til_especialidad_doctor);
        tilCedulaProfesional = (TextInputLayout) view.findViewById(R.id.til_cedula_doctor);
        tilTelefono = (TextInputLayout) view.findViewById(R.id.til_telefono_doctor);
        spinnerSexo = (Spinner) view.findViewById(R.id.spinner_sexo_doctor);
        tilCorreoElectronico.setEnabled(false);

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
                this.obtenerDoctor();
                break;
            case Constants.ACCION_REGISTRAR:
                obtenerUsuarioIndefinido();
                break;
            default:
                break;
        }
    }

    private void obtenerUsuarioIndefinido() {
        /**Obtiene el item selecionado en el fragmento de lista**/
        DatabaseReference drConsultorio = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_INDEFINIDOS)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_INDEFINIDO);

        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drConsultorio.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Indefinido indefinido = dataSnapshot.getValue(Indefinido.class);
                /**Se asigna el chofer actual a la memoria**/
                _doctorActual = new Doctores();
                _doctorActual.setFechaDeCreacion(indefinido.getFechaDeCreacion());
                _doctorActual.setFechaDeEdicion(indefinido.getFechaDeEdicion());

                /**Asigna los valores al formulario**/
                tilNombreDoctor.getEditText().setText(indefinido.getNombreCompleto());
                tilCorreoElectronico.getEditText().setText(indefinido.getCorreoElectronico());

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

        String nombreDoctor = tilNombreDoctor.getEditText().getText().toString();
        String correo = tilCorreoElectronico.getEditText().getText().toString();
        String especialidad = tilEspecialidad.getEditText().getText().toString();
        String cedulaProfesional = tilCedulaProfesional.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombreDoctor, nombreDoctor);
        boolean b = ValidationUtils.esEmailValido(tilCorreoElectronico, correo);
        boolean c = ValidationUtils.esTextoValido(tilEspecialidad, especialidad);
        boolean d = ValidationUtils.esTextoValido(tilCedulaProfesional, cedulaProfesional);
        boolean e = ValidationUtils.esTelefonoValido(tilTelefono, telefono);
        boolean f = ValidationUtils.esSpinnerValido(spinnerSexo);

        if (a && b && c && d && e && f) {
            /**Se agregan los campos que el cliente captura**/
            Doctores data = new Doctores();
            data.setNombreCompleto(nombreDoctor);
            data.setCorreoElectronico(correo);
            data.setEspecialidad(especialidad);
            data.setCedulaProfesional(cedulaProfesional);
            data.setTelefono(telefono);
            data.setSexo(spinnerSexo.getSelectedItem().toString());
            data.setTipoDeUsuario(Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFirebaseId(_SESSION_USER.getFirebaseId());
            data.setEstatus(_doctorActual.getEstatus());

            setDoctor(data);
            valido = true;
        }

        return valido;
    }
    private void obtenerDoctor(){
        //Obtencion del item seleccionado ( el perfil del paciente)
        Doctores doctores = (Doctores) _MAIN_DECODE.getDecodeItem().getItemModel();

        DatabaseReference drDoctor = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_DOCTORES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_DOCTOR)
                .child(doctores.getFirebaseId());

        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drDoctor.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Doctores doctores = dataSnapshot.getValue(Doctores.class);
                _doctorActual = doctores;

                tilNombreDoctor.getEditText().setText(doctores.getNombreCompleto());
                tilCorreoElectronico.getEditText().setText(doctores.getCorreoElectronico());
                tilEspecialidad.getEditText().setText(doctores.getEspecialidad());
                tilCedulaProfesional.getEditText().setText(doctores.getCedulaProfesional());
                tilTelefono.getEditText().setText(doctores.getTelefono());
                spinnerSexo.getSelectedItem();

                pDialogRender.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Error intentando obtener datos ...");
                pDialogRender.dismiss();
            }
        });
    }
    public static boolean validarDatosEdicion() {
        boolean valido = false;

        String nombreDoctor = tilNombreDoctor.getEditText().getText().toString();
        String correo = tilCorreoElectronico.getEditText().getText().toString();
        String especialidad = tilEspecialidad.getEditText().getText().toString();
        String cedulaProfesional = tilCedulaProfesional.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombreDoctor, nombreDoctor);
        boolean b = ValidationUtils.esEmailValido(tilCorreoElectronico, correo);
        boolean c = ValidationUtils.esTextoValido(tilEspecialidad, especialidad);
        boolean d = ValidationUtils.esTextoValido(tilCedulaProfesional, cedulaProfesional);
        boolean e = ValidationUtils.esTelefonoValido(tilTelefono, telefono);
        boolean f = ValidationUtils.esSpinnerValido(spinnerSexo);

        if (a && b && c && d && e && f) {
            /**Se agregan los campos que el cliente captura**/
            Doctores data = new Doctores();
            data.setNombreCompleto(nombreDoctor);
            data.setCorreoElectronico(correo);
            data.setEspecialidad(especialidad);
            data.setCedulaProfesional(cedulaProfesional);
            data.setTelefono(telefono);
            data.setSexo(spinnerSexo.getSelectedItem().toString());
            data.setTipoDeUsuario(Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFirebaseId(_SESSION_USER.getFirebaseId());
            data.setEstatus(_doctorActual.getEstatus());

            setDoctor(data);
            valido = true;
        }

        return valido;    }

    public static void setDoctor(Doctores data) {
        _doctorActual.setNombreCompleto(data.getNombreCompleto());
        _doctorActual.setEspecialidad(data.getEspecialidad());
        _doctorActual.setCedulaProfesional(data.getCedulaProfesional());
        _doctorActual.setCorreoElectronico(data.getCorreoElectronico());
        _doctorActual.setSexo(data.getSexo());
        _doctorActual.setTelefono(data.getTelefono());
        _doctorActual.setTipoDeUsuario(data.getTipoDeUsuario());
        /**Se declaran valores que el sistema debe llenar**/
        _doctorActual.setFirebaseId(data.getFirebaseId());
        _doctorActual.setEstatus(data.getEstatus());
    }


}