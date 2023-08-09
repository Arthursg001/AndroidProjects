package com.example.applistadetarefas.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadetarefas.database.Tarefas_DB;
import com.example.applistadetarefas.model.Tarefa;
import com.example.applistadetarefas.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class TarefaController extends Tarefas_DB {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public TarefaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado...");

        return super.toString();
    }

    public Tarefa salvar(Tarefa outraTarefa) {
        Log.d("MVC_Controller","Salvo"+outraTarefa.toString());

        listaVip.putString("titulo", outraTarefa.getNomeDaTarefa());
        listaVip.putString("observacao", outraTarefa.getDescricao());
        listaVip.putString("dataVencimento", outraTarefa.getDataDeConclusao());
        listaVip.apply();
        return outraTarefa;
    }

    public void salvarDb(Tarefa lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("titulo", lista.getNomeDaTarefa());
        dados.put("conteudo",lista.getDescricao());
        dados.put("data",lista.getDataDeConclusao());

        salvarDados("Lista",dados);
    }

    public Tarefa buscar(Tarefa outraTarefa){
        outraTarefa.setNomeDaTarefa(preferences.getString("titulo", "NA"));
        outraTarefa.setDescricao(preferences.getString("observacao", "NA"));
        outraTarefa.setDataDeConclusao(preferences.getString("dataVencimento", "NA"));
        return outraTarefa;
    }

    public void editar(){

        listaVip.clear();
        listaVip.apply();
    }

    private List listaTarefasp;

    public List getListaTarefasp() {
        listaTarefasp = new ArrayList<Tarefa>();

        listaTarefasp.add(new Tarefa("Escola"));
        listaTarefasp.add(new Tarefa("Trabalho"));
        listaTarefasp.add(new Tarefa("Curso"));
        listaTarefasp.add(new Tarefa("Confraternização"));

        return listaTarefasp;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaTarefasp().size();i++){
            Tarefa objeto = (Tarefa) getListaTarefasp().get(i);

            dados.add(objeto.getCategorias());
        }
        return dados;
    }

}
