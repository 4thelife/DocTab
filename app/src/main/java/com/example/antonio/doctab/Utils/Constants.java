package com.example.antonio.doctab.Utils;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.CitasFragment;
import com.example.antonio.doctab.fragments.ConsultoriosFragment;
import com.example.antonio.doctab.fragments.DoctoresFragment;
import com.example.antonio.doctab.fragments.EspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioCitasFragment;
import com.example.antonio.doctab.fragments.FormularioConsultorioFragment;
import com.example.antonio.doctab.fragments.FormularioDoctoresFragment;
import com.example.antonio.doctab.fragments.FormularioEspecialidadesFragment;
import com.example.antonio.doctab.fragments.FormularioHorariosDeAtencionFragment;
import com.example.antonio.doctab.fragments.FormularioMensajesFragment;
import com.example.antonio.doctab.fragments.FormularioPacientesFragment;
import com.example.antonio.doctab.fragments.FormularioServiciosFragment;
import com.example.antonio.doctab.fragments.HorariosDeAtencionFragment;
import com.example.antonio.doctab.fragments.InicioFragment;
import com.example.antonio.doctab.fragments.ListadoCitasFragment;
import com.example.antonio.doctab.fragments.ListadoConsultoriosFragment;
import com.example.antonio.doctab.fragments.ListadoDoctoresFragment;
import com.example.antonio.doctab.fragments.ListadoEspecialidadesFragment;
import com.example.antonio.doctab.fragments.ListadoHorariosDeAtencionFragment;
import com.example.antonio.doctab.fragments.ListadoMensajesFragment;
import com.example.antonio.doctab.fragments.ListadoPacientesFragment;
import com.example.antonio.doctab.fragments.ListadoSeleccionIndefinidoFragment;
import com.example.antonio.doctab.fragments.ListadoServiciosFragment;
import com.example.antonio.doctab.fragments.MensajesFragment;
import com.example.antonio.doctab.fragments.MiPerfilDoctorPrivadoFragment;
import com.example.antonio.doctab.fragments.MiPerfilPacientePrivadoFragment;
import com.example.antonio.doctab.fragments.PacientesFragment;
import com.example.antonio.doctab.fragments.RegistroCitasFragment;
import com.example.antonio.doctab.fragments.RegistroConsultoriosFragment;
import com.example.antonio.doctab.fragments.RegistroDoctoresFragment;
import com.example.antonio.doctab.fragments.RegistroEspecialidadesFragment;
import com.example.antonio.doctab.fragments.RegistroHorariosDeAtencionFragment;
import com.example.antonio.doctab.fragments.RegistroMensajesFragment;
import com.example.antonio.doctab.fragments.RegistroPacientesFragment;
import com.example.antonio.doctab.fragments.RegistroServiciosFragment;
import com.example.antonio.doctab.fragments.ServiciosFragment;

import java.util.HashMap;

/**
 * Created by Antonio on 19/12/2017.
 */

public class  Constants {

    public static final int TIPO_COMPILACION = Constants.USUARIO_COMPILACION_PACIENTE;
    public static final int USUARIO_COMPILACION_DOCTOR = 0;
    public static final int USUARIO_COMPILACION_PACIENTE = 1;
    public static final String USUARIO_DOCTOR = "Qw5Ow8WhDeULVWyDltbWLLKUnf32";

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

    /**
     * Nodos
     */
    public static final String FB_KEY_MAIN_CALENDARIO = "calendario";
    public static final String FB_KEY_MAIN_CITAS = "citas";
    public static final String FB_KEY_MAIN_USUARIOS = "usuarios";
    public static final String FB_KEY_ITEM_CITAS = "citas";
    public static final String FB_KEY_ITEM_CONSULTORIOS = "consultorios";//No modifico este pues es para la bd
    public static final String FB_KEY_ITEM_HORARIOS_DE_ATENCION = "HorariosDeAtencion";
    public static final String FB_KEY_ITEM_CONSULTORIO_HORARIOS = "horarios";
    public static final String FB_KEY_ITEM_CONSULTORIO_DIRECCION = "direccion";
    public static final String FB_KEY_ITEM_PERFILES_ACADEMICOS = "perfilesAcademicos";
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
    public static final String KEY_PREF_CREDENCIALS_NOMBRE = "key_pref_credencials_nombre";

