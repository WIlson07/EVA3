package com.example.wilson.eva3_11_broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent inServicio;
    TextView txtVwDatos;
    BroadcastReceiver miBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio = new Intent(this, MiServicio.class);
        txtVwDatos = findViewById(R.id.txtVwDatos);

        miBroadcast = new MiBroadcast();
        IntentFilter ifFiltrar = new IntentFilter("MiServicio");
        registerReceiver(miBroadcast, ifFiltrar);
    }

    public void onIniciar(View view){
        startService(inServicio);
    }

    public void onDetener(View view){
        stopService(inServicio);
    }

    class MiBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String datos = intent.getStringExtra("MENSAJE");
            txtVwDatos.append(datos);
        }
    }
}
