package com.dakakolp.hometask4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products = new ArrayList<Product>();

        products.add(new Product(R.drawable.if_apple1, "Green Watch", 200.50, "Apple's green modern watch, create your own style..."));
        products.add(new Product(R.drawable.if_apple2, "White Watch", 150.50, "Apple's modern watch, create your new style..."));
        products.add(new Product(R.drawable.if_apple3, "Apple's Laptop", 1000.75, "Apple's laptop, change your life..."));


        productAdapter = new ProductAdapter(products);
        recyclerView.setAdapter(productAdapter);
    }
}
