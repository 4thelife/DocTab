package com.example.antonio.doctab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private EditText textEmail;
    private EditText textPass;
    private Button btnRegister;
    private Button btnRegistrando;
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        textEmail = (EditText) findViewById(R.id.edcorreo);
        textPass = (EditText) findViewById(R.id.edcontra);
        btnRegister = (Button) findViewById(R.id.btn_login);
        btnRegistrando = (Button) findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        btnRegistrando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    //Toast.makeText(LoginActivity.this, "Ahora estás logeado en " + firebaseAuth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    //mAuth.signOut();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    private void doLogin() {
        String email = textEmail.getText().toString().trim();
        String password = textPass.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            progressDialog.setMessage("Entrando , porfavor espere");
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                //Toast.makeText(LoginActivity.this, "Inicio de sesión exitosa", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


}
