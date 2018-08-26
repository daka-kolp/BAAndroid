package com.dakakolp.applicationtask1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dakakolp.applicationtaskone.R;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private EditText editText;
    private Button button;
    private String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.newText);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.buttonOk);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newString = editText.getText().toString();
                text.setText(newString);
            }
        });
    }
}
