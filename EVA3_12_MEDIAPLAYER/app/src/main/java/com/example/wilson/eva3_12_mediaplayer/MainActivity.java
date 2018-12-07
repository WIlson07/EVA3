package com.example.wilson.eva3_12_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mpRep = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpRep = MediaPlayer.create(this, R.raw.findme);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mpRep != null){
            mpRep.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mpRep != null){
            mpRep.stop();
            mpRep.release();
        }
    }
}
