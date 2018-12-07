package com.example.wilson.eva3_13_media_player_servicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioPlay extends Service {
    public ServicioPlay() {
    }
    MediaPlayer mpRep = null;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mpRep = MediaPlayer.create(this, R.raw.around);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mpRep != null){
            mpRep.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mpRep != null){
            mpRep.stop();
            mpRep.release();
        }
    }
}
