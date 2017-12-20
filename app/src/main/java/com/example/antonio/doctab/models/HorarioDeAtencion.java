package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class HorarioDeAtencion {

    private String dia;
    private String horaEntrada;
    private String horaSalida;
    private String horaInicioComida;
    private String horaFinComida;

    private String firebaseId;


    public HorarioDeAtencion() {
    }

    public HorarioDeAtencion(String dia, String horaEntrada, String horaSalida, String horaInicioComida, String horaFinComida, String firebaseId) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.horaInicioComida = horaInicioComida;
        this.horaFinComida = horaFinComida;
        this.firebaseId = firebaseId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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
