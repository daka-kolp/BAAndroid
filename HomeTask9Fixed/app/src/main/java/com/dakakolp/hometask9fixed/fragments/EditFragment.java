package com.dakakolp.hometask9fixed.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dakakolp.hometask9fixed.R;
import com.dakakolp.hometask9fixed.classes.User;
import com.dakakolp.hometask9fixed.fragments.dialogs.SaveDialogFragment;
import com.dakakolp.hometask9fixed.interfaces.CallbackInterfaceEdit;
import com.dakakolp.hometask9fixed.interfaces.OnButtonDialogClickListener;


public class EditFragment extends Fragment implements OnButtonDialogClickListener {


    public final static String USER = "User";
    public final static String NEW_USER = "NewUser";

    private EditText nameEdit;
    private EditText surnameEdit;
    private EditText ageEdit;
    private EditText genderEdit;
    private Button save;

    private User newUser;
    private CallbackInterfaceEdit callbackEditListener;

    public EditFragment() {

    }


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
        Intent intent = getActivity().getIntent();
        final Bundle bundle = intent.getExtras();
        if (bundle != null) {
            newUser = (User) bundle.getSerializable(USER);
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


    public void setCallbackListener(CallbackInterfaceEdit callbackListener) {
        this.callbackEditListener = callbackListener;
    }

    @Override
    public void onYesClick() {
        newUser.setName(String.valueOf(nameEdit.getText()));
        newUser.setSurname(surnameEdit.getText().toString());
        newUser.setAge(Integer.parseInt(ageEdit.getText().toString()));
        callbackEditListener.onSaveClick(newUser);
    }

    @Override
    public void onNoClick() {
        getActivity().finish();
    }
}
