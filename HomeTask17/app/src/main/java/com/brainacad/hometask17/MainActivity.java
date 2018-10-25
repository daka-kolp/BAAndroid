package com.brainacad.hometask17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    private List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listUser = new ArrayList<>();
        recyclerView = findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserAdapter();
        new ApiManager().getUsers(new ApiManager.OnServerResponse() {
            @Override
            public void onServerUsersResponse(List<User> users) {

                listUser.addAll(users);
                userAdapter.setListUser(listUser);
                recyclerView.setAdapter(userAdapter);
            }
        });
    }
}
