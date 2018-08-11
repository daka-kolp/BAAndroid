package com.dakakolp.applicaiontasktwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView activity;
    Button close;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) { //savedInsState can be null
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //binding activity and layout

        close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
