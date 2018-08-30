package com.dakakolp.hometask6;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList = User.createUsers();
    private int currentPosition;

    public static final int CODE_FOR_EDIT = 108;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        OnUserClickListener onUserClickListener = new OnUserClickListener() {
            @Override
            public void onDotsClick(View view, final int position) {

                currentPosition = position;
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.delete:
                                userList.remove(position);
                                userAdapter.notifyItemRemoved(position);
                                return true;
                            case R.id.edit_it:

                                Intent intent = new Intent(MainActivity.this, EditActivity.class);

                                Bundle bundle = new Bundle();
                                bundle.putSerializable(EditActivity.USER, userList.get(position));

                                intent.putExtras(bundle);
                                startActivityForResult(intent, CODE_FOR_EDIT);

                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        };

        userAdapter = new UserAdapter(userList, onUserClickListener);

        recyclerView.setAdapter(userAdapter);

//        Intent intentFromEdit = getIntent();
//        Bundle bundleFromEdit = intentFromEdit.getExtras();
//        if (bundleFromEdit != null) {
//            User u = (User) bundleFromEdit.getSerializable(EditActivity.NEW_USER);
//            int position = bundleFromEdit.getInt(EditActivity.NEW_POSITION);
//            userList.set(position, u);
//            userAdapter.notifyDataSetChanged();
//        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case CODE_FOR_EDIT:
                if(resultCode == RESULT_OK) {
                    Bundle bundleFromEdit = data.getExtras();
                    if (bundleFromEdit != null) {
                        User u = (User) bundleFromEdit.getSerializable(EditActivity.NEW_USER);
                        if(userList.contains(u)){
                            userList.set(currentPosition, u);
                        }

                        userAdapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }

}
