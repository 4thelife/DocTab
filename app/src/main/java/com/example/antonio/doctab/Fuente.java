package com.example.antonio.doctab;

/**
 * Created by GIGABYTE on 14/12/2017.
 */

public class Fuente {

    String dia,hIni,hFin,mIni,mFin;
    //dia
    //hIni Hora Inicial
    //hFin Hora Final
    //mIni Minuto inicial
    //mFin Minuto Final

    public Fuente(String dia, String hIni, String hFin, String mIni, String mFin) {
        this.dia = dia;
        this.hIni = hIni;
        this.hFin = hFin;
        this.mIni = mIni;
        this.mFin = mFin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String gethIni() {
        return hIni;
    }

    public void sethIni(String hIni) {
        this.hIni = hIni;
    }

    public String gethFin() {
        return hFin;
    }

    public void sethFin(String hFin) {
        this.hFin = hFin;
    }

    public String getmIni() {
        return mIni;
    }

    public void setmIni(String mIni) {
        this.mIni = mIni;
    }

    public String getmFin() {
        return mFin;
    }

    public void setmFin(String mFin) {
        this.mFin = mFin;
    }
}
