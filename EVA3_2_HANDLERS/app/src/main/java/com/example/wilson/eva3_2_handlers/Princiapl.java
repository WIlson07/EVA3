package com.example.wilson.eva3_2_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Princiapl extends AppCompatActivity {

    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //AQUI SI PUEDEN INTERACTUAR CON LA INTEFAZ GRAFICA
            //NADA DE TRABAJO PESADO
            if (msg.what == 1){
                int i = (int)msg.obj;
                txtVwDatos.append(i + " - ");
            }
        }
    };
    TextView txtVwDatos;
    Thread tHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princiapl);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        miHilo mHilo = new miHilo();
        tHilo = new Thread(mHilo);
        tHilo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
    }

    class miHilo implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while (true){
                i++;
                try {
                    Message msg = hManejador.obtainMessage(1, i);
                    hManejador.sendMessage(msg);
                    Log.wtf("Hilo", "i+ ");

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
