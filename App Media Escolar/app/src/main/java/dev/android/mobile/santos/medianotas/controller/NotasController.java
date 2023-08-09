package dev.android.mobile.santos.medianotas.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import dev.android.mobile.santos.medianotas.database.Disciplina_DB;
import dev.android.mobile.santos.medianotas.model.Notas;
import dev.android.mobile.santos.medianotas.view.MainActivity;

public class NotasController extends Disciplina_DB {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public NotasController(MainActivity activity){
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    public void salvar(Notas nota) {
        ContentValues dados = new ContentValues();

        dados.put("Nome Aluno", nota.getNomeAluno());
        dados.put("Disciplina",nota.getDisciplina());
        dados.put("Nota1",nota.getN1());
        dados.put("Nota2",nota.getN2());
        dados.put("Nota3",nota.getN3());
        dados.put("Nota4",nota.getN4());
        dados.put("Media ",nota.getMediaNotas());
        dados.put("Resultado ",nota.getResultado());

        salvarObjeto("Notas",dados);
    }

    public String calcular(Notas notas){

        double mediaNotas = notas.media(notas.getN1(), notas.getN2(), notas.getN3(), notas.getN4());
        String disciplina = notas.getDisciplina();
        String Resultado;
        String Frase;

        if(mediaNotas >= 60){
            Resultado = "Aluno Aprovado";
            notas.setMediaNotas(mediaNotas);
            notas.setResultado(Resultado);
            Frase = String.format("Aluno Aprovado " + disciplina+ " com a média de: %.2f",mediaNotas);
        }else{
            Resultado = "Aluno Reprovado";
            notas.setMediaNotas(mediaNotas);
            notas.setResultado(Resultado);
            Frase = String.format("Aluno Reprovado " + disciplina+ " com a média de: %.2f",mediaNotas);
        }
        return Frase;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
