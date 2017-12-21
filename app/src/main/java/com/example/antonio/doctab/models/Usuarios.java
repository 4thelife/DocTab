package com.example.antonio.doctab.models;

import java.io.Serializable;

/**
 * Created by Antonio on 19/12/2017.
 */

public class Usuarios implements Serializable {

    private  String tipoDeUsuario;
    private String firebaseId;

    public Usuarios() {
    }

    public Usuarios(String tipoDeUsuario, String firebaseId) {
        this.tipoDeUsuario = tipoDeUsuario;
        this.firebaseId = firebaseId;
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
}
