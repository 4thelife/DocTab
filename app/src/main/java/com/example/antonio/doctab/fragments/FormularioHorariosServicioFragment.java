package com.example.antonio.doctab.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.antonio.doctab.R;

import java.util.Calendar;

/**
 * Created by Ricardo on 21/02/2018.
 */

public class FormularioHorariosServicioFragment extends Fragment implements View.OnClickListener{

    TextView agregar_hora_entrada;
    TextView hora_salida;
    Calendar currentTime;
    int hour,minute;
    String format;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_horarios_servicio, container,
                false);


        agregar_hora_entrada = (TextView) view.findViewById(R.id.tv_agregar_hora_entrada);

        currentTime = Calendar.getInstance();

        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute =currentTime.get(Calendar.MINUTE);

        agregar_hora_entrada.setText(hour+":"+minute+" "+format);

        agregar_hora_entrada.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_agregar_hora_entrada:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        selectedTimeFormat(hour);
                        agregar_hora_entrada.setText(hour+":"+minute+" "+format);
                    }
                },hour,minute,true);
                timePickerDialog.show();
                break;
            case R.id.tv_agregar_hora_salida:
                /**
                 * Aqui va el codigo para hacer funcionar la hora de salida
                 */
                break;
        }



    }


    private void selectedTimeFormat(int hour) {

        if(hour==0){
            hour +=12;
            format = "AM";
        }else if(hour == 12){
            format="PM";
        }else if(hour >12){
            hour-=12;
            format="PM";
        }else{
            format="AM";
        }

    }
}
