package com.dakakolp.applicationtask4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.firstNameTxt.setText(user.getFirstName());
        holder.lastNameTxt.setText(user.getLastName());
        holder.userAvatar.setImageResource(user.getAvatarId());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView userAvatar;
        TextView firstNameTxt;
        TextView lastNameTxt;

        public UserViewHolder(View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.face);
            firstNameTxt = itemView.findViewById(R.id.first_name);
            lastNameTxt = itemView.findViewById(R.id.last_name);
        }
    }
}
