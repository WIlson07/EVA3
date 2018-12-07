package com.example.wilson.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView txtVwDatos;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwDatos = findViewById(R.id.txtVwDatos);
        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();
        maTareaAsin.execute("Hola", "Mundo");
    }

    class MiClaseAsincrona extends AsyncTask<String, Integer, Void>{

        String sCade;
        public MiClaseAsincrona() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwDatos.setText("Iniciando Tarea Asincrona: ");
        }

        //UNICO METODO QUE NO SE COMUNICA CON INTERFAZ GRAFICA
        @Override
        protected Void doInBackground(String... strings) {
            sCade = strings[0] + " " + strings[1];
            while(true){
                try {
                    Thread.sleep(50);
                    publishProgress(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtVwDatos.append(i + " - ");
        }
    }
}
