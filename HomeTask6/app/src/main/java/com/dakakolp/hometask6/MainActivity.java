package com.dakakolp.hometask6;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList = User.createUsers();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        userAdapter = new UserAdapter(userList, new FinishListener() {
            @Override
            public void finishActivity() {
                MainActivity.this.finish();
            }
        });
        recyclerView.setAdapter(userAdapter);

        Intent intentFromEdit = getIntent();
        Bundle bundleFromEdit = intentFromEdit.getExtras();
        if (bundleFromEdit != null) {
            User u = (User) bundleFromEdit.getSerializable(EditActivity.NEW_USER);
            int position = bundleFromEdit.getInt(EditActivity.NEW_POSITION);
            userList.set(position, u);
            userAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                userList.removeAll(userList);
                userAdapter.setUsers(userList);
                userAdapter.notifyDataSetChanged();
                break;
            case R.id.create:
                userList = User.createUsers();
                userAdapter.setUsers(userList);
                userAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

}
