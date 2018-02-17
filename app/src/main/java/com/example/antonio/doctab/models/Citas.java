package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class Citas {




    private String doctor;
    private String paciente;
    private String fecha;
    private String hora;
    private String estadoCita;
    private String asunto;
    private String fireBaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;
    /**private String retroalimentacionCita;*/
    /**private String comentarioPaciente;*/
    /**private String consultorio;*/

    public Citas(String doctor, String paciente, String fecha, String hora, String estadoCita,
                 String asunto, String fireBaseId, String estatus, Long fechaDeCreacion,
                 Long fechaDeEdicion) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCita = estadoCita;
        this.asunto = asunto;
        this.fireBaseId = fireBaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }


    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
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
