package com.dakakolp.hometask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button closeThirdActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        closeThirdActivity = findViewById(R.id.close_activity);
        closeThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeThirdActivity.setBackgroundResource(R.color.Blue);
                finish();
            }
        });
    }


}
