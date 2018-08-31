package com.dakakolp.apptask7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button changeButton;
    private Button changeColorButton;
    private TextView dataColor;

    public static final int CODE_FOR_IMAGE_CHOICE_ACTIVITY = 13;
    public static final int CODE_FOR_COLOR_CHOICE_ACTIVITY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.new_image);
        changeButton = findViewById(R.id.change_button);
        changeColorButton = findViewById(R.id.change_color_button);

        dataColor = findViewById(R.id.name);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);

                startActivityForResult(intent, CODE_FOR_IMAGE_CHOICE_ACTIVITY);
            }
        });

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);

                startActivityForResult(intent, CODE_FOR_COLOR_CHOICE_ACTIVITY);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CODE_FOR_IMAGE_CHOICE_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();

                    int id = bundle.getInt(ImageActivity.ID_IMAGE);
                    image.setImageResource(id);
                    dataColor.setText("");

                }
                break;
            case CODE_FOR_COLOR_CHOICE_ACTIVITY:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();

                    int id = bundle.getInt(ColorActivity.ID_COLOR);
                    String name = bundle.getString(ColorActivity.NAME_COLOR);

                    image.setImageResource(id);
                    dataColor.setText(name);
                }
                break;
        }
    }
}
