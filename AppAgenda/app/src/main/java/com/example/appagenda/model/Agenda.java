package com.example.appagenda.model;

public class Agenda {
    private String titulo;
    private String horario;
    private String local;
    private String categorias;

    public Agenda() {

    }

    public Agenda(String titulo, String horario, String local, String categorias) {
        this.titulo = titulo;
        this.horario = horario;
        this.local = local;
        this.categorias = categorias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }
}
