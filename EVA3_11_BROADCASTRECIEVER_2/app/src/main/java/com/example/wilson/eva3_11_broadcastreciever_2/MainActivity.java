package com.example.wilson.eva3_11_broadcastreciever_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMostrar;
    BroadcastReceiver miBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        miBroadcast = new MiBroadcast();
        IntentFilter ifFiltrar = new IntentFilter("MiServicio");
        registerReceiver(miBroadcast, ifFiltrar);
    }

    class MiBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String datos = intent.getStringExtra("MENSAJE");
            txtVwMostrar.append(datos);
        }
    }
}
