package com.dakakolp.applicationtaskt2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dakakolp.applicaiontasktwo.R;

public class FourthActivity extends AppCompatActivity {

    private Button closeFourth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        closeFourth = findViewById(R.id.activity_fourth);
        closeFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
