package com.dakakolp.hometask9fixed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.hometask9fixed.classes.User;
import com.dakakolp.hometask9fixed.fragments.EditFragment;
import com.dakakolp.hometask9fixed.fragments.UserListFragment;
import com.dakakolp.hometask9fixed.interfaces.CallbackInterface;

public class MainActivity extends AppCompatActivity implements CallbackInterface {

    private UserListFragment listFragment;


    public static final int CODE_FOR_EDIT = 108;

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

        Bundle bundle = new Bundle();
        bundle.putSerializable(EditFragment.USER, user);

        intent.putExtras(bundle);
        startActivityForResult(intent, CODE_FOR_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        listFragment.onActivityResult(requestCode, resultCode, data);
    }
}
