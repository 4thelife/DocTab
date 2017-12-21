package com.example.antonio.doctab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.DateTimeUtils;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText mNameField;
    private EditText mEmailFiedl;
    private EditText mPasswordField;

    private Button mRegisterButton;

    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;
    private TextView mTextLogin;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        mNameField = (EditText) findViewById(R.id.etxt_name);
        mEmailFiedl = (EditText) findViewById(R.id.etxt_email);
        mPasswordField = (EditText) findViewById(R.id.etxt_password);
        mRegisterButton = (Button) findViewById(R.id.btn_register);
        mTextLogin = (TextView) findViewById(R.id.txt_login);
        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mProgress = new ProgressDialog(this);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SignupActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

    }

    private void startRegister() {
        final String name = mNameField.getText().toString().trim();
        final String email = mEmailFiedl.getText().toString().trim();
        final String password = mPasswordField.getText().toString().trim();
        final String tipoDeUsuario = "Doctor";

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mProgress.setMessage("Por favor espere lo estamos registrando....");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            mProgress.dismiss();
                            if (task.isSuccessful()) {

                                Doctores doctor = new Doctores();

                                doctor.setNombreCompleto(name);
                                doctor.setCorreoElectronico(email);

                                doctor.setTipoDeUsuario(tipoDeUsuario);

                                doctor.setFirebaseId(mAuth.getCurrentUser().getUid());
                                doctor.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_INACTIVO);
                                doctor.setFechaDeCreacion(DateTimeUtils.getTimeStamp());
                                doctor.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

                                firebaseRegistroDoctor(doctor);

                            } else
                                Toast.makeText(SignupActivity.this, "Ha ocurrido un error al registrarse", Toast.LENGTH_SHORT).show();

                        }
                    });
        }

    }

    public void firebaseRegistroDoctor(final Doctores doctor) {

  /*obtiene la instancia como Doctor*/
        final DatabaseReference dbDoctor =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_DOCTORES)
                        .child(doctor.getFirebaseId())
                        .child(Constants.FB_KEY_ITEM_DOCTOR);

        dbDoctor.setValue(doctor, new DatabaseReference.CompletionListener() {

            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Usuarios usuario = new Usuarios();
                    usuario.setFirebaseId(doctor.getFirebaseId());
                    usuario.setTipoDeUsuario(doctor.getTipoDeUsuario());

                    firebaseRegistroUsuario(usuario);
                }
            }
        });


    }

    private void firebaseRegistroUsuario(Usuarios usuario) {

        DatabaseReference dbUsuario =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_USUARIOS)
                        .child(usuario.getFirebaseId());

        dbUsuario.setValue(usuario, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    sentEmailVerification();
                }
            }
        });


    }

    //Este método manda un link al correo registrado para verificarlo *Falta el código para verificar *
    public void sentEmailVerification() {
        FirebaseUser user = mAuth.getCurrentUser();

        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),
                            "Registrado correctamente...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
