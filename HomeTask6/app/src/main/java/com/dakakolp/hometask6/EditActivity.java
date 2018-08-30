package com.dakakolp.hometask6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    public final static String USER = "User";
    public final static String NEW_USER = "NewUser";
    public final static String ID_POSITION = "Position";
    public final static String NEW_POSITION = "New Position";

    private EditText nameEdit;
    private EditText surnameEdit;
    private EditText ageEdit;
    private EditText genderEdit;
    private Button save;

    private User user;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        nameEdit = findViewById(R.id.editName);
        surnameEdit = findViewById(R.id.editSurname);
        ageEdit = findViewById(R.id.editAge);
        save = findViewById(R.id.button_save);

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();

        if (bundle != null) {
            user = (User) bundle.getSerializable(USER);
            position = bundle.getInt(EditActivity.ID_POSITION);

            nameEdit.setText(user.getName());
            surnameEdit.setText(user.getSurname());
            ageEdit.setText(String.valueOf(user.getAge()));

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user.setName(String.valueOf(nameEdit.getText()));
                    user.setSurname(surnameEdit.getText().toString());
                    user.setAge(Integer.parseInt(ageEdit.getText().toString()));

                    Intent intentToMainActivity = new Intent(EditActivity.this, MainActivity.class);
                    Bundle bundleToMainActivity = new Bundle();

                    bundleToMainActivity.putSerializable(NEW_USER, user);
                    bundleToMainActivity.putInt(EditActivity.NEW_POSITION, position);
                    intentToMainActivity.putExtras(bundleToMainActivity);

                    startActivity(intentToMainActivity);
                    finish();
                }
            });
        }
    }
}
