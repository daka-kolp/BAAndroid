package com.dakakolp.applicationtask6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, button);
                popup.getMenuInflater().inflate(R.menu.new_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();

                        return true;
                    }
                });

                popup.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String action = "";

        switch (item.getItemId()) {
            case R.id.create:
                action = "Create user";
                break;
            case R.id.delete:
                action = "Delete user";
                break;
            case R.id.deleteAll:
                action = "Delete all";
                break;
        }

        Toast.makeText(this, action, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
