package com.dakakolp.hometask13.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dakakolp.hometask13.R;
import com.dakakolp.hometask13.classes.User;
import com.dakakolp.hometask13.fragments.EditFragment;
import com.dakakolp.hometask13.interfaces.CallbackInterfaceEdit;

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
    public void onSaveClick() {
        Intent intentToMainActivity = new Intent(EditActivity.this, MainActivity.class);
        setResult(RESULT_OK, intentToMainActivity);
        finish();
    }
}
