package com.brainacad.apptask15;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private ScreenReceiver screenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onPause() {
        unregisterReceiver(screenReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        this.screenReceiver = new ScreenReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);

        registerReceiver(this.screenReceiver, filter);

        Log.d("tag", "onResume: " + filter.getAction(0) + " " + filter.getAction(1));

        super.onResume();
    }

}
