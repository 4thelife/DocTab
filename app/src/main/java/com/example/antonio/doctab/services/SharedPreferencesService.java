package com.example.antonio.doctab.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.models.Usuarios;

/**
 * Created by jvier on 07/12/2017.
 */

public class SharedPreferencesService {

    public static Usuarios getUsuarioActual(Context context) {
        Usuarios usuario = new Usuarios();
        SharedPreferences credenciales = context.getSharedPreferences(Constants.KEY_PREF_CREDENCIALS, Context.MODE_PRIVATE);
        String firebaseId = credenciales.getString(Constants.KEY_PREF_CREDENCIALS_FIREBASE_ID, "");
        String tipoDeUsuario = credenciales.getString(Constants.KEY_PREF_CREDENCIALS_TIPO_USUARIO, "");

        usuario.setFirebaseId(firebaseId);
        usuario.setTipoDeUsuario(tipoDeUsuario);

        return usuario;
    }
}
