package com.example.antonio.doctab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_agregar_horario extends AppCompatActivity {
    Button btn_guardar_diaHora,btn_cancelar_diaHora;
    Spinner sp_dias,sp_hora_inicial,sp_minuto_inicial,sp_hora_final,sp_minuto_final;
    String[] dias,horas,minutos;
    private boolean isFirstTime = true;
    TextView diaselec,horaa1,horaa2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_horario);

        diaselec = (TextView)findViewById(R.id.diaSeleccionado);

        horaa1 = (TextView)findViewById(R.id.lahora1);
        horaa2 = (TextView)findViewById(R.id.lahora2);

        btn_guardar_diaHora = (Button)findViewById(R.id.btn_guardar_diaHora);
        btn_cancelar_diaHora = (Button)findViewById(R.id.btn_cancelar_diaHora);

        btn_guardar_diaHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_agregar_horario.this,ActivityAccount.class);
                startActivity(intent);
                finish();
            }
        });

        btn_cancelar_diaHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        sp_dias = (Spinner)findViewById(R.id.sp_dias);
        sp_hora_inicial = (Spinner)findViewById(R.id.sp_hora_inicial);
        sp_minuto_inicial=(Spinner)findViewById(R.id.sp_minuto_inicial);
        sp_hora_final = (Spinner)findViewById(R.id.sp_hora_final);
        sp_minuto_final = (Spinner)findViewById(R.id.sp_minuto_final);


        dias = getResources().getStringArray(R.array.lista_dias);
        ArrayAdapter<String> diaAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,dias);
        diaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        horas = getResources().getStringArray(R.array.lista_horas);
        ArrayAdapter<String> horaAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,horas);
        horaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        minutos = getResources().getStringArray(R.array.lista_minutos);
        ArrayAdapter<String> minutosAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,minutos);
        minutosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_dias.setAdapter(diaAdapter);
        sp_dias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (isFirstTime){
                    isFirstTime= false;
                    diaselec.setText(dias[i]);

                }
                else {
                    diaselec.setText(dias[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_hora_inicial.setAdapter(horaAdapter);
        sp_hora_inicial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sep;
                sep = ":";
                if (isFirstTime){
                    isFirstTime= false;

                }
                else {
                    horaa1.setText(horas[i]+sep);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_minuto_inicial.setAdapter(minutosAdapter);
        sp_minuto_inicial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String horaini;

                if (isFirstTime){
                    isFirstTime = false;
                }
                else{
                    horaini = horaa1.getText().toString();
                    horaa1.setText(horaini+minutos[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        sp_hora_final.setAdapter(horaAdapter);
        sp_hora_final.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sep;
                sep = ":";
                if (isFirstTime){
                    isFirstTime = false;
                }
                else{
                    horaa2.setText(horas[i]+sep);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_minuto_final.setAdapter(minutosAdapter);
        sp_minuto_final.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String horaini;

                if (isFirstTime){
                    isFirstTime = false;
                }
                else{
                    horaini = horaa2.getText().toString();
                    horaa2.setText(horaini+minutos[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