    /**
     * Fragmentos principales de lista
     **/
    public static final String FRAGMENT_LISTADO_CITAS = "fragment_listado_citas";
    public static final String FRAGMENT_LISTADO_CONSULTORIOS = "fragment_listado_consultorios";
    public static final String FRAGMENT_LISTADO_DOCTORES = "fragment_listado_doctores";
    public static final String FRAGMENT_LISTADO_ESPECIALIDADES = "fragment_listado_especialidades";
    public static final String FRAGMENT_LISTADO_PACIENTES = "fragment_listado_pacientes";
    public static final String FRAGMENT_LISTADO_SERVICIOS = "fragment_listado_servicios";
    public static final String FRAGMENT_LISTADO_MENSAJES = "fragment_listado_mensajes";
    public static final String FRAGMENT_LISTADO_HORARIOS_DE_ATENCION = "fragment_listado_horarios_de_atencion";
    public static final String FRAGMENT_MI_PERFIL_DOCTOR_PRIVADO = "fragment_miperfil_doctor_privado";
    public static final String FRAGMENT_MI_PERFIL_PACIENTE_PRIVADO = "fragment_miperfil_paciente_privado";
    public static final String FRAGMENT_INICIO = "fragment_inicio";

    /**
     * Fragmentos segundarios
     **/
    public static final String FRAGMENT_CONSULTORIOS = "fragment_consultorios";
    public static final String FRAGMENT_DOCTOR = "fragment_doctor";
    public static final String FRAGMENT_CITAS = "fragment_citas";
    public static final String FRAGMENT_ESPECIALIDADES = "fragment_especialidades";
    public static final String FRAGMENT_SERVICIOS = "fragment_servicios";
    public static final String FRAGMENT_PACIENTES = "fragment_pacientes";
    public static final String FRAGMENT_MENSAJES = "fragment_mensajes";
    public static final String FRAGMENT_HORARIOS_DE_ATENCION = "fragment_horarios_de_atencion";

    /***
     * Fragmentos Formularios
     */
    public static final String FORMULARIO_DOCTORES_FRAGMENT = "formulario_doctores_fragment";
    public static final String FORMULARIO_PACIENTES_FRAGMENT = "formulario_pacientes_fragment";
    public static final String FORMULARIO_CONSULTORIOS_FRAGMENT = "formulario_consultorios_fragment";
    public static final String FORMULARIO_ESPECIALIDADES_FRAGMENT = "formulario_especialidades_fragment";
    public static final String FORMULARIO_SERVICIOS_FRAGMENT = "formulario_servicios_fragment";
    public static final String FORMULARIO_CITAS_FRAGMENT = "formulario_citas_fragment";
    public static final String FORMULARIO_MENSAJES_FRAGMENT = "formulario_mensajes_fragment";
    public static final String FORMULARIO_HORARIOS_DE_ATENCION_FRAGMENT = "formulario_horarios_de_atencion_fragment";

    /**
     * Fragmentos acciones Formularios
     */
    public static final String FORMULARIO_ACCIONES_DOCTORES_FRAGMENT = "fragment_acciones_doctores_fragment";
    public static final String FORMULARIO_ACCIONES_PACIENTES_FRAGMENT = "fragment_acciones_pacientes_fragment";
    public static final String FORMULARIO_ACCIONES_HORARIOS_DE_ATENCION_FRAGMENT = "fragment_formulario_horarios_de_atencion_acciones";
    public static final String FORMULARIO_ACCIONES_CONSULTORIOS_FRAGMENT = "fragment_acciones_consultorios_fragment";
    public static final String FORMULARIO_ACCIONES_CITAS_FRAGMENT =    "formulario_citas_acciones_fragment";

