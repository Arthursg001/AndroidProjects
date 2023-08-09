package com.example.app_lista.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;

import com.example.app_lista.R;
import com.example.app_lista.database.Lista_DB;
import com.example.app_lista.model.Curso;
import com.example.app_lista.model.Pessoa;
import com.example.app_lista.view.MainActivity;

public class PessoasController extends Lista_DB {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoasController(MainActivity mainActivity) {
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


    public Pessoa salvar(Pessoa outraPessoa) {
        Log.d("MVC_Controller","Salvo"+outraPessoa.toString());

        listaVip.putString("primeiroNome", outraPessoa.getNome());
        listaVip.putString("sobreNome", outraPessoa.getSobreNome());
        listaVip.putString("nomeCurso", outraPessoa.getNomeCurso());
        listaVip.putString("telefoneContato", outraPessoa.getTelefone());
        listaVip.apply();
        return outraPessoa;
    }

    public void salvarBd(Pessoa lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("nome", lista.getNome());
        dados.put("sobrenome",lista.getSobreNome());
        dados.put("curso",lista.getNomeCurso());
        dados.put("telefone", lista.getTelefone());

        salvarDados("Lista",dados);
    }

    public Pessoa buscar(Pessoa outraPessoa){
        outraPessoa.setNome(preferences.getString("primeiroNome", "NA"));
        outraPessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        outraPessoa.setNomeCurso(preferences.getString("nomeCurso", "NA"));
        outraPessoa.setTelefone(preferences.getString("telefoneContato", "NA"));
        return outraPessoa;
    }

    public void limpar(){

        listaVip.clear();
        listaVip.apply();
    }

}
