package com.brainacad.hometask16;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText messageEdit;
    private Handler handler;
    private final Random generatorTime = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadPref();
        messageEdit = findViewById(R.id.notif);

        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, NotifService.class);
                intent.putExtra(NotifService.TEXT_NOTIF, messageEdit.getText().toString());
                startService(intent);
                handler.postDelayed(this, generatorTime.nextInt(50_000) + 1_000);
            }

        });


    }

    void loadPref() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String userPass = sharedPreferences.getString("text edit", null);
        if (userPass != null)
            messageEdit.setText(userPass);
    }

    void savePref() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.getString("text edit", messageEdit.getText().toString());
    }

    @Override
    protected void onPause() {
        savePref();
        super.onPause();

    }

}