    /**
     * Fragmentos de Registro
     */
    public static final String FRAGMENT_REGISTRO_DOCTORES = "fragment_registro_doctores";
    public static final String FRAGMENT_REGISTRO_PACIENTES = "fragment_registro_pacientes";
    public static final String FRAGMENT_REGISTRO_INDEFINIDOS = "fragment_registro_indefinido";
    public static final String FRAGMENT_REGISTRO_CONSULTORIOS = "fragment_registro_consultorios";
    public static final String FRAGMENT_REGISTRO_ESPECIALIDADES = "fragment_registro_especialidades";
    public static final String FRAGMENT_REGISTRO_SERVICIOS = "fragment_registro_servicios";
    public static final String FRAGMENT_REGISTRO_CITAS = "fragment_registro_citas";
    public static final String FRAGMENT_REGISTRO_MENSAJES = "fragment_registro_mensajes";
    public static final String FRAGMENT_REGISTRO_HORARIOS_DE_ATENCION = "fragment_registro_horarios_de_atencion";

    /**
     * Fragmentos de ITEM
     */
    public static final String FRAGMENT_ITEM_CITAS = "fragment_item_citas";
    public static final String FRAGMENT_ITEM_CONSULTORIOS = "fragment_item_consultorios";
    public static final String FRAGMENT_ITEM_DOCTOR = "fragment_item_doctor";
    public static final String FRAGMENT_ITEM_ESPECIALIDADES = "fragment_item_especialidades";
    public static final String FRAGMENT_ITEM_PACIENTES = "fragment_item_pacientes";
    public static final String FRAGMENT_ITEM_SERVICIOS = "fragment_item_servicios";
    public static final String FRAGMENT_ITEM_MENSAJES = "fragment_item_mensajes";
    public static final String FRAGMENT_ITEM_HORARIOS_DE_ATENCION = "fragment_item_horarios_de_atencion";

    /**
     * Fragmentos principales de panel
     **/
    public static final String FRAGMENT_MAIN_PANEL = "fragment_main_panel";

    /**
     * Contenido del FRAGMENT_MAIN_PANEL
     **/
    public static final String PANEL_PERFIL_GENERAL_CONTAINER = "panel_perfil_general_container";

    public static final HashMap<Integer, String> ITEM_FRAGMENT;

    static {
        ITEM_FRAGMENT = new HashMap<>();
        ITEM_FRAGMENT.put(View.NO_ID, FRAGMENT_REGISTRO_INDEFINIDOS);
        ITEM_FRAGMENT.put(R.id.linear_registro_doctor, FRAGMENT_REGISTRO_DOCTORES);
        ITEM_FRAGMENT.put(R.id.linear_registro_paciente, FRAGMENT_REGISTRO_PACIENTES);

        /**
         * Menu inicio
         **/
        ITEM_FRAGMENT.put(R.id.menu_item_inicio, FRAGMENT_INICIO);

        /**
         * Menu Doctor
         **/
        ITEM_FRAGMENT.put(R.id.menu_item_horarios_de_atencion, FRAGMENT_LISTADO_HORARIOS_DE_ATENCION);
        ITEM_FRAGMENT.put(R.id.menu_item_consultorios_doctor, FRAGMENT_LISTADO_CONSULTORIOS);
        ITEM_FRAGMENT.put(R.id.menu_item_citas, FRAGMENT_LISTADO_CITAS);
        ITEM_FRAGMENT.put(R.id.menu_item_perfil_doctor, FRAGMENT_MI_PERFIL_DOCTOR_PRIVADO);

        /**
         * Menu Paciente
         **/
        ITEM_FRAGMENT.put(R.id.menu_item_citas_paciente,FRAGMENT_CITAS);
        ITEM_FRAGMENT.put(R.id.menu_item_mi_doctor, FRAGMENT_LISTADO_DOCTORES);
        ITEM_FRAGMENT.put(R.id.menu_item_perfil_paciente, FRAGMENT_MI_PERFIL_PACIENTE_PRIVADO);

        /**
         * Botones
         **/
        ITEM_FRAGMENT.put(R.id.btn_agregar_consultorio, FRAGMENT_REGISTRO_CONSULTORIOS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_citas, FRAGMENT_REGISTRO_CITAS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_especialidades, FRAGMENT_LISTADO_ESPECIALIDADES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_paciente_doctor, FRAGMENT_LISTADO_PACIENTES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_servicio, FRAGMENT_LISTADO_SERVICIOS);
        ITEM_FRAGMENT.put(R.id.btn_agregar_mensajes, FRAGMENT_LISTADO_MENSAJES);
        ITEM_FRAGMENT.put(R.id.btn_agregar_horarios_de_atencion, FRAGMENT_REGISTRO_HORARIOS_DE_ATENCION);
        ITEM_FRAGMENT.put(R.id.item_btn_editar_consultorios, FRAGMENT_REGISTRO_CONSULTORIOS);
        ITEM_FRAGMENT.put(R.id.item_btn_editar_paciente,FRAGMENT_REGISTRO_PACIENTES);
        ITEM_FRAGMENT.put(R.id.item_btn_editar_doctores, FRAGMENT_REGISTRO_DOCTORES);
        ITEM_FRAGMENT.put(R.id.item_btn_editar_citas,FRAGMENT_REGISTRO_CITAS);

    }

