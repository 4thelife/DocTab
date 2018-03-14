package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class Citas {




    private String firebaseIdDoctor;
    private String firebaseIdPaciente;
    private String fecha;
    private String hora;
    private String estadoCita;
    private String asunto;
    private String fireBaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;

    public Citas(String firebaseIdDoctor, String firebaseIdPaciente, String fecha, String hora, String estadoCita, String asunto, String fireBaseId, String estatus, Long fechaDeCreacion, Long fechaDeEdicion) {
        this.firebaseIdDoctor = firebaseIdDoctor;
        this.firebaseIdPaciente = firebaseIdPaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCita = estadoCita;
        this.asunto = asunto;
        this.fireBaseId = fireBaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getFirebaseIdDoctor() {
        return firebaseIdDoctor;
    }

    public void setFirebaseIdDoctor(String firebaseIdDoctor) {
        this.firebaseIdDoctor = firebaseIdDoctor;
    }

    public String getFirebaseIdPaciente() {
        return firebaseIdPaciente;
    }

    public void setFirebaseIdPaciente(String firebaseIdPaciente) {
        this.firebaseIdPaciente = firebaseIdPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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
