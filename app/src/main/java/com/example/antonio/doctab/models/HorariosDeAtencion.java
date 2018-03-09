package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class HorariosDeAtencion {

    private String dia;
    private String horaInicio;
    private String horaFin;
    private String duracionDeCita;


    private String fireBaseId;
    private String fireBaseIdDoctor;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;


    public HorariosDeAtencion() {
    }

    public HorariosDeAtencion(String dia, String horaInicio, String horaFin, String duracionDeCita, String fireBaseId, String fireBaseIdDoctor, String estatus, Long fechaDeCreacion, Long fechaDeEdicion) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.duracionDeCita = duracionDeCita;
        this.fireBaseId = fireBaseId;
        this.fireBaseIdDoctor = fireBaseIdDoctor;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getDuracionDeCita() {
        return duracionDeCita;
    }

    public void setDuracionDeCita(String duracionDeCita) {
        this.duracionDeCita = duracionDeCita;
    }

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
    }

    public String getFireBaseIdDoctor() {
        return fireBaseIdDoctor;
    }

    public void setFireBaseIdDoctor(String fireBaseIdDoctor) {
        this.fireBaseIdDoctor = fireBaseIdDoctor;
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