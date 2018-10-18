package com.brainacad.apptask15;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ScreenReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){

            Log.d("Check", "onReceive: screen_off");
            Toast.makeText(context, "nReceive: screen_off", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){

            Log.d("Check", "onReceive: screen_on");
            Toast.makeText(context, "onReceive: screen_on", Toast.LENGTH_LONG).show();
        }
        Log.d("Check", "onReceive: ");
    }
}
