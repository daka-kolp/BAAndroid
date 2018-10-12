package com.brainacad.apptask14;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        imageView = findViewById(R.id.image_gallery);
        textView = findViewById(R.id.tv);
        Intent intent = getIntent();
        String string = intent.getStringExtra("str");
        Uri uri = Uri.parse(string);
        imageView.setImageURI(uri);
        textView.setText(string);
    }
}
