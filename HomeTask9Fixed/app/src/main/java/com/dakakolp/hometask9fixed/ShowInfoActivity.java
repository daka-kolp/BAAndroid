package com.dakakolp.hometask9fixed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dakakolp.hometask9fixed.classes.User;
import com.dakakolp.hometask9fixed.database.DBOpenHelper;

public class ShowInfoActivity extends AppCompatActivity {

    private TextView idClass;
    private TextView idDB;
    private TextView name;
    private TextView surname;
    private TextView age;
    private Button exit;

    private User user;

    public static final String USER_FOR_SHOW = "user for show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        idClass = findViewById(R.id.idClass);
        idDB = findViewById(R.id.idDB);
        name = findViewById(R.id.infoName);
        surname = findViewById(R.id.infoSurname);
        age = findViewById(R.id.infoAge);

        DBOpenHelper db = new DBOpenHelper(this);
        Intent intentForShowInfo = getIntent();
        int id = intentForShowInfo.getIntExtra(USER_FOR_SHOW, 0);
        user = db.getUser(id);
        idClass.setText(String.valueOf(user.getId()));
        idDB.setText(String.valueOf(user.getIdDB()));
        name.setText(user.getName());
        surname.setText(user.getSurname());
        age.setText(String.valueOf(user.getAge()));
    }

    public void closeActivity(View view) {
        finish();
    }
}
