package com.example.wilson.eva3_7_banner_post;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    int iCont = 1;
    ImageView imgVwBanner;
    Handler hHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch(iCont){
                case 1:
                    imgVwBanner.setImageResource(R.drawable.light_rain);
                    iCont++;
                    break;
                case 2:
                    imgVwBanner.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;

                case 3:
                    imgVwBanner.setImageResource(R.drawable.rainy);
                    iCont++;
                    break;
                default:
                    imgVwBanner.setImageResource(R.drawable.sunny);
                    iCont = 1;
            }
        }
    };


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
    int iNum =1;
    Runnable rRunUI = new Runnable() {
        @Override
        public void run() {
            //AQUI SI PODEMOS INTERACTUAR CON LA INTERFAZ GRAFICA

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



        Thread tHilo = new Thread(rBackground);
        tHilo.start();
    }

    class Banner extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(2000);
                    Message msg = hHandler.obtainMessage();
                    hHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
