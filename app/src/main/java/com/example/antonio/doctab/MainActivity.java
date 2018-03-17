package com.example.antonio.doctab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {

                    DatabaseReference dbUsuario =
                            FirebaseDatabase.getInstance().getReference()
                                    .child(Constants.FB_KEY_MAIN_USUARIOS)
                                    .child(user.getUid());

                    dbUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                /**Guarda en preferencias los datos de la session*/
                                saveSessionPreferences(dataSnapshot.getValue(Usuarios.class));
                                switch (dataSnapshot.getValue(Usuarios.class).getTipoDeUsuario()) {
                                    case Constants.FB_KEY_ITEM_TIPO_USUARIO_INDEFINIDO:
                                        /**Abre la segunda parte para completar el registro**/
                                        openSecondRegister();
                                        break;
                                    default:
                                        /**Usuario con credenciales validas**/
                                        openNavigationDrawer();
                                        break;
                                }
                            } else {
                                openLogin();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    openLogin();
                }
            }
        };

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void saveSessionPreferences(Usuarios usuario) {
        SharedPreferences prefsCredencials = getSharedPreferences(Constants.KEY_PREF_CREDENCIALS, Context.MODE_PRIVATE);

        SharedPreferences.Editor credencials = prefsCredencials.edit();
        credencials.putString(Constants.KEY_PREF_CREDENCIALS_FIREBASE_ID, usuario.getFirebaseId());
        credencials.putString(Constants.KEY_PREF_CREDENCIALS_TIPO_USUARIO, usuario.getTipoDeUsuario());
        credencials.putBoolean(Constants.KEY_PREF_CREDENCIALS_SESSION, true);
        credencials.putString(Constants.KEY_PREF_CREDENCIALS_NOMBRE, usuario.getNombre());
        credencials.commit();
    }

    private void openNavigationDrawer() {
        Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
        intent.putExtra(Constants.KEY_SESSION_USER, SharedPreferencesService.getUsuarioActual(getApplicationContext()));
        startActivity(intent);
        finish();
    }

    private void openSecondRegister() {
        Intent intent = new Intent(MainActivity.this, SecondRegisterActivity.class);
        intent.putExtra(Constants.KEY_SESSION_USER, SharedPreferencesService.getUsuarioActual(getApplicationContext()));
        startActivity(intent);
        finish();
    }

    private void openLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) mAuth.removeAuthStateListener(mAuthListener);
    }
}
