package com.dakakolp.applicationtask5;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    List<Info> listInfo;
    private OnInfoClickListener onInfoClickListener;

    public InfoAdapter(List<Info> listInfo, OnInfoClickListener onInfoClickListener) {
        this.listInfo = listInfo;
        this.onInfoClickListener = onInfoClickListener;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.outline, null);
        return new InfoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {

        Info info = listInfo.get(position);
        holder.imageIV.setImageResource(info.getNewImage());
        holder.textTxt.setText(info.getNewText());
    }

    @Override
    public int getItemCount() {
        return listInfo.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView imageIV;
        TextView textTxt;
        Button imagePoints;


        public InfoViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_view);
            imageIV = itemView.findViewById(R.id.new_image);
            textTxt = itemView.findViewById(R.id.new_text);
            imagePoints = itemView.findViewById(R.id.points_image);
            imagePoints.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onInfoClickListener.onInfoClick(getAdapterPosition());
                }
            });
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onInfoClickListener.onNewInfoClick(getAdapterPosition());
                }
            });
        }
    }
}
