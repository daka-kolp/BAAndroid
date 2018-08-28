package com.dakakolp.hometask5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnProductClickListener {

    private List<Product> listProducts;
    private RecyclerView rv;
    private ProductAdapter pa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rec_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        listProducts = Product.createProducts();

        pa = new ProductAdapter(listProducts, this);
        rv.setAdapter(pa);
    }

    @Override
    public void onClickCardView(int position) {

        Product product = listProducts.get(position);

        Intent intent = new Intent(this, IngredientsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("Name", product.getName());
        bundle.putString("Description", product.getDescription());
        bundle.putInt("Photo", product.getPhoto());

        bundle.putSerializable("Product", product);

        intent.putExtras(bundle);
//        intent.putExtra(IngredientsActivity.RECIPE_ID, position);
//        intent.putExtra(IngredientsActivity.LIST_RECIPES, (Serializable) listProducts);
        startActivity(intent);

    }
}
