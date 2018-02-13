package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class Citas {


    public Citas(String doctor, String consultorio, String paciente, String fecha, String hora,
                 String estadoCita, String confirmacion, String comentarioPaciente, String asunto) {
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCita = estadoCita;
        this.confirmacion = confirmacion;
        this.comentarioPaciente = comentarioPaciente;
        this.asunto = asunto;
    }

    private String doctor;
    private String consultorio;
    private String paciente;
    private String fecha;
    private String hora;
    private String estadoCita;
    private String confirmacion;
    private String comentarioPaciente;
    private String asunto;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
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

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getComentarioPaciente() {
        return comentarioPaciente;
    }

    public void setComentarioPaciente(String comentarioPaciente) {
        this.comentarioPaciente = comentarioPaciente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
