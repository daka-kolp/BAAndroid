package com.dakakolp.hometask9fixed.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dakakolp.hometask9fixed.R;
import com.dakakolp.hometask9fixed.User;
import com.dakakolp.hometask9fixed.interfaces.CallbackInterfaceEdit;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {


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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        nameEdit = view.findViewById(R.id.editName);
        surnameEdit = view.findViewById(R.id.editSurname);
        ageEdit = view.findViewById(R.id.editAge);
        save = view.findViewById(R.id.button_save);
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
                newUser.setName(String.valueOf(nameEdit.getText()));
                newUser.setSurname(surnameEdit.getText().toString());
                newUser.setAge(Integer.parseInt(ageEdit.getText().toString()));
                callbackEditListener.onSaveClick(newUser);
            }
        });
    }


    public void setCallbackListener(CallbackInterfaceEdit callbackListener) {
        this.callbackEditListener = callbackListener;
    }
}
