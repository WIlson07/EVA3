package com.example.wilson.eva3_6_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    Handler hHandler = new Handler();
    TextView txtVwDatos;

    //RUNNABLE 1 - TRABAJO PESADO EN 2DO PLANO
    Runnable rBackground = new Runnable() {
        @Override
        public void run() {
            while (true) {

                hHandler.post(rRunUI);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    //RUNNABLE 2 - TRANAJO LIGERO EN LA IU
    int iNum = 1;
    Runnable rRunUI = new Runnable() {
        @Override
        public void run() {
            //AQUI SI PODEMOS INTERACTUAR CON LA INTERFAZ GRAFICA
            txtVwDatos.append((iNum++) + " - ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwDatos = findViewById(R.id.txtVwDatos);

        Thread tHilo = new Thread(rBackground);
        tHilo.start();
    }
}
