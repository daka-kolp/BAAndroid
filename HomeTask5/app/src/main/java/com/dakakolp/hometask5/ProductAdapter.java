package com.dakakolp.hometask5;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> list;
    private OnProductClickListener listener;

    public ProductAdapter(List<Product> list) {
        this.list = list;
    }

    public ProductAdapter(List<Product> list, OnProductClickListener listener) {
        this(list);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.outline, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = list.get(position);
        holder.imageView.setImageResource(product.getPhoto());
        holder.textView.setText(product.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.c_view);
            imageView = itemView.findViewById(R.id.new_image);
            textView = itemView.findViewById(R.id.new_text);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickCardView(getAdapterPosition());
                }
            });
        }
    }
}
