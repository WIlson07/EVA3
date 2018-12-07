package com.example.wilson.eva3_9_banner_asyn_task;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    int iCont = 1;
    ImageView imgVwBanner;

    Handler hManejador = new Handler(){
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
            //recibir un mensaje
            //cambiar la imagen
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    class ClaseAsincrona extends AsyncTask<String, Integer, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            while (true){
                try {
                    Thread.sleep(2000);
                    Message msg = hManejador.obtainMessage();
                    hManejador.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }


    }
}
