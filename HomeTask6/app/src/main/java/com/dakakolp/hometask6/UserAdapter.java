package com.dakakolp.hometask6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;
    private OnUserClickListener listener;
    private Context context;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    public UserAdapter(List<User> users, OnUserClickListener listener) {
        this(users);
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.outline_for_recyclerview, null);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        if(user != null) {
            holder.nameTxt.setText(user.getName());
            holder.surnameTxt.setText(user.getSurname());
            holder.ageTxt.setText(String.valueOf(user.getAge()));
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView nameTxt;
        TextView surnameTxt;
        TextView ageTxt;
        Button buttonMenu;

        public UserViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_view);
            nameTxt = itemView.findViewById(R.id.first_name);
            surnameTxt = itemView.findViewById(R.id.last_name);
            ageTxt = itemView.findViewById(R.id.age);
            buttonMenu = itemView.findViewById(R.id.menu_button);


            buttonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDotsClick(v, getAdapterPosition());
                }
            });
        }
    }
}
