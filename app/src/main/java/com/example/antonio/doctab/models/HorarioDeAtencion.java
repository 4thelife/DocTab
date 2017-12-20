package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class HorarioDeAtencion {


    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private String domingo;


    // o uso solo:
    // private String dia;
    private String horaEntrada;
    private String horaSalida;
    private String horaInicioComida;
    private String horaFinComida;

    private String firebaseId;

    public HorarioDeAtencion() {
    }

    public HorarioDeAtencion(String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo, String horaEntrada, String horaSalida, String horaInicioComida, String horaFinComida, String firebaseId) {
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.horaInicioComida = horaInicioComida;
        this.horaFinComida = horaFinComida;
        this.firebaseId = firebaseId;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraInicioComida() {
        return horaInicioComida;
    }

    public void setHoraInicioComida(String horaInicioComida) {
        this.horaInicioComida = horaInicioComida;
    }

    public String getHoraFinComida() {
        return horaFinComida;
    }

    public void setHoraFinComida(String horaFinComida) {
        this.horaFinComida = horaFinComida;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }
}
