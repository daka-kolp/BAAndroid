package com.brainacad.apptask16;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimeService extends Service {

    private Handler handler;

    private Timer timer;
    private int sec = 0;

    public class TimeBinder extends Binder{
        TimeService getService() {
            return TimeService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        handler = new Handler();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(TimeService.this, String.valueOf(sec++), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        },
        1_000, 10);

        return super.onStartCommand(intent, flags, startId);

    }
}
