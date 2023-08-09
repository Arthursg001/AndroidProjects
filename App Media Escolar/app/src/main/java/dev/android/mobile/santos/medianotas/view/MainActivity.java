package dev.android.mobile.santos.medianotas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.android.mobile.santos.medianotas.R;
import dev.android.mobile.santos.medianotas.controller.NotasController;
import dev.android.mobile.santos.medianotas.model.Notas;

public class MainActivity extends AppCompatActivity {

    NotasController controller;
    Notas AlunoMat, AlunoPor, AlunoGeo, AlunoHis, AlunoFis;
    EditText nomeAluno;

    String disMat = "Matemática";
    String disPor = "Português";
    String disGeo = "Geografia";
    String disHis = "História";
    String disFis = "Física";

    EditText nota1Matematica, nota2Matematica, nota3Matematica, nota4Matematica;
    EditText nota1Portugues, nota2Portugues, nota3Portugues, nota4Portugues;
    EditText nota1Geografia, nota2Geografia, nota3Geografia, nota4Geografia;
    EditText nota1Historia, nota2Historia, nota3Historia, nota4Historia;
    EditText nota1Fisica, nota2Fisica, nota3Fisica, nota4Fisica;

    Button btnLimpar, btnCalcular, btnSalvar;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new NotasController(MainActivity.this);

        AlunoMat = new Notas();
        AlunoPor = new Notas();
        AlunoGeo = new Notas();
        AlunoHis = new Notas();
        AlunoFis = new Notas();

        nomeAluno = findViewById(R.id.editNomeAluno);

        nota1Matematica = findViewById(R.id.nota1_Matematica);
        nota2Matematica = findViewById(R.id.nota2_Matematica);
        nota3Matematica = findViewById(R.id.nota3_Matematica);
        nota4Matematica = findViewById(R.id.nota4_Matematica);

        nota1Portugues = findViewById(R.id.nota1_Portugues);
        nota2Portugues = findViewById(R.id.nota2_Portugues);
        nota3Portugues = findViewById(R.id.nota3_Portugues);
        nota4Portugues = findViewById(R.id.nota4_Portugues);

        nota1Geografia = findViewById(R.id.nota1_Geografia);
        nota2Geografia = findViewById(R.id.nota2_Geografia);
        nota3Geografia = findViewById(R.id.nota3_Geografia);
        nota4Geografia = findViewById(R.id.nota4_Geografia);

        nota1Historia = findViewById(R.id.nota1_Historia);
        nota2Historia = findViewById(R.id.nota2_Historia);
        nota3Historia = findViewById(R.id.nota3_Historia);
        nota4Historia = findViewById(R.id.nota4_Historia);

        nota1Fisica = findViewById(R.id.nota1_Fisica);
        nota2Fisica = findViewById(R.id.nota2_Fisica);
        nota3Fisica = findViewById(R.id.nota3_Fisica);
        nota4Fisica = findViewById(R.id.nota4_Fisica);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        txtResultado = findViewById(R.id.txtResultado);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nomeAluno.setText("");

                nota1Matematica.setText("");
                nota2Matematica.setText("");
                nota3Matematica.setText("");
                nota4Matematica.setText("");

                nota1Portugues.setText("");
                nota2Portugues.setText("");
                nota3Portugues.setText("");
                nota4Portugues.setText("");

                nota1Geografia.setText("");
                nota2Geografia.setText("");
                nota3Geografia.setText("");
                nota4Geografia.setText("");

                nota1Historia.setText("");
                nota2Historia.setText("");
                nota3Historia.setText("");
                nota4Historia.setText("");

                nota1Fisica.setText("");
                nota2Fisica.setText("");
                nota3Fisica.setText("");
                nota4Fisica.setText("");

                txtResultado.setText("Resultado");

                btnSalvar.setEnabled(false);
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean dadosOk = true;

