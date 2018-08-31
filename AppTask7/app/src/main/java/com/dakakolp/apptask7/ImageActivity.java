package com.dakakolp.apptask7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {

    private ImageView face1;
    private ImageView face2;
    private ImageView face3;
    private ImageView face4;
    private TextView textView;
    private Button buttonSetImage;

    private int idImage;

    public static final String ID_IMAGE = "IDImage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        face1 = findViewById(R.id.one);
        face2 = findViewById(R.id.two);
        face3 = findViewById(R.id.three);
        face4 = findViewById(R.id.four);

        face1.setImageResource(R.drawable.if_face1);
        face2.setImageResource(R.drawable.if_face2);
        face3.setImageResource(R.drawable.if_face3);
        face4.setImageResource(R.drawable.if_face4);

        textView = findViewById(R.id.text_image);
        buttonSetImage = findViewById(R.id.set_button);


        face1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idImage = R.drawable.if_face1;
                textView.setText("Face 1");
            }
        });
        face2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idImage = R.drawable.if_face2;
                textView.setText("Face 2");
            }
        });

        face3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idImage = R.drawable.if_face3;
                textView.setText("Face 3");
            }
        });

        face4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idImage = R.drawable.if_face4;
                textView.setText("Face 4");
            }
        });


        buttonSetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ID_IMAGE, idImage);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
