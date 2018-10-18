package com.brainacad.apptask16;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private boolean serviceBounded;
    private LocalService.LocalBinder binder;

    private TextView textView;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_gen);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        Intent intent = new Intent(this, LocalService.class);

        bindService(
                intent,
                new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        serviceBounded = true;
                        binder = (LocalService.LocalBinder) service;
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        serviceBounded = false;
                    }
                },
                BIND_AUTO_CREATE
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceBounded) {
                    int rand = binder.getService().getRundomNumber();
                    textView.setText(String.valueOf(rand));
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, TimeService.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
