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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText mNameField;
    private EditText mAppatField;
    private EditText mApmatField;
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
        mAppatField = (EditText)findViewById(R.id.etxt_appat);
        mApmatField = (EditText)findViewById(R.id.etxt_apmat);
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
                    Intent intent = new Intent(SignupActivity.this, ActivityAccount.class);
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
        final String appat = mAppatField.getText().toString().trim();
        final String apmat = mApmatField.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mProgress.setMessage("Por favor espere lo estamos registrando....");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            mProgress.dismiss();
                            if (task.isSuccessful()) {
                                mAuth.signInWithEmailAndPassword(email, password);
                                //Toast.makeText(ActivityRegister.this, user_id, Toast.LENGTH_SHORT).show();

                                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                                DatabaseReference currentUserDB = mDatabase.child(mAuth.getCurrentUser().getUid());
                                currentUserDB.child("name").setValue(name);
                                currentUserDB.child("appat").setValue(appat);
                                currentUserDB.child("apmat").setValue(apmat);
                                currentUserDB.child("image").setValue("default");

                            } else
                                Toast.makeText(SignupActivity.this, "Ha ocurrido un error al registrarse", Toast.LENGTH_SHORT).show();

                        }
                    });
        }

    }
}
