package com.example.juegoaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class aleatorioActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private TextView textoTitulo, textoGenerar, textoRepetir;
    private ToggleButton botonRepetir;
    private RadioGroup grupoRadios;
    private RadioButton radioNoEspecifico, radioEspecifico;
    private CheckBox checkDecimales;
    private EditText minimo, maximo, numeroDecimales,numeroTotales;
    private ImageButton botonIniciar;
    private Boolean especifico, booleanDecimal, booleanRepetir;
private int numeroAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instancias();
        acciones();
    }



    private void instancias() {
        textoTitulo = findViewById(R.id.titulo);
        textoGenerar = findViewById(R.id.texto_generar);
        textoRepetir = findViewById(R.id.texto_repetir);
        botonRepetir = findViewById(R.id.boton_repetir);
        grupoRadios = findViewById(R.id.grupo_radio);
        radioNoEspecifico = findViewById(R.id.radio_no_especifico);
        radioEspecifico = findViewById(R.id.radio_especifico);
        checkDecimales = findViewById(R.id.check_decimales);
        minimo = findViewById(R.id.minimo);
        maximo = findViewById(R.id.maximo);
        numeroDecimales = findViewById(R.id.numero_decimales);
        numeroTotales = findViewById(R.id.numero_totales);
        botonIniciar = findViewById(R.id.cohete);
        botonRepetir.setChecked(false);
        maximo.setEnabled(false);
        minimo.setEnabled(false);
        especifico=false;
        booleanDecimal=false;
        booleanRepetir=false;
        numeroAleatorio=0;
    }
    private void acciones() {

        grupoRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_especifico:
                        minimo.setEnabled(true);
                        maximo.setEnabled(true);
                        especifico = true;
                        break;

                    case R.id.radio_no_especifico:
                        minimo.setEnabled(false);
                        maximo.setEnabled(false);
                        especifico = false;
                        break;
                }
            }
        });
        botonRepetir.setOnCheckedChangeListener(this);
        checkDecimales.setOnCheckedChangeListener(this);
        botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoGenerar.setText("");
                double doubleAleatorio = 0;
                if (numeroTotales.getText().toString().equals("")) {
                    numeroTotales.setText("0");
                }
                if (booleanDecimal && numeroDecimales.getText().toString().equals("")) {
                    numeroDecimales.setText("0");
                }
                ArrayList lista = new ArrayList();
                for (int i = 0; Integer.parseInt(numeroTotales.getText().toString()) > i; i++) {
                    if (especifico) {
                        int max = Integer.parseInt(maximo.getText().toString());
                        int min = Integer.parseInt(minimo.getText().toString());
                        doubleAleatorio = (Math.random() * (max - min)) + min;
                    } else {
                        doubleAleatorio = (Math.random() * 100);
                    }
                    if (!booleanDecimal) {
                        numeroAleatorio = (int) doubleAleatorio;
                    }
                    if (booleanRepetir) {
                        if (booleanDecimal) {
                            doubleAleatorio = Math.floor(doubleAleatorio * (Math.pow(10, Double.parseDouble(numeroDecimales.getText().toString())))) / (Math.pow(10, Double.parseDouble(numeroDecimales.getText().toString())));
                            lista.add(doubleAleatorio);
                            textoGenerar.append(lista.get(i) + " ");
                        } else {
                            lista.add(numeroAleatorio);
                            textoGenerar.append(lista.get(i) + " ");
                        }
                    } else {
                        System.out.println(booleanDecimal + " " + !lista.contains(doubleAleatorio));
                        if (booleanDecimal && !lista.contains(doubleAleatorio)) {
                            doubleAleatorio = Math.floor(doubleAleatorio * (Math.pow(10, Double.parseDouble(numeroDecimales.getText().toString())))) / (Math.pow(10, Double.parseDouble(numeroDecimales.getText().toString())));
                            lista.add(doubleAleatorio);
                            textoGenerar.append(lista.get(i) + " ");
                        } else if (!booleanDecimal && !lista.contains(numeroAleatorio)) {
                            lista.add(numeroAleatorio);
                            textoGenerar.append(lista.get(i) + " ");
                        } else {
                            i--;
                        }

                    }
                }
            }
        });
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.check_decimales:

               if (checkDecimales.isChecked()){
                   booleanDecimal= true;
               }else{
                   booleanDecimal=false;
               }

                break;

            case R.id.boton_repetir:

                   if (botonRepetir.isChecked()){

                       booleanRepetir=true;
                   } else{
                       booleanRepetir=false;
                   }
                break;
        }
    }



}