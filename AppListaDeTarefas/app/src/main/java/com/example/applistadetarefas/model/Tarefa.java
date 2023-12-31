package com.example.applistadetarefas.model;

public class Tarefa {
    private String nomeDaTarefa;
    private String descricao;
    private String dataDeConclusao;
    private String categorias;

    public Tarefa() {

    }

    public Tarefa(String nomeDaTarefa, String descricao, String dataDeConclusao, String categorias) {
        this.nomeDaTarefa = nomeDaTarefa;
        this.descricao = descricao;
        this.dataDeConclusao = dataDeConclusao;
        this.categorias = categorias;
    }

    public Tarefa(String nova_tarefa) {
    }

    public String getNomeDaTarefa() {
        return nomeDaTarefa;
    }

    public void setNomeDaTarefa(String nomeDaTarefa) {
        this.nomeDaTarefa = nomeDaTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(String dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nomeDaTarefa='" + nomeDaTarefa + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeConclusao='" + dataDeConclusao + '\'' +
                '}';
    }
}
