package com.brainacad.hometask16;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NotifService extends Service {

    private Timer timer;
    private Handler handler;
    public static final String TEXT_NOTIF = "notification text";
    private static final int NOTIFICATION_ID = 313;

    private String message;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();
        timer = new Timer();
        message = intent.getStringExtra(TEXT_NOTIF);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(message)
                .build();
        Log.d("TAG", "run: " + message);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
