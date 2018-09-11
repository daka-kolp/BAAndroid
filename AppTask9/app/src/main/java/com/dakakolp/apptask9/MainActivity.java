package com.dakakolp.apptask9;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first_fragment:
                startFirstFragment();
                return true;

            case R.id.second_fragment:
                startSecondFragment();
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @SuppressLint("ResourceType")
    private void startFirstFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.frame_main_activity, firstFragment);
        fragmentTransaction.commit();
    }


    @SuppressLint("ResourceType")
    private void startSecondFragment() {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main_activity, new SecondFragment())
                .commit();

    }

}
