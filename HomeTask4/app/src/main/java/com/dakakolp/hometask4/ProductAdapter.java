package com.dakakolp.hometask4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Formatter;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private List<Product> productsList;

    public ProductAdapter(List<Product> productsList) {
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_products, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productsList.get(position);
        holder.productImage.setImageResource(product.getImage());
        holder.productNameTxt.setText(product.getName());
        holder.productPriceTxt.setText(String.format("%.2f", product.getPrice()));
        holder.productDescriptionTxt.setText(product.getDescription());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productNameTxt;
        private TextView productPriceTxt;
        private TextView productDescriptionTxt;


        public ProductViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productNameTxt = itemView.findViewById(R.id.product_name);
            productPriceTxt = itemView.findViewById(R.id.product_price);
            productDescriptionTxt = itemView.findViewById(R.id.product_description);
        }
    }
}
