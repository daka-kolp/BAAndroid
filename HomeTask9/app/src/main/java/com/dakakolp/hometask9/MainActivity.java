package com.dakakolp.hometask9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_for_user_fragment, new UserFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onDotsClick(View v, final int position, final List<User> userList, final UserAdapter userAdapter) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
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

                        UserEditFragment userEditFragment = UserEditFragment.newInstance(userList.get(position));

                        MainActivity.this.getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.frame_for_user_fragment, userEditFragment)
                                .commit();

                        return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
