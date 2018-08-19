package com.dakakolp.applicationtask4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserAdapter userAdapter;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<User> userList = new ArrayList<>();

        userList.add(new User(R.drawable.if_face1, "Dima", "Smith"));
        userList.add(new User(R.drawable.if_face2, "Mira", "Like"));
        userList.add(new User(R.drawable.if_face3, "Alex", "Mot"));
        userList.add(new User(R.drawable.if_face4, "Lara", "Top"));
        userList.add(new User(R.drawable.if_face4, "Mila", "Kolp"));
        userList.add(new User(R.drawable.if_face5, "Dana", "Soon"));

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);


    }
}
