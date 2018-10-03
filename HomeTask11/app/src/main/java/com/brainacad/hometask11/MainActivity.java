package com.brainacad.hometask11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;


    private void loadPref() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String userName = sharedPreferences.getString("User name", getString(R.string.user_name));
        usernameET.setText(userName);
        String userPass = sharedPreferences.getString("User password", getString(R.string.password));
        passwordET.setText(userPass);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        usernameET = findViewById(R.id.enter_user_name);
        passwordET = findViewById(R.id.enter_password);

        loadPref();

        loginBtn = findViewById(R.id.button_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOnLogin();
            }
        });
    }

    private void clickOnLogin() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("User name", usernameET.getText().toString());
        editor.putString("User password", passwordET.getText().toString());
        editor.apply();
    }


}
