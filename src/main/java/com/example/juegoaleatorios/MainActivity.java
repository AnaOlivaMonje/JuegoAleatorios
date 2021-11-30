package com.example.juegoaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton botonDados, botonGanador, botonAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        acciones();

    }

    private void acciones() {

        botonAleatorio.setOnClickListener(this);
        botonGanador.setOnClickListener(this);
        botonDados.setOnClickListener(this);

    }

    private void instancias() {

        botonDados = findViewById(R.id.boton_dados);
        botonGanador = findViewById(R.id.boton_ganador);
        botonAleatorio = findViewById(R.id.boton_inicial);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()){

            case R.id.boton_dados:
                intent = new Intent(MainActivity.this, dadoActivity.class);

                        break;

            case R.id.boton_inicial:
                intent = new Intent(MainActivity.this, aleatorioActivity.class);
                break;
            case R.id.boton_ganador:
                intent = new Intent(MainActivity.this, ganadorActivity.class);
                break;
        }
startActivity(intent);
    }
}