package com.dakakolp.hometask13.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dakakolp.hometask13.R;
import com.dakakolp.hometask13.classes.User;
import com.dakakolp.hometask13.dbrealm.UserDBRealm;
import com.dakakolp.hometask13.fragments.dialogs.SaveDialogFragment;
import com.dakakolp.hometask13.interfaces.CallbackInterfaceEdit;
import com.dakakolp.hometask13.interfaces.OnButtonDialogClickListener;


public class EditFragment extends Fragment implements OnButtonDialogClickListener {


    public final static String USER_ID = "UserId";

    private EditText nameEdit;
    private EditText surnameEdit;
    private EditText ageEdit;
    private Button save;

    private UserDBRealm userDBRealm;
    private User newUser;

    private CallbackInterfaceEdit callbackEditListener;

    public void setCallbackListener(CallbackInterfaceEdit callbackListener) {
        this.callbackEditListener = callbackListener;
    }

    public EditFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        nameEdit = view.findViewById(R.id.editName);
        surnameEdit = view.findViewById(R.id.editSurname);
        ageEdit = view.findViewById(R.id.editAge);
        save = view.findViewById(R.id.button_save);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        userDBRealm = new UserDBRealm();

        Intent intent = getActivity().getIntent();
        String idUser = intent.getStringExtra(USER_ID);
        if (idUser != null) {
            newUser = userDBRealm.getUserById(idUser);
            nameEdit.setText(newUser.getName());
            surnameEdit.setText(newUser.getSurname());
            ageEdit.setText(String.valueOf(newUser.getAge()));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDialogFragment save = new SaveDialogFragment();
                save.setListener(EditFragment.this);
                save.show(getActivity().getSupportFragmentManager(), null);
            }
        });
    }

    @Override
    public void onYesClick() {

        if (newUser != null) {
            userDBRealm.updateUser(newUser,
                    String.valueOf(nameEdit.getText()),
                    surnameEdit.getText().toString(),
                    Integer.parseInt(ageEdit.getText().toString()));
            callbackEditListener.onSaveClick();
        } else {
            User user = new User(
                    String.valueOf(nameEdit.getText()),
                    surnameEdit.getText().toString(),
                    Integer.parseInt(ageEdit.getText().toString())
            );
            userDBRealm.insertUser(user);
            callbackEditListener.onSaveClick();
        }
    }

    @Override
    public void onNoClick() {
        getActivity().finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        userDBRealm.close();
    }
}
