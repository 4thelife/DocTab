package com.example.antonio.doctab.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;


import com.example.antonio.doctab.R;
import com.example.antonio.doctab.models.HorariosDeAtencion;

import java.util.Calendar;

/**
 * Created by Ricardo on 21/02/2018.
 */

public class FormularioHorariosDeAtencionFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = FormularioHorariosDeAtencionFragment.class.getSimpleName();

    TextView agregar_hora_entrada;
    TextView agregar_hora_fin;
    ToggleButton tgb0, tgb1, tgb2, tgb3, tgb4, tgb5, tgb6;
    Calendar currentTime;
    Boolean dia0,dia1,dia2,dia3,dia4,dia5,dia6 = false;
    int hour,minute;
    String format;

    public static HorariosDeAtencion _horarioDeATencionActual;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_formulario_horarios_de_atencion, container,
                false);


        agregar_hora_entrada = (TextView) view.findViewById(R.id.tv_agregar_hora_entrada);
        agregar_hora_fin = (TextView) view.findViewById(R.id.tv_agregar_hora_salida);
        tgb0 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_0);
        tgb1 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_1);
        tgb2 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_2);
        tgb3 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_3);
        tgb4 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_4);
        tgb5 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_5);
        tgb6 = (ToggleButton) view.findViewById(R.id.tgBtn_dia_6);

        currentTime = Calendar.getInstance();

        hour = currentTime.get(Calendar.HOUR_OF_DAY);

        minute =currentTime.get(Calendar.MINUTE);

        agregar_hora_entrada.setText(hour+":"+minute);
        agregar_hora_fin.setText(hour+":"+minute);

        agregar_hora_entrada.setOnClickListener(this);
        agregar_hora_fin.setOnClickListener(this);



        tgb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia0=true; }else{ dia0=false; }
            }
        });

        tgb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia1=true; }else{ dia1=false; }
            }
        });
        tgb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia2=true; }else{ dia2=false; }
            }
        });
        tgb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia3=true; }else{ dia3=false; }
            }
        });

        tgb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia4=true; }else{ dia4=false; }
            }
        });
        tgb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia5=true; }else{ dia5=false; }
            }
        });
        tgb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ dia6=true; }else{ dia6=false; }
            }
        });



        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

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



    private void onPreRender(){

    }

    private void obtenerHorariosServicio(){

    }

    /**
     * public void setHorariosDeAtencion(HorariosDeAtencion data){
     *
     *  }
     */
}
