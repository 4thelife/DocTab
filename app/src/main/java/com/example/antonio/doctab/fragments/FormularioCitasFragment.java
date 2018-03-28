package com.example.antonio.doctab.fragments;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.ValidationUtils;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.models.Citas;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.HorariosDeAtencion;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    String laFecha,laFecha2;

    private FirebaseDatabase database;
    private DatabaseReference drCitas,drHorario;
    private ValueEventListener listenerCitas,listenerHorario;
    ArrayList<String> horasOcupadas = new ArrayList<>();
    ArrayList<String> horasLibres = new ArrayList<>();

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
        //tilCitasFecha.getEditText().setText(dia+"/"+mes+"/"+year);

        horasSpinner = (Spinner)view.findViewById(R.id.spiner_horas);
        fecha.setOnClickListener(this);

        /*Seleccionar la hora*/
        tilCitasHora = (TextInputLayout) view.findViewById(R.id.til_citas_hora);
        hora = (EditText)view.findViewById(R.id.ed_citas_hora);
        currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minuto = currentTime.get(Calendar.MINUTE);

        //tilCitasHora.getEditText().setText(hour+":"+minuto);

        database = FirebaseDatabase.getInstance();




        horasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity()," Item seleccionado"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                tilCitasHora.getEditText().setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


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
                            public void onDateSet(DatePicker view, final int year,final int month, final int dayOfMonth) {
                                int mecito = month+1;
                                tilCitasFecha.getEditText().setText(dayOfMonth+"/"+mecito+"/"+year);
                                if (!tilCitasFecha.getEditText().getText().equals("")){
                                }
                            }
                        },year,mes,dia);
                datePickerDialog.show();
                rellenarSpinner();
                break;
            case R.id.ed_citas_hora:

                break;
        }
    }
    public void rellenarSpinner(){

        ArrayAdapter<String> adapterHorasOcupadas = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,horasOcupadas);
        ArrayAdapter<String> adapterHorasLibres= new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,horasLibres);

        final String fechaelegida = String.valueOf(tilCitasFecha.getEditText().getText());

        horasLibres.add("Seleccione una hora");
        drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS);
        listenerCitas = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    for (DataSnapshot postSnapshot2:postSnapshot.getChildren()){
                        Citas citas = postSnapshot2.getValue(Citas.class);
                        if (null == citas.getEstatus())break;
                        switch (citas.getEstatus()){
                            case Constants.FB_KEY_ITEM_ESTATUS_ACTIVO:
                            case Constants.FB_KEY_ITEM_ESTATUS_INACTIVO:
                                laFecha = citas.getFecha();
                                if (laFecha.equals(fechaelegida )) {
                                    horasOcupadas.add(citas.getHora());
                                    System.out.println("Linea para llenar horasOcupadas");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };


        drCitas.addValueEventListener(listenerCitas);
        drHorario = database.getReference(Constants.FB_KEY_MAIN_DOCTORES).child(Constants.USUARIO_DOCTOR).child(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION);

        listenerHorario = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String mes = "12";
                String nombreDia = "12";
                String elanio = "2018";
                String inputDateStr = String.format("%s/%s/%s",nombreDia,mes,elanio);
                String diaDeSemana="";
                String horainicial,horafinal,duracion;
                try {
                    Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(inputDate);
                    int numDia;
                    numDia = cal.get(Calendar.DAY_OF_WEEK)-1;
                    diaDeSemana = numDia+"";
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }

                for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    HorariosDeAtencion jornada = postSnapshot.getValue(HorariosDeAtencion.class);
                    if (jornada.getDia().equals(diaDeSemana)){

                        horainicial = jornada.getHoraInicio();
                        horafinal = jornada.getHoraFin();
                        duracion = jornada.getDuracionDeCita();

                        String[]horasMinutos1 = horainicial.split(":");
                        String[]horasMinutos2 = horafinal.split(":");

                        String h1 = horasMinutos1[0];
                        String m1 = horasMinutos1[1];
                        String h2 = horasMinutos2[0];
                        String m2 = horasMinutos2[1];

                        int h11,m11,h22,m22,duracionCita;

                        //variables  para el For
                        h11 = Integer.parseInt(h1);
                        h22 = Integer.parseInt(h2);
                        m11 = Integer.parseInt(m1);
                        m22 = Integer.parseInt(m2);
                        duracionCita = Integer.parseInt(duracion);

                        System.out.println("Hora inicial: "+h11);
                        System.out.println("Hora Final: "+h22);
                        System.out.println("Duración de la Cita: "+duracionCita);

                        int minInicial = h11*60+m11;
                        int minFinal = h22*60+m22;
                        float modulo;
                        int mm;
                        System.out.println("Minuto inicial: "+minInicial);
                        System.out.println("Minuto Final: "+minFinal);


                        int tamanio = horasOcupadas.size();
                        boolean banderita;
                        switch (tamanio){
                            case 0:
                                banderita = false;
                                System.out.println(banderita);
                                break;
                            default:
                                banderita = true;
                                System.out.println(banderita);
                                break;
                        }

                        //if (tamanio!=0){banderita = true;}

                        for (int a = minInicial; a < minFinal; a= a+duracionCita ){
                            int lahora = a/60;
                            modulo = (((float)a/60)-lahora)*60;
                            mm = (int)modulo;

                            if (banderita){

                                for (int i = 0; i < tamanio; i++){
                                    String horita = horasLibres.get(i);
                                    String lis = lahora+":"+mm;

                                    if (lis.equals(horita)){
                                        System.out.println("Entró?" +i);
                                    }
                                }

                                System.out.println("Entró al if Linea: 388");
                            }
                            else{
                                horasLibres.add(lahora+":"+mm);

                                System.out.println("Entró al Else Linea: 412");
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        drHorario.addValueEventListener(listenerHorario);

        horasSpinner.setAdapter(adapterHorasLibres);



    }

}
