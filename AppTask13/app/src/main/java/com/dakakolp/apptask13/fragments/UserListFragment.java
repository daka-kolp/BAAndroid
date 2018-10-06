package com.dakakolp.apptask13.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dakakolp.apptask13.database.DBOpenHelper;
import com.dakakolp.apptask13.activities.MainActivity;
import com.dakakolp.apptask13.R;
import com.dakakolp.apptask13.classes.User;
import com.dakakolp.apptask13.adapters.UserAdapter;
import com.dakakolp.apptask13.fragments.dialogs.DeleteDialogFragment;
import com.dakakolp.apptask13.interfaces.CallbackInterface;
import com.dakakolp.apptask13.interfaces.OnButtonDialogClickListener;

import java.util.List;

import io.realm.Realm;

public class UserListFragment extends Fragment implements OnButtonDialogClickListener {


    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;
    private CallbackInterface callbackListener;
    private int currentPosition;
    private UserAdapter.OnUserClickListener onUserClickListener = new UserAdapter.OnUserClickListener() {
        @Override
        public void onDotsClick(View view, final int position) {
            currentPosition = position;
            PopupMenu popupMenu = new PopupMenu(getActivity(), view);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.delete:
                            DeleteDialogFragment delete = new DeleteDialogFragment();
                            delete.setListener(UserListFragment.this);
                            delete.show(getActivity().getSupportFragmentManager(), null);

                            return true;
                        case R.id.edit_it:
                            if (callbackListener != null) {
                                callbackListener.onEditClick(userList.get(position));
                            }
                            return true;
                        case R.id.openUser:
                            if (callbackListener != null) {
                                callbackListener.onShowUserClick(userList.get(position));
                            }
                            return true;

                    }
                    return false;
                }
            });
            popupMenu.show();
        }
    };


    public UserListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        realmDB = Realm.getDefaultInstance();

        insertUser(new User("Mila", "K", 23));
        insertUser(new User("Dmitriy", "W", 27));
        insertUser(new User("Nina", "Q", 16));

        userList = getUsers();

        Context context = view.getContext();
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);
        userAdapter = new UserAdapter(userList, onUserClickListener);
        recyclerView.setAdapter(userAdapter);

        return view;
    }


    public void setCallbackListener(CallbackInterface callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DBOpenHelper db = new DBOpenHelper(getContext());
        switch (requestCode) {
            case MainActivity.CODE_FOR_EDIT:
                if (resultCode == getActivity().RESULT_OK) {
                    Bundle bundleFromEdit = data.getExtras();
                    if (bundleFromEdit != null) {
                        User u = (User) bundleFromEdit.getSerializable(EditFragment.NEW_USER);
                        if (userList.contains(u)) {
                            userList.set(currentPosition, u);
                        }
                        userAdapter.notifyDataSetChanged();
                    }
                }
                break;
            case MainActivity.CODE_FOR_CREATE:
                if (resultCode == getActivity().RESULT_OK) {
                    Bundle bundleFromEdit = data.getExtras();
                    if (bundleFromEdit != null) {
                        User u = (User) bundleFromEdit.getSerializable(EditFragment.NEW_USER);
                        if (userList.contains(u)) {
                            userList.add(u);
                        }
                        userAdapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }

    @Override
    public void onYesClick() {
        DBOpenHelper db = new DBOpenHelper(getContext());
        db.deleteUser(userList.get(currentPosition).getIdDB());
        userList.remove(currentPosition);
        userAdapter.notifyItemRemoved(currentPosition);
    }

    @Override
    public void onNoClick() {

    }

    public void deleteAllUsersFromList() {
        DBOpenHelper db = new DBOpenHelper(getContext());
        db.deleteAll();
        userAdapter.setUsers(db.getUsers());
        userAdapter.notifyDataSetChanged();
    }



    /*
    Realm
    */

    private Realm realmDB;

    private void insertUser(User user) { //insert to Db
        realmDB.beginTransaction();
        realmDB.insert(user);
        realmDB.commitTransaction();

//        realmDB.executeTransaction(new Realm.Transaction() { //v.2 insert to Db
//            @Override
//            public void execute(Realm realm) {
//                realm.insert(user);
//            }
//        });
    }

    private void updateUser(final User user, final String name) {

//        realmDB.beginTransaction();
//        if (user != null)
//            user.setName(name);
//
//        realmDB.commitTransaction();

        realmDB.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (user != null)
                    user.setName(name);
            }
        });
    }


    private User getUserByName(String userName) {
        realmDB.beginTransaction();
        User user = realmDB
                .where(User.class)//в какой таблице ищем
                .equalTo("name", userName) //соответсвует полю в классе
                .findFirst();//найти первый попавшийся
        realmDB.commitTransaction();
        return user;
    }

    private List<User> getUsers() {

        realmDB.beginTransaction();
        List<User> userList = realmDB
                .where(User.class)
                .findAll();
        realmDB.commitTransaction();
        return userList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realmDB.close();
    }

}
