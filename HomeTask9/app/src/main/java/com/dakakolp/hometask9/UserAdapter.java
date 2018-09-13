package com.dakakolp.hometask9;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import com.dakakolp.hometask9.UserFragment.OnListFragmentInteractionListener;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<User> users;
    private final OnListFragmentInteractionListener listener;

    public UserAdapter(List<User> items, OnListFragmentInteractionListener listener) {
        this.users = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_user, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User user = users.get(position);
        if (user != null) {
            holder.nameTxt.setText(user.getName());
            holder.surnameTxt.setText(user.getSurname());
            holder.ageTxt.setText(String.valueOf(user.getAge()));
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nameTxt;
        TextView surnameTxt;
        TextView ageTxt;
        Button buttonMenu;

        public ViewHolder(View view) {
            super(view);
            cv = itemView.findViewById(R.id.card_view);
            nameTxt = itemView.findViewById(R.id.first_name);
            surnameTxt = itemView.findViewById(R.id.last_name);
            ageTxt = itemView.findViewById(R.id.age);
            buttonMenu = itemView.findViewById(R.id.menu_button);
            buttonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener) {
                        listener.onDotsClick(v, getAdapterPosition(), users, UserAdapter.this);
                    }
                }
            });
        }
    }
}
