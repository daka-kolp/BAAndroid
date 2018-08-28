package com.dakakolp.hometask5;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class

IngredientsActivity extends AppCompatActivity {

    public static final String RECIPE_ID = "recipeID";
    public static final String LIST_RECIPES = "listRecipes";

//    private ArrayList<Product> list;
//    private int positionId;

    private Product product;

    private TextView nameTV;
    private TextView ingredientsTV;
    private ImageView photoIV;
    private FloatingActionButton fab;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            getInfo(bundle);
        }


        Product p = (Product)bundle.getSerializable("Product");

        final Intent i = new Intent(this, NewActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("Product", p);
        i.putExtras(b);

        show = findViewById(R.id.show_recipe);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });


//        list = (ArrayList<Product>) intent.getSerializableExtra(LIST_RECIPES);
//        positionId = intent.getIntExtra(RECIPE_ID, 0);
//
//        nameTV = findViewById(R.id.name_recipe);
//        nameTV.setText(list.get(positionId).getName());
//
//        ingredientsTV = findViewById(R.id.text_ingredients);
//        ingredientsTV.setText(list.get(positionId).getDescription());
//
//        photoIV = findViewById(R.id.image_ingredients);
//        photoIV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fab = findViewById(R.id.fab);
//                Snackbar sb = Snackbar.make(fab, "Show image?", Snackbar.LENGTH_LONG);
//                sb.show();
//                sb.setAction("Display", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        photoIV.setImageResource(list.get(positionId).getPhoto());
//                    }
//                });
//            }
//        });
    }

    public void getInfo(Bundle bundle) {


        String name = bundle.getString("Name", "No name");
        String description = bundle.getString("Description", "No description");
        final int photo = bundle.getInt("Photo");

        product = new Product(photo, name, description);

        nameTV = findViewById(R.id.name_recipe);
        nameTV.setText(product.getName());

        ingredientsTV = findViewById(R.id.text_ingredients);
        ingredientsTV.setText(description);

        photoIV = findViewById(R.id.image_ingredients);
        photoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab = findViewById(R.id.fab);
                Snackbar sb = Snackbar.make(fab, "Show image?", Snackbar.LENGTH_LONG);
                sb.show();
                sb.setAction("Display", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        photoIV.setImageResource(photo);
                    }
                });
            }
        });
    }
}
