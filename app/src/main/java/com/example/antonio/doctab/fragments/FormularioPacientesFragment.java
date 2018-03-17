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

public class FormularioPacientesFragment extends Fragment {

    private static final String TAG = FormularioPacientesFragment.class.getSimpleName();

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;

    /**
     * Se declaran los elementos del formulario
     **/
    private static TextInputLayout tilNombrePaciente, tilCorreoElectronico, tilEdad, tilTelefono;
    private static Spinner spinnerSexo;

    /**
     * Se declaran las variables para uso en memoria
     **/
    public static Pacientes _pacienteActual;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_pacientes, container, false);

        /**Se inicializan las variables globales**/
        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        /**Se inicializan los elementos del formulario**/
        tilNombrePaciente = (TextInputLayout) view.findViewById(R.id.til_nombre_paciente);
        tilCorreoElectronico = (TextInputLayout) view.findViewById(R.id.til_correo_paciente);
        tilEdad = (TextInputLayout) view.findViewById(R.id.til_edad_paciente);
        tilTelefono = (TextInputLayout) view.findViewById(R.id.til_telefono_paciente);
        spinnerSexo = (Spinner) view.findViewById(R.id.spinner_sexo_paciente);

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
                this.obtenerPaciente();
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
                _pacienteActual = new Pacientes();
                _pacienteActual.setFechaDeCreacion(indefinido.getFechaDeCreacion());
                _pacienteActual.setFechaDeEdicion(indefinido.getFechaDeEdicion());

                /**Asigna los valores al formulario**/
                tilNombrePaciente.getEditText().setText(indefinido.getNombreCompleto());
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
    private void obtenerPaciente(){
    //Obtencion del item seleccionado ( el perfil del paciente)
        Pacientes pacientes = (Pacientes) _MAIN_DECODE.getDecodeItem().getItemModel();

        DatabaseReference drPaciente = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_PACIENTES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_PACIENTE)
                .child(pacientes.getFirebaseId());

        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drPaciente.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Pacientes pacientes = dataSnapshot.getValue(Pacientes.class);
                _pacienteActual = pacientes;

                tilCorreoElectronico.getEditText().setText(pacientes.getCorreoElectronico());
                tilEdad.getEditText().setText(pacientes.getEdad());
                tilNombrePaciente.getEditText().setText(pacientes.getEdad());
                tilTelefono.getEditText().setText(pacientes.getTelefono());
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

    public static boolean validarDatosRegistro() {
        boolean valido = false;

        String nombreDoctor = tilNombrePaciente.getEditText().getText().toString();
        String correo = tilCorreoElectronico.getEditText().getText().toString();
        String edad = tilEdad.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombrePaciente, nombreDoctor);
        boolean b = ValidationUtils.esEmailValido(tilCorreoElectronico, correo);
        boolean d = ValidationUtils.esTelefonoValido(tilTelefono, telefono);
        boolean e = ValidationUtils.esSpinnerValido(spinnerSexo);

        if (a && b  && d && e) {
            /**Se agregan los campos que el cliente captura**/
            Pacientes data = new Pacientes();
            data.setNombreCompleto(nombreDoctor);
            data.setCorreoElectronico(correo);
            data.setTelefono(telefono);
            data.setEdad(edad);/**No esta agregando la edad*/
            data.setSexo(spinnerSexo.getSelectedItem().toString());
            data.setTipoDeUsuario(Constants.FB_KEY_ITEM_PACIENTE);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFirebaseId(_SESSION_USER.getFirebaseId());

            setPaciente(data);
            valido = true;
        }

        return valido;
    }

    public static boolean validarDatosEdicion() {
        boolean valido = false;

        String nombrePaciente = tilNombrePaciente.getEditText().getText().toString();
        String correo = tilCorreoElectronico.getEditText().getText().toString();
        String edad = tilEdad.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();

        /**Se acceden a las validaciones de los campos requeridos**/
        boolean a = ValidationUtils.esTextoValido(tilNombrePaciente, nombrePaciente);
        boolean b = ValidationUtils.esEmailValido(tilCorreoElectronico, correo);
        boolean d = ValidationUtils.esTelefonoValido(tilTelefono, telefono);
        boolean e = ValidationUtils.esSpinnerValido(spinnerSexo);

        if (a && b  && d && e) {
            /**Se agregan los campos que el cliente captura**/
            Pacientes data = new Pacientes();

            data.setNombreCompleto(nombrePaciente);
            data.setCorreoElectronico(correo);
            data.setTelefono(telefono);
            data.setEdad(edad);/**No esta agregando la edad*/
            data.setSexo(spinnerSexo.getSelectedItem().toString());
            data.setTipoDeUsuario(Constants.FB_KEY_ITEM_PACIENTE);

            /**Se agregan los datos de sistema que ya existen**/
            /**FirebaseIDDoctor de agrega del usuario en session debido a que el admin no agrega consultorios**/
            data.setFirebaseId(_SESSION_USER.getFirebaseId());
            data.setEstatus(_pacienteActual.getEstatus());

            setPaciente(data);
            valido = true;
        }

        return valido;
    }

    public static void setPaciente(Pacientes data) {
        _pacienteActual.setNombreCompleto(data.getNombreCompleto());
        _pacienteActual.setCorreoElectronico(data.getCorreoElectronico());
        _pacienteActual.setEdad(data.getEdad());
        _pacienteActual.setSexo(data.getSexo());
        _pacienteActual.setTelefono(data.getTelefono());
        _pacienteActual.setTipoDeUsuario(data.getTipoDeUsuario());
        /**Se declaran valores que el sistema debe llenar**/
        _pacienteActual.setFirebaseId(data.getFirebaseId());
        _pacienteActual.setEstatus(data.getEstatus());
    }


}