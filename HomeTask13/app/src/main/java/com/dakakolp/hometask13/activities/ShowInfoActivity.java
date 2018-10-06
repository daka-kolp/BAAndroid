package com.dakakolp.hometask13.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dakakolp.hometask13.R;
import com.dakakolp.hometask13.classes.User;
import com.dakakolp.hometask13.dbrealm.UserDBRealm;

public class ShowInfoActivity extends AppCompatActivity {

    private TextView idTV;
    private TextView nameTV;
    private TextView surnameTV;
    private TextView ageTV;

    private UserDBRealm userDBRealm;
    private User user;

    public static final String USER_FOR_SHOW_ID = "userStringId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        userDBRealm = new UserDBRealm();

        idTV = findViewById(R.id.idDB);
        nameTV = findViewById(R.id.infoName);
        surnameTV = findViewById(R.id.infoSurname);
        ageTV = findViewById(R.id.infoAge);

        Intent intentForShowInfo = getIntent();
        String idUser = intentForShowInfo.getStringExtra(USER_FOR_SHOW_ID);
        user = userDBRealm.getUserById(idUser);
        idTV.setText(String.valueOf(user.getIdStr()));
        nameTV.setText(user.getName());
        surnameTV.setText(user.getSurname());
        ageTV.setText(String.valueOf(user.getAge()));

    }

    public void closeActivity(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDBRealm.close();
    }
}
