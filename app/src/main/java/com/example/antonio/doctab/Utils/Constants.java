package com.example.antonio.doctab.Utils;


import android.support.v4.app.Fragment;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.ListadoConsultoriosFragment;
import com.example.antonio.doctab.fragments.ListadoInicioFragment;

import java.util.HashMap;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Constants {

    public static final String FB_KEY_ITEM_ESTATUS_INACTIVO = "inactivo";
    public static final String FB_KEY_ITEM_ESTATUS_ACTIVO = "activo";
    public static final String FB_KEY_ITEM_ESTATUS_ELIMINADO = "eliminado";
    public static final String FB_KEY_MAIN_DOCTORES = "doctores";
    public static final String FB_KEY_MAIN_PACIENTES = "pacientes";
    public static final String FB_KEY_ITEM_DOCTOR = "doctor";
    public static final String FB_KEY_ITEM_CONSULTORIOS = "consultorios";
    public static final String FB_KEY_ITEM_CONSULTORIO_HORARIOS = "horarios";
    public static final String FB_KEY_ITEM_CONSULTORIO_DIRECCION = "direccion";
    public static final String FB_KEY_ITEM_PERFILES_ACADEMICOS = "perfilesAcademicos";
    public static final String FB_KEY_MAIN_USUARIOS = "usuarios";
    public static final String FB_KEY_ITEM_TIPO_USUARIO = "tipoDeUsuario";
    public static final String FB_KEY_ITEM_FIREBASE_ID = "firebaseId";

    /**
     * Key Extras
     **/
    public static final String KEY_MAIN_DECODE = "key_main_decode";
    public static final String KEY_SESSION_USER = "key_session_users";

    /**
     * Key Preferences
     */
    public static final String KEY_PREF_CREDENCIALS = "key_pref_credencials";
    public static final String KEY_PREF_CREDENCIALS_TIPO_USUARIO = "key_pref_credencials_tipo_usuario";
    public static final String KEY_PREF_CREDENCIALS_FIREBASE_ID = "key_pref_credencials_firebase_id";
    public static final String KEY_PREF_CREDENCIALS_SESSION = "key_pref_credencials_session";

    /**
     * Fragmentos principales de lista
     **/
    public static final String FRAGMENT_LISTADO_INICIO = "fragment_listado_inicio";
    public static final String FRAGMENT_LISTADO_CONSULTORIO = "fragment_listado_consultorio";

    /**
     * Fragmentos segundarios
     **/
    public static final String FRAGMENT_INICIOS = "fragment_inicios";

    public static final HashMap<Integer, String> ITEM_FRAGMENT;

    static {
        ITEM_FRAGMENT = new HashMap<>();
        ITEM_FRAGMENT.put(R.id.menu_item_inicio, FRAGMENT_LISTADO_INICIO);
        ITEM_FRAGMENT.put(R.id.menu_item_consultorios_doctor, FRAGMENT_LISTADO_CONSULTORIO);
    }

    public static final HashMap<String, Fragment> TAG_FRAGMENT;

    static {
        TAG_FRAGMENT = new HashMap<>();
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_INICIO, new ListadoInicioFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CONSULTORIO, new ListadoConsultoriosFragment());
    }


}
