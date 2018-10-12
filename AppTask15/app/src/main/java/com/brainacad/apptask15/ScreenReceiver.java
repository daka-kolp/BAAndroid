package com.brainacad.apptask15;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class ScreenReceiver extends BroadcastReceiver {

    private List<String> listLog;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            MainActivity.listLog.add("onReceive: screen_off");

            Log.d("Check", "onReceive: screen_off");
            Toast.makeText(context, "nReceive: screen_off", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            MainActivity.listLog.add("onReceive: screen_on");

            Log.d("Check", "onReceive: screen_on");
            Toast.makeText(context, "onReceive: screen_on", Toast.LENGTH_LONG).show();
        }
    }
}
