package com.dakakolp.apptask13.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.apptask13.R;
import com.dakakolp.apptask13.classes.User;
import com.dakakolp.apptask13.fragments.EditFragment;
import com.dakakolp.apptask13.interfaces.CallbackInterfaceEdit;

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
