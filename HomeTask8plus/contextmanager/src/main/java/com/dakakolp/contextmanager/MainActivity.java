package com.dakakolp.contextmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewActivity(View view) {
        ContextManager cm = new ContextManager(this);
        cm.invokeActivities(NewActivity.class, New2Activity.class);
    }
}
