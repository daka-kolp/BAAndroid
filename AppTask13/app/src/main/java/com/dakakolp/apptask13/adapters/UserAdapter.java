package com.dakakolp.apptask13.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakakolp.apptask13.R;
import com.dakakolp.apptask13.classes.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

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

    public interface OnUserClickListener {
        void onDotsClick(View view, int position);

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.list_user, null);

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

    public void setUsers(List<User> users) {
        this.users = users;
    }
}