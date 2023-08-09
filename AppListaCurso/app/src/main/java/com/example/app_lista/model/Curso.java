package com.example.app_lista.model;

public class Curso {
     private String cursoDesejado;

     public Curso(){

     }

    public Curso(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return cursoDesejado;
    }
}
