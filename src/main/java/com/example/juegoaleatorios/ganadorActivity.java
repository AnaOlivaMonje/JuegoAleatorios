package com.example.juegoaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ganadorActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText meterConcursante;
    private Button seleccionarGanador, añadirConcursante;
    private ArrayList<String> listaNombres;
    private int numAleatorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganador_activity);
        intancias();
        acciones();
    }

    private void acciones() {
        seleccionarGanador.setOnClickListener(this);
        añadirConcursante.setOnClickListener(this);


    }




    private void intancias() {

        meterConcursante = findViewById(R.id.edit_input_concursante);
        seleccionarGanador = findViewById(R.id.boton_elegir_ganador);
        añadirConcursante = findViewById(R.id.boton_agregar_concursante);
        listaNombres = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.boton_elegir_ganador:
                if (listaNombres.size() > 0) {
                    numAleatorio = (int) (Math.random() * listaNombres.size());
                    Toast.makeText(getApplicationContext(), listaNombres.get(numAleatorio), Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.boton_agregar_concursante:
                listaNombres.add(meterConcursante.getText().toString());
                break;

        }
    }
}