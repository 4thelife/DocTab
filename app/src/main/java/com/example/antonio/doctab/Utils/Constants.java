package com.example.antonio.doctab.Utils;


import android.support.v4.app.Fragment;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.CitasDoctorFragment;
import com.example.antonio.doctab.fragments.ConsultoriosFragment;
import com.example.antonio.doctab.fragments.DoctoresFragment;
import com.example.antonio.doctab.fragments.EspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioCitasDoctorFragment;
import com.example.antonio.doctab.fragments.FormularioConsultorioFragment;
import com.example.antonio.doctab.fragments.FormularioDoctoresFragment;
import com.example.antonio.doctab.fragments.FormularioEspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioHorariosServicioFragment;
import com.example.antonio.doctab.fragments.FormularioMensajesFragment;
import com.example.antonio.doctab.fragments.FormularioPacientesDoctorFragment;
import com.example.antonio.doctab.fragments.FormularioServiciosFragment;
import com.example.antonio.doctab.fragments.HorariosServicioFragment;
import com.example.antonio.doctab.fragments.ListadoCitasDoctorFragment;
import com.example.antonio.doctab.fragments.ListadoConsultoriosFragment;
import com.example.antonio.doctab.fragments.ListadoDoctoresFragment;
import com.example.antonio.doctab.fragments.ListadoEspecialidadesFragment;
import com.example.antonio.doctab.fragments.ListadoHorariosServiciosFragment;
import com.example.antonio.doctab.fragments.ListadoInicioFragment;
import com.example.antonio.doctab.fragments.ListadoMensajesFragment;
import com.example.antonio.doctab.fragments.ListadoPacientesDoctorFragment;
import com.example.antonio.doctab.fragments.ListadoServiciosFragment;
import com.example.antonio.doctab.fragments.MensajesFragment;
import com.example.antonio.doctab.fragments.PacientesFragment;
import com.example.antonio.doctab.fragments.RegistroCitasDoctorFragment;
import com.example.antonio.doctab.fragments.RegistroConsultoriosFragment;
import com.example.antonio.doctab.fragments.RegistroDoctoresFragment;
import com.example.antonio.doctab.fragments.RegistroEspecialidadesFragment;
import com.example.antonio.doctab.fragments.RegistroHorariosServicioFragment;
import com.example.antonio.doctab.fragments.RegistroMensajesFragment;
import com.example.antonio.doctab.fragments.RegistroPacientesDoctorFragment;
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
    public static final int ACCION_VER = 3;
    public static final String FB_KEY_ITEM_ESTATUS_INACTIVO = "inactivo";
    public static final String FB_KEY_ITEM_ESTATUS_ACTIVO = "activo";
    public static final String FB_KEY_ITEM_ESTATUS_ELIMINADO = "eliminado";
    public static final String FB_KEY_MAIN_DOCTORES = "doctores";
    public static final String FB_KEY_MAIN_HORARIOS_SERVICIO = "Horarios de Servicoo";
    public static final String FB_KEY_MAIN_PACIENTES = "pacientes";
    public static final String FB_KEY_ITEM_DOCTOR = "doctor";
    public static final String FB_KEY_ITEM_CONSULTORIOS = "consultorios";
    public static final String FB_KEY_ITEM_HORARIOS_SERVICIO = "Horarios de servicio";
    public static final String FB_KEY_ITEM_CONSULTORIO_HORARIOS = "horarios";
    public static final String FB_KEY_ITEM_CONSULTORIO_DIRECCION = "direccion";
    public static final String FB_KEY_ITEM_PERFILES_ACADEMICOS = "perfilesAcademicos";
    public static final String FB_KEY_MAIN_USUARIOS = "usuarios";
    public static final String FB_KEY_ITEM_TIPO_USUARIO = "tipoDeUsuario";
    public static final String FB_KEY_ITEM_FIREBASE_ID = "firebaseId";
    public static final String FB_KEY_MAIN_CITAS_DOCTOR = "citas";

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
    public static final String FRAGMENT_LISTADO_MENSAJES = "fragment_listado_mensajes";
    public static final String FRAGMENT_LISTADO_HORARIOS_SERVICIO = "fragment_listado_horarios_servicio";

    /**
     * Fragmentos segundarios
     **/
    public static final String FRAGMENT_INICIOS = "fragment_inicios";
    public static final String FRAGMENT_CONSULTORIOS = "fragment_consultorios";
    public static final String FRAGMENT_DOCTOR = "fragment_doctor";
    public static final String FRAGMENT_CITAS_DOCTOR = "fragment_citas_doctor";
    public static final String FRAGMENT_ESPECIALIDADES = "fragment_especialidades";
    public static final String FRAGMENT_SERVICIOS = "fragment_servicios";
    public static final String FRAGMENT_PACIENTES_DOCTOR = "fragment_pacientes_doctor";
    public static final String FRAGMENT_MENSAJES = "fragment_mensajes";
    public static final String FRAGMENT_HORARIOS_SERVICIOS = "fragment_horarios_servicios";


    /***
     * Fragmentos Formularios
     */

    public static final String FORMULARIO_CONSULTORIOS_FRAGMENT = "formulario_consultorios_fragment";
    public static final String FORMULARIO_ACCIONES_CONSULTORIOS_FRAGMENT = "fragment_acciones_consultorios_fragment";
    public static final String FORMULARIO_DOCTOR_FRAGMENT = "formulario_doctor_fragment";
    public static final String FORMULARIO_ESPECIALIDADES_FRAGMENT = "formulario_especialidades_fragment";
    public static final String FORMULARIO_PACIENTES_DOCTOR_FRAGMENT = "formulario_pacientes_doctor_fragment";
    public static final String FORMULARIO_SERVICIOS_FRAGMENT = "formulario_servicios_fragment";
    public static final String FORMULARIO_CITAS_DOCTOR_FRAGMENT = "formulario_citas_doctor_fragment";
    public static final String FORMULARIO_MENSAJES_FRAGMENT = "formulario_mensajes_fragment";
    public static final String FORMULARIO_HORARIOS_SERVICIOS_FRAGMENT = "formulario_horarios_servicios_fragment";

    /**
     * Fragmentos de Registro
     */
    public static final String FRAGMENT_REGISTRO_CONSULTORIOS = "fragment_registro_consultorios";
    public static final String FRAGMENT_REGISTRO_DOCTOR = "fragment_registro_doctor";
    public static final String FRAGMENT_REGISTRO_ESPECIALIDADES = "fragment_registro_especialidades";
    public static final String FRAGMENT_REGISTRO_PACIENTES_DOCTOR = "fragment_registro_pacientes_doctor";
    public static final String FRAGMENT_REGISTRO_SERVICIO = "fragment_registro_servicio";
    public static final String FRAGMENT_REGISTRO_CITAS_DOCTOR = "fragment_registro_citas_doctor";
    public static final String FRAGMENT_REGISTRO_MENSAJES = "fragment_registro_mensajes";
    public static final String FRAGMENT_REGISTRO_HORARIOS_SERVICIO = "fragment_registro_horarios_servicio";

    /**
     * Fragmentos de ITEM
     */
    public static final String FRAGMENT_ITEM_CITAS_DOCTOR = "fragment_item_citas_doctor";
    public static final String FRAGMENT_ITEM_CONSULTORIOS = "fragment_item_consultorios";
    public static final String FRAGMENT_ITEM_DOCTOR = "fragment_item_doctor";
    public static final String FRAGMENT_ITEM_ESPECIALIDADES = "fragment_item_especialidades";
    public static final String FRAGMENT_ITEM_PACIENTES_DOCTOR = "fragment_item_pacientes_doctor";
    public static final String FRAGMENT_ITEM_SERVICIOS = "fragment_item_servicios";
    public static final String FRAGMENT_ITEM_MENSAJES = "fragment_item_mensajes";
    public static final String FRAGMENT_ITEM_HORARIOS_SERVICIO = "fragment_item_horarios_servicio";


    public static final HashMap<Integer, String> ITEM_FRAGMENT;

    static {
        ITEM_FRAGMENT = new HashMap<>();

        /**Menu*/
        ITEM_FRAGMENT.put(R.id.menu_item_inicio, FRAGMENT_LISTADO_INICIO);
        ITEM_FRAGMENT.put(R.id.menu_item_consultorios_doctor, FRAGMENT_LISTADO_CONSULTORIOS);
        //ITEM_FRAGMENT.put(R.id.menu_item_doctor, FRAGMENT_LISTADO_DOCTORES);
        ITEM_FRAGMENT.put(R.id.menu_item_citas_doctor, FRAGMENT_LISTADO_CITAS_DOCTOR);

        /**Botones*/
        ITEM_FRAGMENT.put(R.id.btn_agregar_consultorio, FRAGMENT_REGISTRO_CONSULTORIOS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_doctor, FRAGMENT_REGISTRO_DOCTOR);
        ITEM_FRAGMENT.put(R.id.btn_agregar_citas_doctor, FRAGMENT_REGISTRO_CITAS_DOCTOR);
        ITEM_FRAGMENT.put(R.id.btn_agregar_especialidades, FRAGMENT_LISTADO_ESPECIALIDADES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_paciente_doctor, FRAGMENT_LISTADO_PACIENTES_DOCTOR);
        ITEM_FRAGMENT.put(R.id.btn_agregar_servicio, FRAGMENT_LISTADO_SERVICIOS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_mensajes, FRAGMENT_LISTADO_MENSAJES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_horario_servicio, FRAGMENT_LISTADO_HORARIOS_SERVICIO);
        ITEM_FRAGMENT.put(R.id.item_btn_editar_consultorios, FRAGMENT_REGISTRO_CONSULTORIOS);
    }

    public static final HashMap<String, Fragment> TAG_FRAGMENT;

    static {
        TAG_FRAGMENT = new HashMap<>();
        /**Listado*/
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CITAS_DOCTOR, new ListadoCitasDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CONSULTORIOS, new ListadoConsultoriosFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_DOCTORES, new ListadoDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_ESPECIALIDADES, new ListadoEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_INICIO, new ListadoInicioFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_PACIENTES_DOCTOR, new ListadoPacientesDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_SERVICIOS, new ListadoServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_MENSAJES, new ListadoMensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_HORARIOS_SERVICIO, new ListadoHorariosServiciosFragment());
        /**Formulario*/
        TAG_FRAGMENT.put(FORMULARIO_CITAS_DOCTOR_FRAGMENT, new FormularioCitasDoctorFragment());
        TAG_FRAGMENT.put(FORMULARIO_CONSULTORIOS_FRAGMENT, new FormularioConsultorioFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FORMULARIO_DOCTOR_FRAGMENT, new FormularioDoctoresFragment());
        TAG_FRAGMENT.put(FORMULARIO_ESPECIALIDADES_FRAGMENT, new FormularioEspecialidadesFragment());
        TAG_FRAGMENT.put(FORMULARIO_PACIENTES_DOCTOR_FRAGMENT, new FormularioPacientesDoctorFragment());
        TAG_FRAGMENT.put(FORMULARIO_SERVICIOS_FRAGMENT, new FormularioServiciosFragment());
        TAG_FRAGMENT.put(FORMULARIO_MENSAJES_FRAGMENT, new FormularioMensajesFragment());
        TAG_FRAGMENT.put(FORMULARIO_ESPECIALIDADES_FRAGMENT, new FormularioHorariosServicioFragment());
        /**Registro*/
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CITAS_DOCTOR, new RegistroCitasDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CONSULTORIOS, new RegistroConsultoriosFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_DOCTOR, new RegistroDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_ESPECIALIDADES, new RegistroEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_PACIENTES_DOCTOR, new RegistroPacientesDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_SERVICIO, new RegistroServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_MENSAJES, new RegistroMensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_HORARIOS_SERVICIO, new RegistroHorariosServicioFragment());
        /**Objecto*/
        TAG_FRAGMENT.put(FRAGMENT_CITAS_DOCTOR, new CitasDoctorFragment());
        TAG_FRAGMENT.put(FRAGMENT_CONSULTORIOS, new ConsultoriosFragment());
        TAG_FRAGMENT.put(FRAGMENT_DOCTOR, new DoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_ESPECIALIDADES, new EspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_PACIENTES_DOCTOR, new PacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_SERVICIOS, new ServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_MENSAJES, new MensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_HORARIOS_SERVICIOS, new HorariosServicioFragment());

    }

    public static final HashMap<Integer, Integer> TITLE_ACTIVITY;

    static {
        TITLE_ACTIVITY = new HashMap<>();
        TITLE_ACTIVITY.put(R.id.btn_agregar_consultorio, R.string.default_title_activity_consultorios);
        TITLE_ACTIVITY.put(R.id.btn_agregar_citas_doctor, R.string.default_title_activity_citas_doctor);
        TITLE_ACTIVITY.put(R.id.btn_agregar_horario_servicio, R.string.default_title_activity_horarios_servicio);
        TITLE_ACTIVITY.put(R.id.item_btn_editar_consultorios, R.string.default_title_activity_consultorios);
    }

    public static final HashMap<Integer, Integer> TITLE_FORM_ACTION;

    static {
        TITLE_FORM_ACTION = new HashMap<>();
        TITLE_FORM_ACTION.put(Constants.ACCION_REGISTRAR, R.string.default_form_title_new);
        TITLE_FORM_ACTION.put(Constants.ACCION_EDITAR, R.string.default_form_title_edit);
    }

    /**
     * Identificadores
     **/
    public static final int WS_KEY_ELIMINAR_CONSULTORIOS = 10;
    public static final int WS_KEY_ELIMINAR_DOCTORES = 20;

}
