package com.dakakolp.hometask5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        Product p = (Product) b.getSerializable("Product");

        TextView t = findViewById(R.id.ingredients);

        t.setText(p.getDescription());

    }
}
