package com.example.antonio.doctab.fragments;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.ValidationUtils;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Citas;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class FormularioCitasFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = FormularioCitasFragment.class.getSimpleName();

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;

    Spinner horasSpinner;
    private static TextInputLayout tilCitasFecha, tilCitasHora,tilCitasAsunto;
    Calendar currentDate,currentTime;
    EditText fecha,hora;
    int dia, mes, year,hour, minuto;

    /**Declaraciones de Firebase **/
    private FirebaseDatabase database;
    private DatabaseReference drCitas;
    private ValueEventListener listenerCitas;
    /**Declaro el objeto para usarlo ?**/
    public static Citas _citaActual;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_citas,container,false);

        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        /**
         * Seleccionar la fecha
         */

        tilCitasFecha = (TextInputLayout) view.findViewById(R.id.til_citas_fecha);
        tilCitasAsunto=(TextInputLayout) view.findViewById(R.id.til_citas_asunto);
        fecha = (EditText)view.findViewById(R.id.ed_citas_fecha);
        currentDate = Calendar.getInstance();
        dia = currentDate.get(Calendar.DAY_OF_MONTH);
        mes = currentDate.get(Calendar.MONTH);
        year = currentDate.get(Calendar.YEAR);
        tilCitasFecha.getEditText().setText(dia+"/"+mes+"/"+year);

        horasSpinner = (Spinner)view.findViewById(R.id.spiner_horas);
        fecha.setOnClickListener(this);

        /*Seleccionar la hora*/
        tilCitasHora = (TextInputLayout) view.findViewById(R.id.til_citas_hora);
        hora = (EditText)view.findViewById(R.id.ed_citas_hora);
        currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minuto = currentTime.get(Calendar.MINUTE);

        tilCitasHora.getEditText().setText(hour+":"+minuto);
        hora.setOnClickListener(this);



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
                this.obtenerCita();
                break;
            case Constants.ACCION_REGISTRAR:
                _citaActual = new Citas();
                break;
            default:
                break;
        }
    }

    private void obtenerCita(){
        final Citas citas = (Citas) _MAIN_DECODE.getDecodeItem().getItemModel();

        DatabaseReference drCita = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_CITAS)
                .child(citas.getFirebaseIdPaciente())
                .child(citas.getFireBaseId());
        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drCita.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Citas citas = dataSnapshot.getValue(Citas.class);

                _citaActual = citas;

                tilCitasHora.getEditText().setText(citas.getHora());
                tilCitasFecha.getEditText().setText(citas.getFecha());
                tilCitasAsunto.getEditText().setText(citas.getAsunto());

                pDialogRender.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Error intentando obtener datos ...");
                pDialogRender.dismiss();
            }
        });


    }

    public static boolean validarCita() {
        Usuarios usuarios =new Usuarios();
        boolean valido = false;

        String fecha = tilCitasFecha.getEditText().getText().toString();
        String hora = tilCitasHora.getEditText().getText().toString();

        String asunto = tilCitasAsunto.getEditText().getText().toString();

        boolean a = ValidationUtils.esTextoValido(tilCitasAsunto, asunto);
        if (a){


        Citas data = new Citas();
        data.setAsunto(asunto);
        data.setFecha(fecha);
        data.setHora(hora);
        data.setFirebaseIdDoctor(Constants.USUARIO_DOCTOR);
        data.setFirebaseIdPaciente(_SESSION_USER.getFirebaseId());
        data.setNombre(usuarios.getNombre());
        setCita(data);
        valido = true;
        }


        return valido;
    }

    public static boolean validarCitaEdicion() {
        boolean valido = false;

        String fecha = tilCitasFecha.getEditText().getText().toString();
        String hora = tilCitasHora.getEditText().getText().toString();

        String asunto = tilCitasAsunto.getEditText().getText().toString();

        boolean a = ValidationUtils.esTextoValido(tilCitasAsunto, asunto);
        if (a){


            Citas data = new Citas();
            data.setAsunto(asunto);
            data.setFecha(fecha);
            data.setHora(hora);

            data.setNombre(_citaActual.getNombre());
            data.setFirebaseIdDoctor(Constants.USUARIO_DOCTOR);
            data.setFireBaseId(_citaActual.getFireBaseId());
            data.setFirebaseIdPaciente(_citaActual.getFirebaseIdPaciente());

            setCita(data);
            valido = true;
        }


        return valido;
    }

    public static void setCita(Citas data) {
        _citaActual.setFecha(data.getFecha());
        _citaActual.setHora(data.getHora());
        _citaActual.setAsunto(data.getAsunto());
        _citaActual.setNombre(_SESSION_USER.getNombre());
        _citaActual.setFirebaseIdPaciente(data.getFirebaseIdPaciente());
        _citaActual.setFirebaseIdDoctor(Constants.USUARIO_DOCTOR);
        _citaActual.setFireBaseId(data.getFireBaseId());
        _citaActual.setEstatus(data.getEstatus());
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_citas_fecha:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month+1;
                                tilCitasFecha.getEditText().setText(dayOfMonth+"/"+month+"/"+year);
                                final ArrayList<String> horasList = new ArrayList<String>();//Lista
                                ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,horasList);
                                //mi intento  de rellenar el spinner
                                //Database
                                database = FirebaseDatabase.getInstance();
                                drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS).child(_SESSION_USER.getFirebaseId());
                                //drCitas = database.getReference(Constants.FB_KEY_MAIN_CALENDARIO).child(""+year).child(""+month).child(""+dayOfMonth);

                                listenerCitas = new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                                            Citas citas = postSnapshot.getValue(Citas.class);
                                            if (null == citas.getEstatus()) break;
                                            switch (citas.getEstatus()){
                                                case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                                                case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                                    horasList.add(citas.getHora());
                                                    horasList.add("Entra?");
                                                    break;
                                                default:
                                                break;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                };
                                horasSpinner.setAdapter(adapter);
                            }
                        },year,mes,dia);
                datePickerDialog.show();
                break;
            case R.id.ed_citas_hora:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tilCitasHora.getEditText().setText(hourOfDay+":"+minute);
                    }
                },hour,minuto,true);
                timePickerDialog.show();
                break;
        }
    }
    // todo estaba mal, hay que volver a reestructurar.
    // no era ni programación orientada a objetos, se perdía el contexto y no podía acceder a los valores.
    // por eso revertí todo lo que había hecho.
    // pero ya tengo la idea de como hacerlo, solo hay que plasmarlo en POO para que pueda atraer los valores de los objetos, si te das cuenta en realidad solo cambiaba de posicion el código
    // escrito ( que revertí ) era lo mismo en todoslos casos
}




