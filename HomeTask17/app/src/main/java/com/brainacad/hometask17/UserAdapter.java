package com.brainacad.hometask17;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> listUser;

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.user_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.name.setText(user.getNameStr());
        holder.username.setText(user.getUsernameStr());
        holder.email.setText(user.getEmailStr());
        holder.city.setText(user.getAddress().getAddressCityStr());
        holder.nameComp.setText(user.getCompany().getCompanyNameStr());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView username;
        private TextView email;
        private TextView city;
        private TextView nameComp;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            city = itemView.findViewById(R.id.city);
            nameComp = itemView.findViewById(R.id.nameComp);
        }
    }
}
