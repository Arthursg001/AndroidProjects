package com.example.applistadetarefas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadetarefas.R;
import com.example.applistadetarefas.controller.PessoaController;
import com.example.applistadetarefas.controller.TarefaController;
import com.example.applistadetarefas.database.Tarefas_DB;
import com.example.applistadetarefas.model.Pessoa;
import com.example.applistadetarefas.model.Tarefa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TarefaController tarefaController;
    Tarefa novaTarefa;
    List<String> listaTarefa;

    EditText editNomeDaTarefa;
    EditText editDescricao;
    EditText editDataDeConclusao;

    Button editBtnLimpar;
    Button editBtnSalvar;
    Button editBtnFinalizar;

    Spinner edit_Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaController pessoaController = new PessoaController();

        listaTarefa = pessoaController.dadosSpinner();

        tarefaController = new TarefaController(MainActivity.this);
        tarefaController.toString();

        novaTarefa = new Tarefa();
        tarefaController.buscar(novaTarefa);

        editNomeDaTarefa = findViewById(R.id.edit_nome_da_tarefa);
        editDescricao = findViewById(R.id.edit_descricao);
        editDataDeConclusao = findViewById(R.id.edit_data_de_conclusao);

        editBtnLimpar = findViewById(R.id.btn_limpar);
        editBtnSalvar = findViewById(R.id.btn_salvar);
        editBtnFinalizar = findViewById(R.id.btn_finalizar);

        edit_Spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparBancoDeDados();
                Toast.makeText(MainActivity.this,"Limpo com sucesso", Toast.LENGTH_LONG).show();
                tarefaController.editar();
            }
        });

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaTarefa.setNomeDaTarefa(editNomeDaTarefa.getText().toString());
                novaTarefa.setDescricao(editDescricao.getText().toString());
                novaTarefa.setDataDeConclusao(editDataDeConclusao.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos" + novaTarefa.toString(), Toast.LENGTH_LONG).show();

                tarefaController.salvar(novaTarefa);

                Tarefa tarefa = new Tarefa();
                tarefa.setNomeDaTarefa(editNomeDaTarefa.getText().toString());
                tarefa.setDescricao(editDescricao.getText().toString());
                tarefa.setDataDeConclusao(editDataDeConclusao.getText().toString());

                tarefaController.salvarDb(tarefa);

                editNomeDaTarefa.setText("");
                editDescricao.setText("");
                editDataDeConclusao.setText("");
            }
        });

        editBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Voltar", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private void limparBancoDeDados() {
        Tarefas_DB listaDb = new Tarefas_DB(MainActivity.this);
        listaDb.limparTabela("Lista"); // Chama o método limparTabela() da classe Lista_DB para apagar todos os registros da tabela "Lista"
        listaDb.close();
    }
}
