package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class DireccionConsultorio {

    private String calle;
    private String colonia;
    private String numeroInt;
    private String numeroExt;
    private String codPostal;
    private String ciudad;
    private String estado;
    private String fireBaseId;

    public DireccionConsultorio() {
    }

    public DireccionConsultorio(String calle, String colonia, String numeroInt, String numeroExt, String codPostal, String ciudad, String estado, String fireBaseId) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroInt = numeroInt;
        this.numeroExt = numeroExt;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.fireBaseId = fireBaseId;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getNumeroExt() {
        return numeroExt;
    }

    public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
    }
}
