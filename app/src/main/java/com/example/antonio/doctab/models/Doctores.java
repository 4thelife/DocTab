package com.example.antonio.doctab.models;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Doctores {
    /**DATOS DEL DOCTOR*/
    private String nombreCompleto;
    private String especialidad;
    private String cedulaProfesional;

    private String correoElectronico;
    private String sexo;
    private String fotoPerfil;
    private String tipoDeUsuario;
    /**DATOS DEL CONSULTORIO*/
    private String calle;
    private String colonia;
    private String numeroInt;
    private String numeroExt;
    private String codPostal;
    private String ciudad;
    private String estado;
    private String telefono;


    private String firebaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;


    public Doctores(String nombreCompleto, String especialidad, String cedulaProfesional, String correoElectronico, String sexo, String fotoPerfil, String tipoDeUsuario, String calle, String colonia, String numeroInt, String numeroExt, String codPostal, String ciudad, String estado, String telefono, String firebaseId, String estatus, Long fechaDeCreacion, Long fechaDeEdicion) {
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.cedulaProfesional = cedulaProfesional;
        this.correoElectronico = correoElectronico;
        this.sexo = sexo;
        this.fotoPerfil = fotoPerfil;
        this.tipoDeUsuario = tipoDeUsuario;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroInt = numeroInt;
        this.numeroExt = numeroExt;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.firebaseId = firebaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
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
