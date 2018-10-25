package com.brainacad.hometask18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_url);
        Picasso picasso = Picasso.get();
        picasso.load("http://smktesting.herokuapp.com/static/img2.png")
                .into(imageView);


    }

}
