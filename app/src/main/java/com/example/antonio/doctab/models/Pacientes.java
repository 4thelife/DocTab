package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class Pacientes {




    private String nombres;
    private String apellidos;
    private String edad;
    private String sexo;
    private String alergia;
    private String ultimaCita;
    private String tipoDeUsuario;
    private String fireBaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;

    public Pacientes(String nombres, String apellidos, String edad, String sexo, String alergia,
                     String ultimaCita, String tipoDeUsuario, String fireBaseId, String estatus,
                     Long fechaDeCreacion, Long fechaDeEdicion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.alergia = alergia;
        this.ultimaCita = ultimaCita;
        this.tipoDeUsuario = tipoDeUsuario;
        this.fireBaseId = fireBaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getUltimaCita() {
        return ultimaCita;
    }

    public void setUltimaCita(String ultimaCita) {
        this.ultimaCita = ultimaCita;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
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
