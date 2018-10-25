package com.brainacad.hometask17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button button;

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextTitle = findViewById(R.id.title_post_text);
        editTextMessage = findViewById(R.id.general_post_text);
        button = findViewById(R.id.button_post_text);


        post = new Post(5555);
        post.setTitle(editTextTitle.getText().toString());
        post.setBody(editTextMessage.getText().toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ApiManager().makePost(post);

            }
        });


    }
}
