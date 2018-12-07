package com.example.wilson.eva3_13_media_player_servicios;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inServ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inServ = new Intent(this, ServicioPlay.class);

    }

    public void clickIni(View v){
        startService(inServ);

    }

    public void clickFin(View v){
        stopService(inServ);

    }
}
