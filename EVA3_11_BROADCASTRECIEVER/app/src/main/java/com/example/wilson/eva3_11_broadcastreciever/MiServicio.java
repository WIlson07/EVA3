package com.example.wilson.eva3_11_broadcastreciever;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {
    public MiServicio() {
    }

    Thread tHilo;
    Intent inDatos;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        inDatos = new Intent("MIS_SERVICIO");
        inDatos.putExtra("MENSAJE", "HOLA MUNDO!!!");
        sendBroadcast(inDatos);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
       final int i = 1;
        Runnable rnHilo = new Runnable() {
            @Override
            public void run() {
                while (i == 1){
                    try {
                        Log.wtf("MiServicio", "Hola");
                        inDatos = new Intent("MIS_SERVICIO");
                        inDatos.putExtra("MENSAJE", "HOLA MUNDO!!!");
                        sendBroadcast(inDatos);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        tHilo = new Thread(rnHilo);
        tHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        inDatos = new Intent("MIS_SERVICIO");
        inDatos.putExtra("MENSAJE", "HOLA MUNDO!!!");
        sendBroadcast(inDatos);
        tHilo.interrupt();
    }
}