    public static final HashMap<String, Fragment> TAG_FRAGMENT;

    static {
        TAG_FRAGMENT = new HashMap<>();

        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_INDEFINIDOS, new ListadoSeleccionIndefinidoFragment());

        /**
         * Listado
         **/
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CITAS, new ListadoCitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_CONSULTORIOS, new ListadoConsultoriosFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_DOCTORES, new ListadoDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_ESPECIALIDADES, new ListadoEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_PACIENTES, new ListadoPacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_SERVICIOS, new ListadoServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_MENSAJES, new ListadoMensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_LISTADO_HORARIOS_DE_ATENCION, new ListadoHorariosDeAtencionFragment());
        TAG_FRAGMENT.put(FRAGMENT_MI_PERFIL_DOCTOR_PRIVADO, new MiPerfilDoctorPrivadoFragment());
        TAG_FRAGMENT.put(FRAGMENT_MI_PERFIL_PACIENTE_PRIVADO, new MiPerfilPacientePrivadoFragment());
        TAG_FRAGMENT.put(FRAGMENT_INICIO, new InicioFragment());

        /**
         * Formulario
         **/
        TAG_FRAGMENT.put(FORMULARIO_CITAS_FRAGMENT, new FormularioCitasFragment());
        TAG_FRAGMENT.put(FORMULARIO_CONSULTORIOS_FRAGMENT, new FormularioConsultorioFragment());//VERIFICAR LA CLASE Y SUS CAMBIOS
        TAG_FRAGMENT.put(FORMULARIO_DOCTORES_FRAGMENT, new FormularioDoctoresFragment());
        TAG_FRAGMENT.put(FORMULARIO_ESPECIALIDADES_FRAGMENT, new FormularioEspecialidadesFragment());
        TAG_FRAGMENT.put(FORMULARIO_PACIENTES_FRAGMENT, new FormularioPacientesFragment());
        TAG_FRAGMENT.put(FORMULARIO_SERVICIOS_FRAGMENT, new FormularioServiciosFragment());
        TAG_FRAGMENT.put(FORMULARIO_MENSAJES_FRAGMENT, new FormularioMensajesFragment());
        TAG_FRAGMENT.put(FORMULARIO_HORARIOS_DE_ATENCION_FRAGMENT, new FormularioHorariosDeAtencionFragment());

        /**
         * Registro
         **/
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CITAS, new RegistroCitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_CONSULTORIOS, new RegistroConsultoriosFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_DOCTORES, new RegistroDoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_PACIENTES, new RegistroPacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_ESPECIALIDADES, new RegistroEspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_SERVICIOS, new RegistroServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_MENSAJES, new RegistroMensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_REGISTRO_HORARIOS_DE_ATENCION, new RegistroHorariosDeAtencionFragment());

        /**
         * Objecto
         **/ //Fragmentos "Secundarios"
        TAG_FRAGMENT.put(FRAGMENT_CITAS, new CitasFragment());
        TAG_FRAGMENT.put(FRAGMENT_CONSULTORIOS, new ConsultoriosFragment());
        TAG_FRAGMENT.put(FRAGMENT_DOCTOR, new DoctoresFragment());
        TAG_FRAGMENT.put(FRAGMENT_ESPECIALIDADES, new EspecialidadesFragment());
        TAG_FRAGMENT.put(FRAGMENT_PACIENTES, new PacientesFragment());
        TAG_FRAGMENT.put(FRAGMENT_SERVICIOS, new ServiciosFragment());
        TAG_FRAGMENT.put(FRAGMENT_MENSAJES, new MensajesFragment());
        TAG_FRAGMENT.put(FRAGMENT_HORARIOS_DE_ATENCION, new HorariosDeAtencionFragment());

    }

    public static final HashMap<Integer, Integer> TITLE_ACTIVITY;

    static {
        TITLE_ACTIVITY = new HashMap<>();
        TITLE_ACTIVITY.put(View.NO_ID, R.string.default_undefined);
        TITLE_ACTIVITY.put(R.id.linear_registro_doctor, R.string.default_doctor);
        TITLE_ACTIVITY.put(R.id.linear_registro_paciente, R.string.default_paciente);
        TITLE_ACTIVITY.put(R.id.btn_agregar_consultorio, R.string.default_title_activity_consultorios);
        TITLE_ACTIVITY.put(R.id.btn_agregar_citas, R.string.default_title_activity_citas_doctor);
        TITLE_ACTIVITY.put(R.id.btn_agregar_horarios_de_atencion, R.string.default_title_activity_horarios_de_atencion);
        TITLE_ACTIVITY.put(R.id.item_btn_editar_consultorios, R.string.default_title_activity_consultorios);
        TITLE_ACTIVITY.put(R.id.item_btn_editar_paciente,R.string.default_title_activity_doctores);
        TITLE_ACTIVITY.put(R.id.item_btn_editar_doctores, R.string.default_title_activity_doctores);
        TITLE_ACTIVITY.put(R.id.item_btn_editar_citas,R.string.default_title_activity_citas_doctor);

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
    public static final int WS_KEY_ELIMINAR_DIAS = 30;
    public static final int WS_KEY_ELIMINAR_CITAS = 40;

    /**
     * Tipos de usuarios - todos en singular
     **/
    public static final String FB_KEY_ITEM_TIPO_USUARIO_INDEFINIDO = "indefinido";
    public static final String FB_KEY_ITEM_TIPO_USUARIO_ADMINISTRADOR = "administrador";
    public static final String FB_KEY_ITEM_TIPO_USUARIO_DOCTOR = "doctor";
    public static final String FB_KEY_ITEM_TIPO_USUARIO_PACIENTE = "paciente";

    /**
     * Nodos de usuarios - todos en plural
     **/
    public static final String FB_KEY_MAIN_INDEFINIDOS = "indefinidos";
    public static final String FB_KEY_MAIN_ADMINISTRADORES = "administradores";
    public static final String FB_KEY_MAIN_DOCTORES = "doctores";
    public static final String FB_KEY_MAIN_PACIENTES = "pacientes";

    /**
     * Sub item NODO
     **/
    public static final String FB_KEY_ITEM_INDEFINIDO = "indefinido";
    public static final String FB_KEY_ITEM_ADMINISTRADOR = "administrador";
    public static final String FB_KEY_ITEM_DOCTOR = "doctor";
    public static final String FB_KEY_ITEM_PACIENTE = "paciente";

    public static final HashMap<String, String> NODOS_USUARIOS_PRIVILEGIOS;

    static {
        NODOS_USUARIOS_PRIVILEGIOS = new HashMap<>();
        NODOS_USUARIOS_PRIVILEGIOS.put(Constants.FB_KEY_ITEM_TIPO_USUARIO_INDEFINIDO, FB_KEY_MAIN_INDEFINIDOS);
        NODOS_USUARIOS_PRIVILEGIOS.put(Constants.FB_KEY_ITEM_TIPO_USUARIO_ADMINISTRADOR, FB_KEY_MAIN_ADMINISTRADORES);
        NODOS_USUARIOS_PRIVILEGIOS.put(Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR, FB_KEY_MAIN_DOCTORES);
        NODOS_USUARIOS_PRIVILEGIOS.put(Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE, FB_KEY_MAIN_PACIENTES);
    }

}
