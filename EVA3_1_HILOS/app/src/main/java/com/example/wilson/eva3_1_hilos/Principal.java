package com.example.wilson.eva3_1_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView txtVwDatos;

    Runnable rMiHiloRun = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++){
                Log.wtf("Runnable",i+"");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    Runnable rHilo = new Runnable() {
        @Override
        public void run() {
            while(true){

                try {
                    txtVwDatos.setText("hola");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwDatos = findViewById(R.id.txtVwDatos);

        //RUNNABLES (INTERFAZ) Y THREAD(CLASE)

        //RUNNABLE
        Thread tHilo =  new Thread(rMiHiloRun);
        tHilo.start();
        MiHilo tMiHilo = new MiHilo();
        tMiHilo.start();

        MiHilo otro = new MiHilo();
        otro.start();//genera trabajo en segundo plano
       // otro.run();//traba la app



    }

    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 20; i++){
                Log.wtf("Thread",i+"");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
