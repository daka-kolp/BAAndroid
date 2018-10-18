package com.brainacad.apptask16;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

public class LocalService extends Service {

    private final IBinder binder = new LocalBinder();
    private final Random generator = new Random();

    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int getRundomNumber() {
        return generator.nextInt(100);
    }
}
