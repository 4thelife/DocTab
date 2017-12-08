package com.example.antonio.doctab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText correo;
    EditText contra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText)findViewById(R.id.edcorreo);
        contra = (EditText)findViewById(R.id.edcontra);
    }

}
