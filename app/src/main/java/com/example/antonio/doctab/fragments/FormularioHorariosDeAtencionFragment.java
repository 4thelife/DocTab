package com.example.antonio.doctab.fragments;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.helpers.HorarioDeAtencionHelper;
import com.example.antonio.doctab.models.HorariosDeAtencion;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.Calendar;

/**
 * Created by Ricardo on 21/02/2018.
 */

public class FormularioHorariosDeAtencionFragment extends Fragment implements View.OnClickListener{


    private static final String TAG = FormularioHorariosDeAtencionFragment.class.getSimpleName();

    private static DecodeExtraHelper _MAIN_DECODE;
    private static Usuarios _SESSION_USER;
    //Se asignan los dias en el array
    int semana [] = new int[7];
    public static boolean bandera[] = new boolean[7];
    public static String horaini,horafin;
    /**
     * Se declaran los elementos del formulario
     **/
    TextView agregar_hora_entrada;
    TextView agregar_hora_fin;
    ToggleButton tgb0, tgb1, tgb2, tgb3, tgb4, tgb5, tgb6;
    static Spinner sp_duracion_cita;
    Calendar currentTime;
    Boolean dia0,dia1,dia2,dia3,dia4,dia5,dia6 = false;
    int hour,minute;
    String format;

    /**
     * Se declaran las variables para uso en memoria
     **/
    public static HorariosDeAtencion _horarioDeATencionActual;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_formulario_horarios_de_atencion, container, false);

        /**Se inicializan las variables globales**/
        _MAIN_DECODE = (DecodeExtraHelper) getActivity().getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());

        /**Se inicializan los elementos del formulario**/

        agregar_hora_entrada = (TextView) view.findViewById(R.id.tv_agregar_hora_entrada);
        agregar_hora_fin = (TextView) view.findViewById(R.id.tv_agregar_hora_salida);
        tgb0 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_0);
        tgb1 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_1);
        tgb2 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_2);
        tgb3 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_3);
        tgb4 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_4);
        tgb5 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_5);
        tgb6 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_6);
        sp_duracion_cita = (Spinner)view.findViewById(R.id.sp_duracion_consulta);
        currentTime = Calendar.getInstance();

        hour = currentTime.get(Calendar.HOUR_OF_DAY);

        minute =currentTime.get(Calendar.MINUTE);

        //agregar_hora_entrada.setText(hour+":"+minute);
        //agregar_hora_fin.setText(hour+":"+minute);




        horaini = agregar_hora_entrada.getText().toString();
        horafin = agregar_hora_fin.getText().toString();
        agregar_hora_entrada.setOnClickListener(this);
        agregar_hora_fin.setOnClickListener(this);

        tgb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[0]=true; }else{ bandera[0]= false; }
            }
        });
        tgb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[1]=true; }else{ bandera[1]=false; }
            }
        });
        tgb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[2]=true; }else{ bandera[2]=false; }
            }
        });
        tgb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[3]=true; }else{ bandera[3]=false; }
            }
        });
        tgb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[4]=true; }else{ bandera[4]=false; }
            }
        });
        tgb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[5]=true; }else{ bandera[5]=false; }
            }
        });
        tgb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ bandera[6]=true; }else{ bandera[6]=false; }
            }
        });


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId()) {
            case R.id.tv_agregar_hora_entrada:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        agregar_hora_entrada.setText(hour+":"+minute);
                    }
                },hour,minute,true);
                timePickerDialog.show();
                break;
            case R.id.tv_agregar_hora_salida:
                TimePickerDialog timePickerDialog1 = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        agregar_hora_fin.setText(hour+":"+minute);
                    }
                },hour,minute,true);
                timePickerDialog1.show();
                break;
        }



    }

    @Override
    public void onStart() {
        super.onStart();
        onPreRender();
    }


    private void onPreRender(){
        switch (_MAIN_DECODE.getAccionFragmento()) {
            case Constants.ACCION_EDITAR:
            case Constants.ACCION_VER:
                this.obtenerHorariosDeAtencion();
                break;
            case Constants.ACCION_REGISTRAR:
                _horarioDeATencionActual = new HorariosDeAtencion();
                break;
            default:
                break;
        }
    }

    private void obtenerHorariosDeAtencion(){
        /**Obtiene el item selecionado en el fragmento de lista**/
        HorariosDeAtencion horariosDeAtencion = (HorariosDeAtencion) _MAIN_DECODE.getDecodeItem().getItemModel();

        DatabaseReference drHorarioDeAtencion = FirebaseDatabase.getInstance()
                .getReference(Constants.FB_KEY_MAIN_DOCTORES)
                .child(_SESSION_USER.getFirebaseId())
                .child(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION)
                .child(horariosDeAtencion.getFireBaseId());

        final ProgressDialog pDialogRender = new ProgressDialog(getContext());
        pDialogRender.setMessage(getString(R.string.default_loading_msg));
        pDialogRender.setIndeterminate(false);
        pDialogRender.setCancelable(false);
        pDialogRender.show();

        drHorarioDeAtencion.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HorariosDeAtencion horariosDeAtencion = dataSnapshot.getValue(HorariosDeAtencion.class);
                /**Se asigna el ¿Día? actual a la memoria**/
                _horarioDeATencionActual = horariosDeAtencion;

                /**Asigna los valores al formulario**/
                agregar_hora_entrada.setText(horariosDeAtencion.getHoraInicio());
                agregar_hora_fin.setText(horariosDeAtencion.getHoraFin());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Error intentando obtener datos ...");
                pDialogRender.dismiss();
            }
        });
    }

    public void registrar(){

        for (int i=0; i<7; i++)
        {
            if (bandera[i]== true){

                HorariosDeAtencion data = new HorariosDeAtencion();
                data.setHoraInicio(horaini);
                data.setHoraFin(horafin);
                data.setDuracionDeCita(sp_duracion_cita.getSelectedItem().toString());
                data.setDia(String.valueOf(i));

                data.setFireBaseId(_SESSION_USER.getFirebaseId());
                data.setEstatus(_horarioDeATencionActual.getEstatus());
                data.setFireBaseIdDoctor(_horarioDeATencionActual.getFireBaseIdDoctor());
                setHorariosDeAtencion(data);
                AccionesHorariosDeAtencionFragment  accionesHorariosDeAtencionFragment = new AccionesHorariosDeAtencionFragment();
                accionesHorariosDeAtencionFragment.registrar();

            }

        }

    }

    public static void setHorariosDeAtencion(HorariosDeAtencion data){
        _horarioDeATencionActual.setDia(data.getDia());
        _horarioDeATencionActual.setDuracionDeCita(data.getDuracionDeCita());
        _horarioDeATencionActual.setHoraInicio(data.getHoraInicio());
        _horarioDeATencionActual.setHoraFin(data.getHoraFin());
        /**Se declaran valores que el sistema debe llenar**/
        _horarioDeATencionActual.setFireBaseId(data.getFireBaseId());
        _horarioDeATencionActual.setFireBaseIdDoctor(data.getFireBaseIdDoctor());


    }


}
