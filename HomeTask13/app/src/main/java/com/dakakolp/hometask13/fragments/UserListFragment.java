package com.dakakolp.hometask13.fragments;

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

import com.dakakolp.hometask13.R;
import com.dakakolp.hometask13.activities.MainActivity;
import com.dakakolp.hometask13.adapters.UserAdapter;
import com.dakakolp.hometask13.classes.User;
import com.dakakolp.hometask13.dbrealm.UserDBRealm;
import com.dakakolp.hometask13.fragments.dialogs.DeleteDialogFragment;
import com.dakakolp.hometask13.interfaces.CallbackInterface;
import com.dakakolp.hometask13.interfaces.OnButtonDialogClickListener;

import java.util.List;

public class UserListFragment extends Fragment implements OnButtonDialogClickListener {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;
    private int currentPosition;

    private UserDBRealm userDBRealm;

    private CallbackInterface callbackListener;
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

        userDBRealm = new UserDBRealm();
        userList = userDBRealm.getUsers();

        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
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
        switch (requestCode) {
            case MainActivity.CODE_FOR_EDIT_OR_CREATE:
                if (resultCode == getActivity().RESULT_OK) {
                    userAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void onYesClick() {
        userDBRealm.deleteUserById(userList.get(currentPosition).getIdStr());
        userAdapter.notifyItemRemoved(currentPosition);
    }

    @Override
    public void onNoClick() {}

    public void deleteAllUsersFromList() {
        userDBRealm.deleteAllUsers();
        userAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        userDBRealm.close();
    }

}
