package com.dakakolp.hometask5;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientsActivity extends AppCompatActivity {

    public static final String RECIPE_ID = "recipeID";
    public static final String LIST_RECIPES = "listRecipes";

    ArrayList<Product> list;
    int positionId;

    TextView nameTV;
    TextView ingredientsTV;
    ImageView photoIV;
    View ingredientsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        Intent intent = getIntent();

        list = (ArrayList<Product>) intent.getSerializableExtra(LIST_RECIPES);
        positionId = intent.getIntExtra(RECIPE_ID, 0);

        nameTV = findViewById(R.id.name_recipe);
        nameTV.setText(list.get(positionId).getName());

        ingredientsTV = findViewById(R.id.text_ingredients);
        ingredientsTV.setText(list.get(positionId).getDescription());

        photoIV = findViewById(R.id.image_ingredients);
        photoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientsView = findViewById(R.id.linear_ingredients);
                Snackbar sb = Snackbar.make(ingredientsView, "Show image?", Snackbar.LENGTH_LONG);
                sb.show();
                sb.setAction("Display", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        photoIV.setImageResource(list.get(positionId).getPhoto());
                    }
                });
            }
        });
    }
}
