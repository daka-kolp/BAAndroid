package com.dakakolp.hometask8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CALL = 1;

    private EditText editText;
    private EditText editWWW;
    private Button button;
    private Button buttonWWW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT, editText.getText());
//
//                intent.setType("text/plain");//что передаем
//                startActivity(intent);

                makePhoneCall();

            }
        });

        editWWW = findViewById(R.id.edit_www);
        buttonWWW = findViewById(R.id.button_www);

        buttonWWW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHttpPage();
            }
        });
    }

    private void openHttpPage() {

        String httpPage = editWWW.getText().toString();
        if (httpPage.trim().length() > 0) {
            String dial = "http://" + httpPage;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(dial));
            startActivity(intent);
        }

    }

    private void makePhoneCall() {
        String number = editText.getText().toString();

        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse(dial));
                Intent chosenInt = Intent.createChooser(intent, "Chose app...");
                startActivity(chosenInt);
            }
        } else {
            Toast.makeText(MainActivity.this, "Enter number", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
