package com.example.antonio.doctab.models;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Doctores {

    private String nombreCompleto;
    /*
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String subespecialidad
    */
    private String cedulaProfesional;
    private String correoElectronico;
    private String sexo;
    private String telefonoCelular1;
    private String telefonoCelular2;
    private String fechaNacimiento;
    private String fotoPerfil;
    private String tipoDeUsuario;

    private String firebaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;

    public Doctores() {
    }

    public Doctores(String nombreCompleto, /* String nombre, String, apellidos, String especialidad,
     String subespecialidad, */String cedulaProfesional, String correoElectronico, String sexo,
                    String telefonoCelular1, String telefonoCelular2, String fechaNacimiento,
                    String fotoPerfil, String tipoDeUsuario, String firebaseId, String estatus,
                    Long fechaDeCreacion, Long fechaDeEdicion) {
        this.nombreCompleto = nombreCompleto;
        /*
        * this.nombres = nombres;
        * this.apellidos = apellidos;
        * this.especialidad = especialidad;
        * this.subespecialidad = subespecialidad;
        * */
        this.cedulaProfesional = cedulaProfesional;
        this.correoElectronico = correoElectronico;
        this.sexo = sexo;
        this.telefonoCelular1 = telefonoCelular1;
        this.telefonoCelular2 = telefonoCelular2;
        this.fechaNacimiento = fechaNacimiento;
        this.fotoPerfil = fotoPerfil;
        this.tipoDeUsuario = tipoDeUsuario;
        this.firebaseId = firebaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    /*
    public void setNombres(String nombres){ this.nombres=nombres; }

    public String getNombres(){ return nombres; }

    public void setApellidos(String apellidos){ this.apellidos=apellidos; }

    public String getApellidos(){ return apellidos; }

    public void setEspecialidad(String especialidad){ this.especialidad=especialidad; }

    public String getEspecialidad(){ return especialidad; }

    public void setSubespecialidad(String subespecialidad){ this.subespecialidad=subespecialidad; }

    public String getSubespecialidad(){ return subespecialidad; }

    */

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoCelular1() {
        return telefonoCelular1;
    }

    public void setTelefonoCelular1(String telefonoCelular1) {
        this.telefonoCelular1 = telefonoCelular1;
    }

    public String getTelefonoCelular2() {
        return telefonoCelular2;
    }

    public void setTelefonoCelular2(String telefonoCelular2) {
        this.telefonoCelular2 = telefonoCelular2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Long getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Long fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Long getFechaDeEdicion() {
        return fechaDeEdicion;
    }

    public void setFechaDeEdicion(Long fechaDeEdicion) {
        this.fechaDeEdicion = fechaDeEdicion;
    }
}
