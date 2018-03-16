package com.example.antonio.doctab.models;

import java.io.Serializable;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Usuarios implements Serializable {

    private  String tipoDeUsuario;
    private String firebaseId;
    private String nombre;

    public Usuarios() {
    }

    public Usuarios(String tipoDeUsuario, String firebaseId, String nombre) {
        this.tipoDeUsuario = tipoDeUsuario;
        this.firebaseId = firebaseId;
        this.nombre = nombre;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
