package com.dakakolp.hometask9;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserEditFragment extends Fragment {

    public final static String USER = "User";
    public final static String NEW_USER = "NewUser";

    private static EditText nameEdit;
    private static EditText surnameEdit;
    private static EditText ageEdit;
    private static Button save;

    private List<User> userList = User.createUsers();
    private User user;

    public UserEditFragment() {

    }

    public static UserEditFragment newInstance(User user){
        UserEditFragment userEditFragment = new UserEditFragment();
        user.setName(String.valueOf(nameEdit.getText()));
        user.setSurname(surnameEdit.getText().toString());
        user.setAge(Integer.parseInt(ageEdit.getText().toString()));

        Bundle bundleToFragment = new Bundle();
        bundleToFragment.putSerializable(NEW_USER, user);

        userEditFragment.setArguments(bundleToFragment);

        return userEditFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_edit, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        user = (User) getArguments().getSerializable(USER);

        View view = getView();
        if (view != null) {
            nameEdit = view.findViewById(R.id.editName);
            surnameEdit = view.findViewById(R.id.editSurname);
            ageEdit = view.findViewById(R.id.editAge);

            nameEdit.setText(user.getName());
            surnameEdit.setText(user.getSurname());
            ageEdit.setText(String.valueOf(user.getAge()));

            save = view.findViewById(R.id.button_save);
        }
    }

    interface onSaveClickListener {
        void onSaveClick();
    }
}
