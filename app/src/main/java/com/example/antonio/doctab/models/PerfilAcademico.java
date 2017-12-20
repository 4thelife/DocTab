package com.example.antonio.doctab.models;

/**
 * Created by GIGABYTE on 20/12/2017.
 */

public class PerfilAcademico {

    private String nombreDeAcademia;
    private String nombreDelcurso;
    private String fechaFinalizado;

    public PerfilAcademico() {
    }

    public PerfilAcademico(String nombreDeAcademia, String nombreDelcurso, String fechaFinalizado) {
        this.nombreDeAcademia = nombreDeAcademia;
        this.nombreDelcurso = nombreDelcurso;
        this.fechaFinalizado = fechaFinalizado;
    }


    public String getNombreDeAcademia() {
        return nombreDeAcademia;
    }

    public void setNombreDeAcademia(String nombreDeAcademia) {
        this.nombreDeAcademia = nombreDeAcademia;
    }

    public String getNombreDelcurso() {
        return nombreDelcurso;
    }

    public void setNombreDelcurso(String nombreDelcurso) {
        this.nombreDelcurso = nombreDelcurso;
    }

    public String getFechaFinalizado() {
        return fechaFinalizado;
    }

    public void setFechaFinalizado(String fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }
}
