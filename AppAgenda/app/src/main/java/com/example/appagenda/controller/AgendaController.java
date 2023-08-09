package com.example.appagenda.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appagenda.database.Agenda_DB;
import com.example.appagenda.model.Agenda;
import com.example.appagenda.model.Pessoa;
import com.example.appagenda.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AgendaController extends Agenda_DB {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public AgendaController(MainActivity mainActivity) {
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

    public Agenda salvar(Agenda outraTarefa) {
        Log.d("MVC_Controller","Salvo"+outraTarefa.toString());

        listaVip.putString("titulo", outraTarefa.getTitulo());
        listaVip.putString("local", outraTarefa.getLocal());
        listaVip.putString("horario", outraTarefa.getHorario());
        listaVip.apply();
        return outraTarefa;
    }

    public void salvarDb(Agenda lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("titulo", lista.getTitulo());
        dados.put("local",lista.getLocal());
        dados.put("horario",lista.getHorario());

        salvarDados("Lista",dados);
    }

    public Agenda buscar(Agenda outraTarefa){
        outraTarefa.setTitulo(preferences.getString("titulo", "NA"));
        outraTarefa.setLocal(preferences.getString("local", "NA"));
        outraTarefa.setHorario(preferences.getString("horario", "NA"));
        return outraTarefa;
    }

    public void editar(){

        listaVip.clear();
        listaVip.apply();
    }

    private List listaTarefasp;

    public List getListaTarefasp() {
        listaTarefasp = new ArrayList<Pessoa>();

        listaTarefasp.add(new Pessoa("Escola"));
        listaTarefasp.add(new Pessoa("Trabalho"));
        listaTarefasp.add(new Pessoa("Curso"));
        listaTarefasp.add(new Pessoa("Confraternização"));

        return listaTarefasp;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaTarefasp().size();i++){
            Agenda objeto = (Agenda) getListaTarefasp().get(i);

            dados.add(objeto.getCategorias());
        }
        return dados;
    }

}
