package com.example.antonio.doctab.models;

/**
 * Created by Ricardo on 15/02/2018.
 */

public class Mensajes {

    private String remitente;
    private String destinatario;
    private String asunto;
    private String contenido;
    private String firebaseId;
    private String estatus;
    private Long fechaDeCreacion;
    private Long fechaDeEdicion;

    public Mensajes(String remitente, String destinatario, String asunto, String contenido, String firebaseId, String estatus, Long fechaDeCreacion, Long fechaDeEdicion) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.contenido = contenido;
        this.firebaseId = firebaseId;
        this.estatus = estatus;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
