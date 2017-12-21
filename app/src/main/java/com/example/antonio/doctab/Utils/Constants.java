package com.example.antonio.doctab.Utils;

import com.example.antonio.doctab.R;

import java.util.HashMap;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Constants {

    public static final String FB_KEY_ITEM_ESTATUS_INACTIVO = "inactivo";
    public static final String FB_KEY_ITEM_ESTATUS_ACTIVO = "activo";
    public static final String FB_KEY_ITEM_ESTATUS_ELIMINADO = "eliminado";
    public static final String FB_KEY_MAIN_DOCTORES = "doctores";
    public static final String FB_KEY_ITEM_DOCTOR = "doctor";
    public static final String FB_KEY_ITEM_CONSULTORIOS = "consultorios";
    public static final String FB_KEY_ITEM_CONSULTORIO_HORARIOS = "horarios";

    public static final String FB_KEY_ITEM_CONSULTORIO_DIRECCION = "direccion";
    public static final String FB_KEY_ITEM_PERFILES_ACADEMICOS = "perfilesAcademicos";

    public static final String FB_KEY_MAIN_USUARIOS = "usuarios";
    public static final String FB_KEY_ITEM_TIPO_USUARIO = "tipoDeUsuario";

    /**
     * Fragmentos principales de lista
     **/
    public static final String FRAGMENT_LISTADO_INICIO = "fragment_listado_inicio";

    public static final HashMap<Integer, String> ITEM_FRAGMENT;

    static {
        ITEM_FRAGMENT = new HashMap<>();
        ITEM_FRAGMENT.put(R.id.menu_item_inicio, FRAGMENT_LISTADO_INICIO);
    }


}
