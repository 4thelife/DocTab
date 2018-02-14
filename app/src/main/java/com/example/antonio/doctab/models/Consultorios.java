package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class Consultorios {
    private String nombreConsultorio;
    private String tel1;
    private String ext1;
    private String tel2;
    private String ext2;
    private String calle;
    private String colonia;
    private String numeroInt;
    private String numeroExt;
    private String codPostal;
    private String ciudad;
    private String estado;



    private String fireBaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;


    public Consultorios() {
    }

    public Consultorios(String nombreConsultorio, String tel1, String ext1, String tel2,
                        String ext2, String calle, String colonia, String numeroInt,
                        String numeroExt, String codPostal, String ciudad, String estado,
                        String fireBaseId, String estatus, Long fechaDeCreacion,
                        Long fechaDeEdicion) {
        this.nombreConsultorio = nombreConsultorio;
        this.tel1 = tel1;
        this.ext1 = ext1;
        this.tel2 = tel2;
        this.ext2 = ext2;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroInt = numeroInt;
        this.numeroExt = numeroExt;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.fireBaseId = fireBaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getNombreConsultorio() {
        return nombreConsultorio;
    }

    public void setNombreConsultorio(String nombreConsultorio) {
        this.nombreConsultorio = nombreConsultorio;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
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
