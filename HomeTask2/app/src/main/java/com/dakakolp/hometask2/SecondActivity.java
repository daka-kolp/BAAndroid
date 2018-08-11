package com.dakakolp.hometask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button open_third_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        open_third_activity = findViewById(R.id.open_third_activity);
        open_third_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_third_activity.setBackgroundResource(R.color.Red);
                start();
                finish();
            }
        });
    }
    private void start(){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
