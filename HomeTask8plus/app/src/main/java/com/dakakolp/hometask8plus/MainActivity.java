package com.dakakolp.hometask8plus;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private TextView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        runTimer();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
    }

    public void startTimer(View view) {
        running = true;
    }

    public void stopTimer(View view) {
        running = false;
    }

    public void restartTimer(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        timer = findViewById(R.id.time);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = MainActivity.this.seconds / 3600;
                int minutes = (MainActivity.this.seconds % 3600) / 60;
                int seconds = MainActivity.this.seconds % 60;

                @SuppressLint("DefaultLocale") String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                timer.setText(time);

                if(running) {
                    MainActivity.this.seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}
