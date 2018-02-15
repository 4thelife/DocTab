package com.example.antonio.doctab.Utils;


import android.support.v4.app.Fragment;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.CitasFragment;
import com.example.antonio.doctab.fragments.ConsultoriosFragment;
import com.example.antonio.doctab.fragments.DoctoresFragment;
import com.example.antonio.doctab.fragments.EspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioCitasFragment;
import com.example.antonio.doctab.fragments.FormularioConsultorioFragment;
import com.example.antonio.doctab.fragments.FormularioDoctoresFragment;
import com.example.antonio.doctab.fragments.FormularioEspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioPacientesFragment;
import com.example.antonio.doctab.fragments.FormularioServiciosFragment;
import com.example.antonio.doctab.fragments.ListadoCitasDoctorFragment;
import com.example.antonio.doctab.fragments.ListadoConsultoriosFragment;
import com.example.antonio.doctab.fragments.ListadoDoctoresFragment;
import com.example.antonio.doctab.fragments.ListadoEspecialidadesFragment;
import com.example.antonio.doctab.fragments.ListadoInicioFragment;
import com.example.antonio.doctab.fragments.ListadoPacientesDoctorFragment;
import com.example.antonio.doctab.fragments.ListadoServiciosFragment;
import com.example.antonio.doctab.fragments.PacientesFragment;
import com.example.antonio.doctab.fragments.RegistroCitasFragment;
import com.example.antonio.doctab.fragments.RegistroConsultoriosFragment;
import com.example.antonio.doctab.fragments.RegistroDoctoresFragment;
import com.example.antonio.doctab.fragments.RegistroEspecialidadesFragment;
import com.example.antonio.doctab.fragments.RegistroPacientesFragment;
import com.example.antonio.doctab.fragments.RegistroServiciosFragment;
import com.example.antonio.doctab.fragments.ServiciosFragment;

