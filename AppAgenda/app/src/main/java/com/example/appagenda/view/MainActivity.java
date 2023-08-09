package com.example.appagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appagenda.R;
import com.example.appagenda.controller.AgendaController;
import com.example.appagenda.controller.PessoaController;
import com.example.appagenda.database.Agenda_DB;
import com.example.appagenda.model.Agenda;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AgendaController agendaController;
    Agenda novaAgenda;

    List<String> nomesDaAgenda;

    EditText editTitulo;
    EditText editHorario;
    EditText editLocal;

    Button editBtnSalvar;
    Button editBtnLimpar;
    Button editBtnFinalizar;

    Spinner edit_Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaController pessoaController = new PessoaController();

        nomesDaAgenda = pessoaController.dadosSpinner();

        agendaController = new AgendaController(MainActivity.this);
        agendaController.toString();

        novaAgenda = new Agenda();

        agendaController.buscar(novaAgenda);

        editTitulo = findViewById(R.id.editTextTitulo);
        editHorario = findViewById(R.id.editTextHorario);
        editLocal = findViewById(R.id.editTextLocal);

        editBtnSalvar = findViewById(R.id.btnSalvar);
        editBtnLimpar = findViewById(R.id.btnLimpar);
        editBtnFinalizar = findViewById(R.id.btnFinalizar);

        edit_Spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);


        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaAgenda.setTitulo(editTitulo.getText().toString());
                novaAgenda.setHorario(editHorario.getText().toString());
                novaAgenda.setLocal(editLocal.getText().toString());
                agendaController.salvar(novaAgenda);

                Toast.makeText(MainActivity.this, "Dados salvos" + novaAgenda.toString(), Toast.LENGTH_LONG).show();

                Agenda tarefa = new Agenda();
                tarefa.setTitulo(editTitulo.getText().toString());
                tarefa.setLocal(editLocal.getText().toString());
                tarefa.setHorario(editHorario.getText().toString());

                agendaController.salvarDb(tarefa);

                editTitulo.setText("");
                editLocal.setText("");
                editHorario.setText("");

            }
        });

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparBancoDeDados();
                Toast.makeText(MainActivity.this, "Limpo com Sucesso!", Toast.LENGTH_LONG).show();
                agendaController.editar();
            }
        });

        editBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finalizado com Sucesso!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    private void limparBancoDeDados() {
        Agenda_DB listaDb = new Agenda_DB(MainActivity.this);
        listaDb.limparTabela("Lista"); // Chama o método limparTabela() da classe Lista_DB para apagar todos os registros da tabela "Lista"
        listaDb.close();
    }
}