package com.example.antonio.doctab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondRegisterActivity extends AppCompatActivity {

    private static final String TAG = SecondRegisterActivity.class.getSimpleName();

    private DecodeExtraHelper _MAIN_DECODE;
    private Usuarios _SESSION_USER;
    private static DecodeItemHelper _decodeItem;
    public static ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);

        _MAIN_DECODE = (DecodeExtraHelper) getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkSession();
    }

    private void checkSession() {
        DatabaseReference dbUsuario =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_USUARIOS)
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        dbUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    switch (dataSnapshot.getValue(Usuarios.class).getTipoDeUsuario()) {
                        case Constants.FB_KEY_ITEM_TIPO_USUARIO_INDEFINIDO:
                            /**Abre la segunda parte para completar el registro**/
                            onPreRender();
                            break;
                        default:
                            /**Usuario con credenciales validas**/
                            openNavigationDrawer();
                            break;
                    }
                } else {
                    openSimpleActivity(MainActivity.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_second_register_container);
        if (null == fragment.getFragmentManager().getFragments()) {
            super.onBackPressed();
        }
    }

    private void onPreRender() {
        openFragment(Constants.FRAGMENT_REGISTRO_INDEFINIDOS);
    }

    /**
     * Abre el fragmento mediante el tag seleccionado
     **/
    private void openFragment(String tag) {
        FragmentTransaction mainFragment = getSupportFragmentManager().beginTransaction();
        mainFragment.replace(R.id.fragment_second_register_container, Constants.TAG_FRAGMENT.get(tag), tag);
        mainFragment.addToBackStack(tag);
        mainFragment.commit();
    }

    private void openNavigationDrawer() {
        Intent intent = new Intent(SecondRegisterActivity.this, NavigationDrawerActivity.class);
        intent.putExtra(Constants.KEY_SESSION_USER, SharedPreferencesService.getUsuarioActual(getApplicationContext()));
        startActivity(intent);
        finish();
    }

    private void openSimpleActivity(Class<?> cls) {
        Intent intent = new Intent(SecondRegisterActivity.this, cls);
        startActivity(intent);
        finish();
    }
}
