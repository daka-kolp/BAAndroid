package com.dakakolp.apptask7;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button changeButton;
    private TextView dataImage;

    public static  final int CODE_FOR_CHOICE_ACTIVITY = 108;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.new_image);
        changeButton = findViewById(R.id.change_button);
        dataImage = findViewById(R.id.name);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);

                startActivityForResult(intent, CODE_FOR_CHOICE_ACTIVITY);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CODE_FOR_CHOICE_ACTIVITY:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();

                    int id = bundle.getInt("ID");
                    String name = bundle.getString("NameImage");

                    image.setImageResource(id);
                    dataImage.setText(name);
                }
                break;

        }
    }
}