import java.util.HashMap;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Constants {

    /**
     * Acciones generales
     **/
    public static final int ACCION_SIN_DEFINIR = 0;
    public static final int ACCION_REGISTRAR = 1;
    public static final int ACCION_EDITAR = 2;

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
    public static final String FRAGMENT_LISTADO_CITAS_DOCTOR = "fragment_listado_citas_doctor";
    public static final String FRAGMENT_LISTADO_CONSULTORIOS = "fragment_listado_consultorios";
    public static final String FRAGMENT_LISTADO_DOCTORES = "fragment_listado_doctores";
    public static final String FRAGMENT_LISTADO_ESPECIALIDADES = "fragment_listado_especialidades";
    public static final String FRAGMENT_LISTADO_INICIO = "fragment_listado_inicio";
    public static final String FRAGMENT_LISTADO_PACIENTES_DOCTOR = "fragment_listado_pacientes_doctor";
    public static final String FRAGMENT_LISTADO_SERVICIOS = "fragment_listado_servicios";

    /**
     * Fragmentos segundarios
     **/
    public static final String FRAGMENT_INICIOS = "fragment_inicios";
    public static final String FRAGMENT_CONSULTORIOS = "fragment_consultorios";
    public static final String FRAGMENT_DOCTOR = "fragment_doctor";
    public static final String FRAGMENT_CITAS = "fragment_citas";
    public static final String FRAGMENT_CITAS_DOCTOR = "fragment_citas_doctor";
    public static final String FRAGMENT_ESPECIALIDADES = "fragment_especialidades";
    public static final String FRAGMENT_SERVICIOS = "fragment_servicios";
    public static final String FRAGMENT_PACIENTE = "fragment_pacientes";



    /***
     * Fragmentos Formularios
     */

    public static final String FRAGMENT_FORMULARIO_CONSULTORIOS = "fragment_formulario_consultorios";
    public static final String FRAGMENT_FORMULARIO_DOCTOR = "fragment_formulario_doctor";
    public static final String FRAGMENT_FORMULARIO_ESPECIALIDADES = "fragment_formulario_especialidades";
    public static final String FRAGMENT_FORMULARIO_PACIENTES = "fragment_formulario_pacientes";
    public static final String FRAGMENT_FORMULARIO_SERVICIOS = "fragment_formulario_servicios";
    public static final String FRAGMENT_FORMULARIO_CITAS = "fragment_formulario_citas";


    /**
     * Fragmentos de Registro*/
    public static final String FRAGMENT_REGISTRO_CONSULTORIOS = "fragment_registro_consultorios";
    public static final String FRAGMENT_REGISTRO_DOCTOR = "fragment_registro_doctor";
    public static final String FRAGMENT_REGISTRO_ESPECIALIDADES = "fragment_registro_especialidades";
    public static final String FRAGMENT_REGISTRO_PACIENTES = "fragment_registro_pacientes";
    public static final String FRAGMENT_REGISTRO_SERVICIO = "fragment_registro_servicio";
    public static final String FRAGMENT_REGISTRO_CITAS = "fragment_registro_citas";


    /**
     * Fragmentos de ITEM
     */
    public static final String FRAGMENT_ITEM_CITAS = "fragment_item_citas";
    public static final String FRAGMENT_ITEM_CONSULTORIOS = "fragment_item_consultorios";
    public static final String FRAGMENT_ITEM_DOCTOR = "fragment_item_doctor";
    public static final String FRAGMENT_ITEM_ESPECIALIDADES = "fragment_item_especialidades";
    public static final String FRAGMENT_ITEM_PACIENTES = "fragment_item_pacientes";
    public static final String FRAGMENT_ITEM_SERVICIOS = "fragment_item_servicios";

    public static final HashMap<Integer, String> ITEM_FRAGMENT;

    static {
        ITEM_FRAGMENT = new HashMap<>();
        ITEM_FRAGMENT.put(R.id.menu_item_inicio, FRAGMENT_LISTADO_INICIO);

        /**CONSULTORIOS*/
        ITEM_FRAGMENT.put(R.id.menu_item_consultorios_doctor, FRAGMENT_LISTADO_CONSULTORIOS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_consultorio, FRAGMENT_LISTADO_CONSULTORIOS);

        /**DOCTOR*/
        //ITEM_FRAGMENT.put(R.id.menu_item_doctor, FRAGMENT_LISTADO_DOCTORES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_doctor,FRAGMENT_REGISTRO_DOCTOR);

        /**CITAS*/
        ITEM_FRAGMENT.put(R.id.menu_item_citas_doctor, FRAGMENT_LISTADO_CITAS_DOCTOR);
        ITEM_FRAGMENT.put(R.id.btn_agregar_citas_doctor,FRAGMENT_LISTADO_CITAS_DOCTOR);

        /**ESPECIAIIDADES*/

        ITEM_FRAGMENT.put(R.id.btn_agregar_especialidades,FRAGMENT_LISTADO_ESPECIALIDADES);

        /**PACIENTES*/
        ITEM_FRAGMENT.put(R.id.btn_agregar_paciente_doctor,FRAGMENT_LISTADO_PACIENTES_DOCTOR);

        /**SERVICIOS*/
        ITEM_FRAGMENT.put(R.id.btn_agregar_servicio,FRAGMENT_LISTADO_SERVICIOS);


    }

    public static final HashMap<String, Fragment> TAG_FRAGMENT;

    static {
        TAG_FRAGMENT = new HashMap<>();

        /**Listado*/
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CITAS_DOCTOR,new ListadoCitasDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CONSULTORIOS, new ListadoConsultoriosFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_DOCTORES, new ListadoDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_ESPECIALIDADES, new ListadoEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_INICIO, new ListadoInicioFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_PACIENTES_DOCTOR, new ListadoPacientesDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_SERVICIOS, new ListadoServiciosFragment());


        /**Formulario*/
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_CITAS,new FormularioCitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_CONSULTORIOS, new FormularioConsultorioFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_DOCTOR, new FormularioDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_ESPECIALIDADES, new FormularioEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_PACIENTES, new FormularioPacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_FORMULARIO_SERVICIOS, new FormularioServiciosFragment());



        /**Registro*/
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CITAS, new RegistroCitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CONSULTORIOS, new RegistroConsultoriosFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_DOCTOR, new RegistroDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_ESPECIALIDADES, new RegistroEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_PACIENTES, new RegistroPacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_SERVICIO, new RegistroServiciosFragment());

        /**Objecto*/
        TAG_FRAGMENT.put(FRAGMENT_CITAS , new CitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_CONSULTORIOS , new ConsultoriosFragment());
        TAG_FRAGMENT.put(FRAGMENT_DOCTOR , new DoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_ESPECIALIDADES , new EspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_PACIENTE , new PacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_SERVICIOS , new ServiciosFragment());

    }


}
