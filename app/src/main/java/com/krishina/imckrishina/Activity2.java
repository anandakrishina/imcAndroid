package com.krishina.imckrishina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    private TextView textViewResultado;
    private TextView textViewNome;
    private TextView textViewPeso;
    private TextView textViewAltura;
    private Double imc,peso,altura;
    private String nome;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        textViewResultado = findViewById(R.id.textViewResultado);
        textViewNome = findViewById(R.id.textViewMostraNome);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewPeso = findViewById(R.id.textViewPeso);
        imageView = findViewById(R.id.imageIMC);

        Intent it = getIntent();
        imc = it.getDoubleExtra("IMC",0.0);
        nome = it.getStringExtra("nome");
        peso = it.getDoubleExtra("peso",0.0);
        altura = it.getDoubleExtra("altura",0.0);

        textViewResultado.setText(String.format("IMC = %.2f", imc));
        textViewNome.setText("NOME: "+nome.toUpperCase());
        textViewAltura.setText(String.format("%.2f m", altura));
        textViewPeso.setText(String.format("%.2f kg", peso));


        if(imc < 18.50){
            imageView.setImageResource(R.drawable.ativo_abaixo);
        } else if (imc <= 24.99 ) {
            imageView.setImageResource(R.drawable.ativo_normal);
        } else if (imc <= 29.99){
            imageView.setImageResource(R.drawable.ativo_sobrepeso);
        } else if(imc <=34.99){
            imageView.setImageResource(R.drawable.ativo_obesidade1);
        } else if(imc < 39.99){
            imageView.setImageResource(R.drawable.ativo_obesidade2);
        } else {
            imageView.setImageResource(R.drawable.ativo_obesidade3);
        }
    }
}