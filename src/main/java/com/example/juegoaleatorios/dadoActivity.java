package com.example.juegoaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dadoActivity extends AppCompatActivity {

    private Button botonTirada;
    private ImageView imagenDado;

    private int numAleatorio;
    private int[] dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_activity);
        instancias();
        acciones();
    }

    private void acciones() {
        botonTirada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numAleatorio = (int) (Math.random()*6);
                imagenDado.setImageResource(dados[numAleatorio]);
            }
        });


    }

    private void instancias() {
        botonTirada = findViewById(R.id.boton_tirada_dados);
        imagenDado = findViewById(R.id.imagen_dados);
        numAleatorio = (int) (Math.random()*6);
        dados = new int[]{R.drawable.dado_uno, R.drawable.dado_dos, R.drawable.dado_tres, R.drawable.dado_cuatro, R.drawable.dado_cinco, R.drawable.dado_seis};
        imagenDado.setImageResource(dados[numAleatorio]);
    }
}