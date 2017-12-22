package com.example.antonio.doctab.helpers;

import java.io.Serializable;

/**
 * Created by jvier on 28/09/2017.
 */

public class DecodeExtraHelper implements Serializable {

    private String tituloActividad;
    private String tituloFormulario;
    private int accionFragmento;
    private String fragmentTag;
    private DecodeItemHelper decodeItem;

    public DecodeExtraHelper() {
    }

    public DecodeExtraHelper(String tituloActividad, String tituloFormulario, int accionFragmento, String fragmentTag, DecodeItemHelper decodeItem) {
        this.tituloActividad = tituloActividad;
        this.tituloFormulario = tituloFormulario;
        this.accionFragmento = accionFragmento;
        this.fragmentTag = fragmentTag;
        this.decodeItem = decodeItem;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public int getAccionFragmento() {
        return accionFragmento;
    }

    public void setAccionFragmento(int accionFragmento) {
        this.accionFragmento = accionFragmento;
    }

    public String getFragmentTag() {
        return fragmentTag;
    }

    public void setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    public DecodeItemHelper getDecodeItem() {
        return decodeItem;
    }

    public void setDecodeItem(DecodeItemHelper decodeItem) {
        this.decodeItem = decodeItem;
    }
}
