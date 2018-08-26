package com.dakakolp.hometask1calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dakakolp.calc.R;

public class MainActivity extends AppCompatActivity {

    EditText firstValue;
    EditText secondValue;
    TextView resultValue;
    Button plusB;
    Button minusB;
    Button multiplyB;
    Button divideB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstValue = findViewById(R.id.one);
        secondValue = findViewById(R.id.two);
        resultValue = findViewById(R.id.result);
        plusB = findViewById(R.id.plus);
        minusB = findViewById(R.id.minus);
        multiplyB = findViewById(R.id.multiply);
        divideB = findViewById(R.id.divide);

        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }
}
