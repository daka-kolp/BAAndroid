package com.dakakolp.hometask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button openSecondActivity;
    private boolean mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openActivity();

    }

    private void openActivity(){
        openSecondActivity = findViewById(R.id.open_second_activity);
        openSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mark){
                    openSecondActivity.setBackgroundResource(R.color.Green);
                    mark = false;
                } else {
                    openSecondActivity.setBackgroundResource(R.color.Purple);
                    mark = true;
                }
                start();
            }
        });
    }

    private void start(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
