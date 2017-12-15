package com.example.antonio.doctab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Declaraciones para firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtiene la instancia compartida del objeto FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
    }

    protected void onStart() {
        super.onStart();

        /*Responde a los cambios de estato en la session*/
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {

                    Intent intent = new Intent(MainActivity.this,ActivityAccount.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, "Pendiente crear navigationDrawer", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) mAuth.removeAuthStateListener(mAuthListener);
    }
}
