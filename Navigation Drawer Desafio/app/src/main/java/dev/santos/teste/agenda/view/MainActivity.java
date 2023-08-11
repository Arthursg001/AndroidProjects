package dev.santos.teste.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dev.samuel.teste.agenda.R;
import dev.santos.teste.agenda.controller.ImcContoller;
import dev.santos.teste.agenda.model.Calculadora;
import dev.santos.teste.agenda.database.IMC_BD;

public class MainActivity extends AppCompatActivity {

    // Constante Contenido Actividad
    private final static int CONT_ATIVIDADE = 0;
    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;
    Toolbar toolbar;

    //Main

    Calculadora calculadora;
    Calculadora outraCalculadora;

    ImcContoller controller;

    EditText editPeso;
    EditText editAltura;
    TextView txtResultado;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar1);

        // Componente ViewFlipper
        vf = (ViewFlipper)findViewById(R.id.vf);
        vf.setDisplayedChild(CONT_ATIVIDADE);

        // Componente NavigationDrawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent sendIntent;
                if (item.getItemId() == R.id.nav_item_one) {
                    // Se inicia Actividad 1
//                    sendIntent = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_two) {
                    // Se inicia Actividad 2
                    sendIntent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_three) {
                    // Se inicia Actividad 3
                    sendIntent = new Intent(MainActivity.this, Activity3.class);
                    startActivity(sendIntent);
                }

                // Close the navigation drawer when an item is selected
                drawerLayout.closeDrawers();
                return true;
            }
        });



        controller = new ImcContoller(MainActivity.this);
        controller.toString();

        outraCalculadora = new Calculadora();
        controller.buscar(outraCalculadora);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        txtResultado = findViewById(R.id.textResultado);

        btnLimpar = findViewById(R.id.button_Limpar);
        btnSalvar = findViewById(R.id.button_Salvar);
        btnFinalizar = findViewById(R.id.button_Finalizar);
        btnCalcular = findViewById(R.id.button_Calcular);

        editPeso.setText(outraCalculadora.getPeso());
        editAltura.setText(outraCalculadora.getAltura());
        txtResultado.setText(outraCalculadora.getResultado());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparBancoDeDados();
                Toast.makeText(MainActivity.this, "Limpo com Sucesso!", Toast.LENGTH_LONG).show();
                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, " Volte ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outraCalculadora.setPeso(editPeso.getText().toString());
                outraCalculadora.setAltura(editAltura.getText().toString());
                outraCalculadora.setResultado(txtResultado.getText().toString());


                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();
                controller.salvar(outraCalculadora);

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImc(v);
            }
        });
    }

    private void limparBancoDeDados() {
        IMC_BD listaDb = new IMC_BD(MainActivity.this);
        listaDb.limparTabela("IMC"); // Chama o método limparTabela() da classe Lista_DB para apagar todos os registros da tabela "Lista"
        listaDb.close();
    }

    public void calcularImc(View view){
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = (peso / (altura * altura));

        if(resultado < 19){
            txtResultado.setText((String.format("Abaixo do peso %.2f", resultado)));

        } else if (resultado < 30){
            txtResultado.setText((String.format("Peso normal %.2f", resultado)));


        } else if (resultado < 40) {
            txtResultado.setText((String.format("Sobrepeso %.2f", resultado)));
        }
    }


}