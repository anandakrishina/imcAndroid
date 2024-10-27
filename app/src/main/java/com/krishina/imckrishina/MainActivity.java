package com.krishina.imckrishina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextAltura;
    private EditText editTextPeso;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                Double altura = Double.parseDouble(editTextAltura.getText().toString());
                Double peso = Double.parseDouble(editTextPeso.getText().toString());
                Pessoa pessoa = new Pessoa(nome,peso,altura);
                Double imc = pessoa.getImc();
                startActivityResultado(nome,imc,altura,peso);
            }
        });

        }
    private void startActivityResultado(String nome, Double imc, Double altura, Double peso) {
        Intent it;
        it = new Intent(MainActivity.this, Activity2.class);
        it.putExtra("IMC",imc);
        it.putExtra("nome",nome);
        it.putExtra("altura",altura);
        it.putExtra("peso",peso);
        startActivity(it);
    }
}


