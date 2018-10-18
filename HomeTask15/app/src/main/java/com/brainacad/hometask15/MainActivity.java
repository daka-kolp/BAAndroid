package com.brainacad.hometask15;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView message;
    private MessageReceiver messageReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        message = findViewById(R.id.message);



    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {

        messageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        } else {
            filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        }
        message.setText(messageReceiver.getMessage());
        registerReceiver(messageReceiver, filter);
        super.onResume();
    }
}
