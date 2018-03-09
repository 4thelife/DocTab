package com.example.antonio.doctab;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.Utils.DateTimeUtils;
import com.example.antonio.doctab.fragments.interfaces.MainRegisterInterface;
import com.example.antonio.doctab.helpers.ConsultoriosHelper;
import com.example.antonio.doctab.helpers.DecodeExtraHelper;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.helpers.DoctoresHelper;
import com.example.antonio.doctab.helpers.HorarioDeAtencionHelper;
import com.example.antonio.doctab.helpers.PacientesHelper;
import com.example.antonio.doctab.models.Consultorios;
import com.example.antonio.doctab.models.Doctores;
import com.example.antonio.doctab.models.HorariosDeAtencion;
import com.example.antonio.doctab.models.Pacientes;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by jvier on 04/09/2017.
 */

public class MainRegisterActivity extends AppCompatActivity implements MainRegisterInterface, DialogInterface.OnClickListener {

    private static final String TAG = MainRegisterActivity.class.getSimpleName();

    private DecodeExtraHelper _MAIN_DECODE;
    private Usuarios _SESSION_USER;
    private static DecodeItemHelper _decodeItem;
    public static ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main_register);
        setSupportActionBar(toolbar);

        _MAIN_DECODE = (DecodeExtraHelper) getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);
        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getApplicationContext());

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        this.onPreRender();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getSupportActionBar().setTitle(_MAIN_DECODE.getTituloActividad());
        getSupportActionBar().setSubtitle(_MAIN_DECODE.getTituloFormulario());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_main_register_container);
        if (null != fragment.getFragmentManager().getFragments()) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void onPreRender() {
        openFragment(_MAIN_DECODE.getFragmentTag());
    }

    /**
     * Abre el fragmento mediante el tag seleccionado
     **/
    private void openFragment(String tag) {

        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        FragmentTransaction mainFragment = getSupportFragmentManager().beginTransaction();
        mainFragment.replace(R.id.fragment_main_register_container, Constants.TAG_FRAGMENT.get(tag), tag);
        mainFragment.addToBackStack(tag);
        mainFragment.commit();

        pDialog.dismiss();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void openExternalActivity(int action, Class<?> externalActivity) {
        DecodeExtraHelper extraParams = new DecodeExtraHelper();

        extraParams.setTituloActividad(getString(Constants.TITLE_ACTIVITY.get(_decodeItem.getIdView())));
        extraParams.setTituloFormulario(getString(Constants.TITLE_FORM_ACTION.get(action)));
        extraParams.setAccionFragmento(action);
        extraParams.setFragmentTag(Constants.ITEM_FRAGMENT.get(_decodeItem.getIdView()));
        extraParams.setDecodeItem(_decodeItem);

        Intent intent = new Intent(this, externalActivity);
        intent.putExtra(Constants.KEY_MAIN_DECODE, extraParams);
        //intent.putExtra(Constants.KEY_SESSION_USER, _SESSION_USER);
        startActivity(intent);
    }

    @Override
    public void showQuestion(String titulo, String mensage) {

    }

    @Override
    public void setDecodeItem(DecodeItemHelper decodeItem) {

    }

    @Override
    public void registrarDoctor(DoctoresHelper helper) {
        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        webServiceRegistrarDoctor(helper);

    }

    private void webServiceRegistrarDoctor(DoctoresHelper helper) {
        /**Se obtiene el objeto principal**/
        final Doctores data = helper.getDoctor();

        /**Se crea la conexion con los nodos a utilizar**/
        final DatabaseReference dbConsultorios =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_DOCTORES)
                        .child(data.getFirebaseId());

        /**Se agregan los ultimos objetos del sistema**/
        data.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO);
        data.setFechaDeCreacion(DateTimeUtils.getTimeStamp());
        data.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

        final Usuarios usuario = new Usuarios();
        usuario.setFirebaseId(data.getFirebaseId());
        usuario.setTipoDeUsuario(data.getTipoDeUsuario());

        try {
            /**Se crea la conexion para guadar el objeto**/
            dbConsultorios.child(Constants.FB_KEY_ITEM_DOCTOR).child(data.getFirebaseId()).setValue(data, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    pDialog.dismiss();
                    if (databaseError == null) {
                        actualizarPermisos(usuario);
                    }
                }
            });
        } catch (Exception e) {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Intente mas tarde...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    @Override
    public void editarDoctor(DoctoresHelper helper) {

    }

    @Override
    public void registrarPaciente(PacientesHelper helper) {
        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        webServiceRegistrarPaciente(helper);

    }

    private void webServiceRegistrarPaciente(PacientesHelper helper) {
        /**Se obtiene el objeto principal**/
        final Pacientes data = helper.getPaciente();

        /**Se crea la conexion con los nodos a utilizar**/
        final DatabaseReference dbConsultorios =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_PACIENTES)
                        .child(data.getFirebaseId());

        /**Se agregan los ultimos objetos del sistema**/
        data.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO);
        data.setFechaDeCreacion(DateTimeUtils.getTimeStamp());
        data.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

        final Usuarios usuario = new Usuarios();
        usuario.setFirebaseId(data.getFirebaseId());
        usuario.setTipoDeUsuario(data.getTipoDeUsuario());

        try {
            /**Se crea la conexion para guadar el objeto**/
            dbConsultorios.child(Constants.FB_KEY_ITEM_PACIENTE).child(data.getFirebaseId()).setValue(data, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    pDialog.dismiss();
                    if (databaseError == null) {
                        actualizarPermisos(usuario);
                    }
                }
            });
        } catch (Exception e) {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Intente mas tarde...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    @Override
    public void editarPaciente(PacientesHelper helper) {

    }

    private void actualizarPermisos(final Usuarios usuario) {
        /**Se actualizan los permisos cuando son usuarios nuevos**/
        DatabaseReference dbUsuario =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_USUARIOS)
                        .child(usuario.getFirebaseId());

        dbUsuario.setValue(usuario, new DatabaseReference.CompletionListener() {

            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                if (databaseError == null) {
                    deleteIndefinido(usuario);
                }
            }
        });

    }

    private void deleteIndefinido(Usuarios usuario) {
        /**obtiene la instancia del elemento**/
        DatabaseReference dbCliente =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_INDEFINIDOS)
                        .child(usuario.getFirebaseId());

        dbCliente.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Toast.makeText(getApplicationContext(),
                        "Registo finalizado...", Toast.LENGTH_LONG).show();
                openSimpleActivity(MainActivity.class);
            }
        });
    }

    private void openSimpleActivity(Class<?> cls) {
        Intent intent = new Intent(MainRegisterActivity.this, cls);
        startActivity(intent);
        finish();
    }


    @Override
    public void registrarConsultorio(ConsultoriosHelper helper) {
        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        webServiceRegistrarConsultorio(helper);

    }

    private void webServiceRegistrarConsultorio(ConsultoriosHelper helper) {
        /**Se obtiene el objeto principal**/
        Consultorios data = helper.getConsultorio();

        /**Se crea la conexion con los nodos a utilizar**/
        final DatabaseReference dbConsultorios =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_DOCTORES)
                        .child(helper.getConsultorio().getFireBaseIdDoctor());

        /**Se crea el firebaseID en el futuro nodo**/
        String firebaseIDConsultorio = dbConsultorios.child(Constants.FB_KEY_ITEM_CONSULTORIOS).push().getKey();

        /**Se agregan los ultimos objetos del sistema**/
        data.setFireBaseId(firebaseIDConsultorio);
        data.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO);
        data.setFechaDeCreacion(DateTimeUtils.getTimeStamp());
        data.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

        try {
            /**Se crea la conexion para guadar el objeto**/
            dbConsultorios.child(Constants.FB_KEY_ITEM_CONSULTORIOS).child(data.getFireBaseId())
                    .setValue(data, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            pDialog.dismiss();
                            if (databaseError == null) {
                                finish();
                                Toast.makeText(getApplicationContext(),
                                        "Registrado correctamente...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        } catch (Exception e) {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Intente mas tarde...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void editarConsultorio(ConsultoriosHelper helper) {
        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        webServiceEditarConsultorio(helper);

    }

    private void webServiceEditarConsultorio(ConsultoriosHelper helper) {
        /**Se obtiene el objeto principal**/
        Consultorios data = helper.getConsultorio();

        /**Se crea la conexion con los nodos a utilizar**/
        final DatabaseReference dbConsultorios =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_DOCTORES)
                        .child(helper.getConsultorio().getFireBaseIdDoctor())
                        .child(Constants.FB_KEY_ITEM_CONSULTORIOS);

        data.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO);
        data.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

        try {
            /**Se crea la conexion para actualizar el objeto apuntando al firebaseID a modificar**/
            dbConsultorios.child(data.getFireBaseId())
                    .setValue(data, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            pDialog.dismiss();
                            if (databaseError == null) {
                                finish();
                                Toast.makeText(getApplicationContext(),
                                        "Actualizado correctamente...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        } catch (Exception e) {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Intente mas tarde...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }



    @Override
    public void registrarHorariosDeAtencion(HorarioDeAtencionHelper helper) {
        pDialog = new ProgressDialog(MainRegisterActivity.this);
        pDialog.setMessage(getString(R.string.default_loading_msg));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        webServiceRegistrarHorariosDeAtencion(helper);

    }

    private void webServiceRegistrarHorariosDeAtencion(HorarioDeAtencionHelper helper) {
        /**Se obtiene el objeto principal**/
        HorariosDeAtencion data = helper.getHorariosDeAtencion();

        /**Se crea la conexion con los nodos a utilizar**/
        final DatabaseReference dbHorariosDeAtencion =
                FirebaseDatabase.getInstance().getReference()
                        .child(Constants.FB_KEY_MAIN_DOCTORES)
                        .child(helper.getHorariosDeAtencion().getFireBaseIdDoctor());

        /**Se crea el firebaseID en el futuro nodo**/
        String firebaseIDHorarioDeAtencion = dbHorariosDeAtencion.child(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION).push().getKey();

        /**Se agregan los ultimos objetos del sistema**/
        data.setFireBaseId(firebaseIDHorarioDeAtencion);
        data.setEstatus(Constants.FB_KEY_ITEM_ESTATUS_ACTIVO);
        data.setFechaDeCreacion(DateTimeUtils.getTimeStamp());
        data.setFechaDeEdicion(DateTimeUtils.getTimeStamp());

        try {
            /**Se crea la conexion para guadar el objeto**/
            dbHorariosDeAtencion.child(Constants.FB_KEY_ITEM_HORARIOS_DE_ATENCION).child(data.getFireBaseId())
                    .setValue(data, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            pDialog.dismiss();
                            if (databaseError == null) {
                                finish();
                                Toast.makeText(getApplicationContext(),
                                        "Registrado correctamente...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        } catch (Exception e) {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Intente mas tarde...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }





}

