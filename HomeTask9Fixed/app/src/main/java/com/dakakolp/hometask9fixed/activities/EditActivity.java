package com.dakakolp.hometask9fixed.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.hometask9fixed.R;
import com.dakakolp.hometask9fixed.classes.User;
import com.dakakolp.hometask9fixed.fragments.EditFragment;
import com.dakakolp.hometask9fixed.interfaces.CallbackInterfaceEdit;

public class EditActivity extends AppCompatActivity implements CallbackInterfaceEdit {

    private EditFragment editFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editFragment = new EditFragment();
        editFragment.setCallbackListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.edit_container,editFragment)
                .commit();

    }

    @Override
    public void onSaveClick(User user) {

        Intent intentToMainActivity = new Intent(EditActivity.this, MainActivity.class);
        Bundle bundleToMainActivity = new Bundle();

        bundleToMainActivity.putSerializable(EditFragment.NEW_USER, user);
        intentToMainActivity.putExtras(bundleToMainActivity);

        setResult(RESULT_OK, intentToMainActivity);
        finish();
    }
}
