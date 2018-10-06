package com.dakakolp.hometask13.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dakakolp.hometask13.R;
import com.dakakolp.hometask13.classes.User;
import com.dakakolp.hometask13.fragments.EditFragment;
import com.dakakolp.hometask13.fragments.UserListFragment;
import com.dakakolp.hometask13.fragments.dialogs.DeleteDialogFragment;
import com.dakakolp.hometask13.interfaces.CallbackInterface;
import com.dakakolp.hometask13.interfaces.OnButtonDialogClickListener;

public class MainActivity extends AppCompatActivity implements CallbackInterface, OnButtonDialogClickListener {

    private UserListFragment listFragment;
    public static final int CODE_FOR_EDIT_OR_CREATE = 108;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragment = new UserListFragment();
        listFragment.setCallbackListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, listFragment)
                .commit();
    }

    @Override
    public void onEditClick(User user) {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra(EditFragment.USER_ID, user.getIdStr());
        startActivityForResult(intent, CODE_FOR_EDIT_OR_CREATE);
    }

    @Override
    public void onShowUserClick(User user) {
        Intent intent = new Intent(MainActivity.this, ShowInfoActivity.class);
        intent.putExtra(ShowInfoActivity.USER_FOR_SHOW_ID, user.getIdStr());
        startActivity(intent);
    }

    public void onCreateClick() {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        startActivityForResult(intent, CODE_FOR_EDIT_OR_CREATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        listFragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                DeleteDialogFragment delete = new DeleteDialogFragment();
                delete.setListener(this);
                delete.show(this.getSupportFragmentManager(), null);
                return true;
            case R.id.create:
                onCreateClick();
                return true;
        }
        return false;
    }

    @Override
    public void onYesClick() {
        listFragment.deleteAllUsersFromList();
    }

    @Override
    public void onNoClick() {

    }
}
