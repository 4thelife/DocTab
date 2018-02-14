package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class Servicios {


    private String servicio;
    private String costo;
    private String fireBaseId;


    public Servicios(String servicio, String costo, String fireBaseId) {
        this.servicio = servicio;
        this.costo = costo;
        this.fireBaseId = fireBaseId;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
    }
}
