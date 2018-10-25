package com.brainacad.apptask19;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private EditText editText;
    private Button button;
    int num;
    private Random random;
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        progressBar = findViewById(R.id.progressbar);

        random = new Random(10000000);
        editText = findViewById(R.id.enter_num);
        button = findViewById(R.id.start_rand);

    }


    public class MyRandAsynkTask extends AsyncTask<Integer, Integer, Integer> {


        long time;

        @Override
        protected Integer doInBackground(Integer... integers) {
            num = Integer.parseInt(editText.getText().toString());
            int min = num - 500;
            int max = num + 500;
            int rundNum = 0;
            long beg = System.currentTimeMillis();
            //doesn't work with negative numb
//            boolean ifTrue1 = rundNum < min;
//            boolean ifTrue2 = rundNum > max;
//            boolean ifTrue3 = rundNum > min;
//            boolean ifTrue4 = rundNum < max;


            while (rundNum < min || rundNum > max) {
                rundNum = random.nextInt();
                Log.d("asyncTask", "doInBackground: num " + rundNum);
            }
            long end = System.currentTimeMillis();
            publishProgress(rundNum);
            time = (end - beg)/1000;
            Log.d("asyncTask", "doInBackground: time " + time);
            return rundNum;
        }

        @Override
        protected void onPostExecute(Integer integer) {//3
            Toast.makeText(MainActivity.this, "Number: " + integer + " Time: " + time, Toast.LENGTH_LONG).show();
        }
    }

    public void newOnClick(View view) {
        if (editText.getText().toString() != "")
            new MyRandAsynkTask().execute();
    }

    public void onClick(View view) {

        //handleFun();
       /* MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();*/
    }


    //AsyncTask
    public class MyAsyncTask extends AsyncTask<String, Integer, Integer> {
        @Override
        protected Integer doInBackground(String... strings) { //1
            int myProgress = 0;
            int n = 10000000;
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int integer = (int) Math.random();
                if (i % (n / 100) == 0)
                    publishProgress(myProgress++);// to onProgressUpdate
                arr.add(integer);
            }
            return arr.size();
        }


        @Override
        protected void onPostExecute(Integer integer) {//3
            Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {//2

            progressBar.setProgress(values[0]);

        }
    }

    //Handler
    private void handleFun() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        Integer integer = (Integer) msg.obj;
                        progressBar.setProgress(integer);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        Thread thread = new Thread(new Runnable() {

            int count = 0;

            @Override
            public void run() {
                int n = 10000000;
                List<Integer> arr = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    int integer = (int) Math.random();
                    if (i % (n / 100) == 0) {
                        count++;
                        Message m = handler.obtainMessage(1, count);
                        handler.sendMessage(m);
                    }
                    arr.add(integer);
                }
                handler.sendEmptyMessage(2);


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //can work with UI
                    }
                });
            }
        });
        thread.start();
    }

}
