package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class HorariosServicio {

    private String dia;
    private String horainicio;
    private String horafin;
    private String citasPorHora;


    private String firebaseId;

    public HorariosServicio() {
    }

    public HorariosServicio(String dia, String horainicio, String horafin, String citasPorHora, String firebaseId) {
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.citasPorHora = citasPorHora;
        this.firebaseId = firebaseId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getCitasPorHora() {
        return citasPorHora;
    }

    public void setCitasPorHora(String citasPorHora) {
        this.citasPorHora = citasPorHora;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }
}