                if(TextUtils.isEmpty(nomeAluno.getText()) ){
                    nomeAluno.setError("Obrigatório ter Nota desta Materia");
                    nomeAluno.requestFocus();
                    dadosOk =false;
                }
                if(TextUtils.isEmpty(nota2Matematica.getText())){
                    nota2Matematica.setError("Obrigatório ter Nota desta Materia");
                    nota2Matematica.requestFocus();
                    dadosOk =false;
                }
                if(TextUtils.isEmpty(nota3Matematica.getText())){
                    nota3Matematica.setError("Obrigatório ter Nota desta Materia");
                    nota3Matematica.requestFocus();
                    dadosOk =false;
                }
                if(TextUtils.isEmpty(nota4Matematica.getText())){
                    nota4Matematica.setError("Obrigatório ter Nota desta Materia");
                    nota4Matematica.requestFocus();
                    dadosOk =false;
                }
                if(TextUtils.isEmpty(nota1Matematica.getText())){
                    nota1Matematica.setError("Obrigatório ter Nota desta Materia");
                    nota1Matematica.requestFocus();
                    dadosOk =false;
                }

                if(TextUtils.isEmpty(nota1Portugues.getText())){
                    nota1Portugues.setError("Obrigatório ter Nota desta Materia");
                    nota1Portugues.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota2Portugues.getText())){
                    nota2Portugues.setError("Obrigatório ter Nota desta Materia");
                    nota2Portugues.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota3Portugues.getText())){
                    nota3Portugues.setError("Obrigatório ter Nota desta Materia");
                    nota3Portugues.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota4Portugues.getText())){
                    nota4Portugues.setError("Obrigatório ter Nota desta Materia");
                    nota4Portugues.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota1Geografia.getText())){
                    nota1Geografia.setError("Obrigatório ter Nota desta Materia");
                    nota1Geografia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota2Geografia.getText())){
                    nota2Geografia.setError("Obrigatório ter Nota desta Materia");
                    nota2Geografia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota3Geografia.getText())){
                    nota3Geografia.setError("Obrigatório ter Nota desta Materia");
                    nota3Geografia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota4Geografia.getText())){
                    nota4Geografia.setError("Obrigatório ter Nota desta Materia");
                    nota4Geografia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota1Historia.getText())){
                    nota1Historia.setError("Obrigatório ter Nota desta Materia");
                    nota1Historia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota2Historia.getText())){
                    nota2Historia.setError("Obrigatório ter Nota desta Materia");
                    nota2Historia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota3Historia.getText())){
                    nota3Historia.setError("Obrigatório ter Nota desta Materia");
                    nota3Historia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota4Historia.getText())){
                    nota4Historia.setError("Obrigatório ter Nota desta Materia");
                    nota4Historia.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota1Fisica.getText())){
                    nota1Fisica.setError("Obrigatório ter Nota desta Materia");
                    nota1Fisica.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota2Fisica.getText())){
                    nota2Fisica.setError("Obrigatório ter Nota desta Materia");
                    nota2Fisica.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota3Fisica.getText())){
                    nota3Fisica.setError("Obrigatório ter Nota desta Materia");
                    nota3Fisica.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(nota4Fisica.getText())){
                    nota4Fisica.setError("Obrigatório ter Nota desta Materia");
                    nota4Fisica.requestFocus();
                    dadosOk = false;
                }

                if(dadosOk){

                    String nome = String.valueOf(nomeAluno.getText());
                    double nota1mat = Double.parseDouble(String.valueOf(nota1Matematica.getText()));
                    double nota2mat = Double.parseDouble(String.valueOf(nota2Matematica.getText()));
                    double nota3mat = Double.parseDouble(String.valueOf(nota3Matematica.getText()));
                    double nota4mat = Double.parseDouble(String.valueOf(nota4Matematica.getText()));
                    String fraseMat;
                    AlunoMat.setNomeAluno(nome);
                    AlunoMat.setDisciplina(disMat);
                    AlunoMat.setN1(nota1mat);
                    AlunoMat.setN2(nota2mat);
                    AlunoMat.setN3(nota3mat);
                    AlunoMat.setN4(nota4mat);
                    fraseMat = controller.calcular(AlunoMat);

                    double nota1Por = Double.parseDouble(String.valueOf(nota1Portugues.getText()));
                    double nota2Por = Double.parseDouble(String.valueOf(nota2Portugues.getText()));
                    double nota3Por = Double.parseDouble(String.valueOf(nota3Portugues.getText()));
                    double nota4Por = Double.parseDouble(String.valueOf(nota4Portugues.getText()));
                    String frasePort;
                    AlunoPor.setNomeAluno(nome);
                    AlunoPor.setDisciplina(disPor);
                    AlunoPor.setN1(nota1Por);
                    AlunoPor.setN2(nota2Por);
                    AlunoPor.setN3(nota3Por);
                    AlunoPor.setN4(nota4Por);
                    frasePort = controller.calcular(AlunoPor);

                    double nota1Geo = Double.parseDouble(String.valueOf(nota1Geografia.getText()));
                    double nota2Geo = Double.parseDouble(String.valueOf(nota2Geografia.getText()));
                    double nota3Geo = Double.parseDouble(String.valueOf(nota3Geografia.getText()));
                    double nota4Geo = Double.parseDouble(String.valueOf(nota4Geografia.getText()));
                    String fraseGeo;
                    AlunoGeo.setNomeAluno(nome);
                    AlunoGeo.setDisciplina(disGeo);
                    AlunoGeo.setN1(nota1Geo);
                    AlunoGeo.setN2(nota2Geo);
                    AlunoGeo.setN3(nota3Geo);
                    AlunoGeo.setN4(nota4Geo);
                    fraseGeo = controller.calcular(AlunoGeo);

                    double nota1his = Double.parseDouble(String.valueOf(nota1Historia.getText()));
                    double nota2his = Double.parseDouble(String.valueOf(nota2Historia.getText()));
                    double nota3his = Double.parseDouble(String.valueOf(nota3Historia.getText()));
                    double nota4his = Double.parseDouble(String.valueOf(nota4Historia.getText()));
                    String fraseHis;
                    AlunoHis.setNomeAluno(nome);
                    AlunoHis.setDisciplina(disHis);
                    AlunoHis.setN1(nota1his);
                    AlunoHis.setN2(nota2his);
                    AlunoHis.setN3(nota3his);
                    AlunoHis.setN4(nota4his);
                    fraseHis = controller.calcular(AlunoHis);

                    double nota1fis = Double.parseDouble(String.valueOf(nota1Fisica.getText()));
                    double nota2fis = Double.parseDouble(String.valueOf(nota2Fisica.getText()));
                    double nota3fis = Double.parseDouble(String.valueOf(nota3Fisica.getText()));
                    double nota4fis = Double.parseDouble(String.valueOf(nota4Fisica.getText()));
                    String fraseFis;
                    AlunoFis.setNomeAluno(nome);
                    AlunoFis.setDisciplina(disFis);
                    AlunoFis.setN1(nota1fis);
                    AlunoFis.setN2(nota2fis);
                    AlunoFis.setN3(nota3fis);
                    AlunoFis.setN4(nota4fis);
                    fraseFis = controller.calcular(AlunoFis);

                    txtResultado.setText( " "+ nome + "\n" +
                            " " + fraseMat + "\n" +
                            " " + frasePort + "\n" +
                            " " + fraseGeo + "\n" +
                            " " + fraseHis + "\n" +
                            " " + fraseFis);

                    btnSalvar.setEnabled(true);

                }else{
                    Toast.makeText(MainActivity.this, "Digite os dados!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controller.salvar(AlunoMat);
                controller.salvar(AlunoPor);
                controller.salvar(AlunoGeo);
                controller.salvar(AlunoHis);
                controller.salvar(AlunoFis);
            }
        });

    }
}