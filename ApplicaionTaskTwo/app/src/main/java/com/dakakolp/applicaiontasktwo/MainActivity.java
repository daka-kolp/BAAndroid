package com.dakakolp.applicaiontasktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openActivity;
    Button open3;
    Button open4;
    Button open5;
    private Cat cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openActivity = findViewById(R.id.button);

        open3 = findViewById(R.id.button_activity_3);
        open3.setText(getString(R.string.activity2));
        //open3.setBackgroundColor(getColor(R.color.colorRed));
        open3.setBackgroundResource(R.color.colorRed);
        open4 = findViewById(R.id.button_activity_4);
        open5 = findViewById(R.id.button_activity_5);

        cat = new Cat();
        cat.setHeight(12);
        cat.setWidth(12);
        cat.setName("Cat");

        openActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cat.setHeight(45);
                startSecondActivity();


            }
        });
        open3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThirdActivity();
            }
        });

        open4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startForthActivity();
            }
        });
        open5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFifthActivity();
            }
        });
    }

    private void startSecondActivity() {
        Intent startIntent = new Intent(this, SecondActivity.class);
        startActivity(startIntent);
    }

    private void startThirdActivity() {
        Intent startIntent = new Intent(this, ThirdActivity.class);
        startActivity(startIntent);
    }

    private void startForthActivity() {
        Intent startIntent = new Intent(this, FourthActivity.class);
        startActivity(startIntent);
    }

    private void startFifthActivity() {
        Intent startIntent = new Intent(this, FifthActivity.class);
        startActivity(startIntent);
    }

}
