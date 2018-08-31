package com.dakakolp.apptask7;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter <ColorAdapter.ColorViewHolder>{

    OnColorClickListener listener;
    List<ColorRes> listColor;

    public ColorAdapter(OnColorClickListener listener, List<ColorRes> listColor) {
        this.listener = listener;
        this.listColor = listColor;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.outline_for_coloractivity, null);
        return  new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {

        ColorRes colorRes = listColor.get(position);
        holder.nameColorTxt.setText(colorRes.getResourceName());
        holder.colorImage.setImageResource(colorRes.getResourceColor());

    }

    @Override
    public int getItemCount() {
        return listColor.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {

        CardView colorCardView;
        ImageView colorImage;
        TextView nameColorTxt;

        public ColorViewHolder(View itemView) {
            super(itemView);
            colorCardView = itemView.findViewById(R.id.cardview_for_coloradapter);
            colorImage = itemView.findViewById(R.id.color_image);
            nameColorTxt = itemView.findViewById(R.id.color_name);

            colorCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorClick(getAdapterPosition());
                }
            });

        }
    }
}
