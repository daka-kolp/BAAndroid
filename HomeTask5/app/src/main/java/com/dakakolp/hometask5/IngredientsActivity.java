package com.dakakolp.hometask5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientsActivity extends AppCompatActivity {

    public static final String RECIPE_ID = "recipeID";
    public static final String LIST_RECIPES = "listRecipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        Intent intent = getIntent();

        int positionId = intent.getIntExtra(RECIPE_ID, 0);
        ArrayList<Product> list = (ArrayList<Product>) intent.getSerializableExtra(LIST_RECIPES);

        TextView tw = findViewById(R.id.text_ingredients);
        tw.setText(list.get(positionId).getDescription());

        ImageView iv = findViewById(R.id.image_ingredients);
        iv.setImageResource(list.get(positionId).getPhoto());
    }
}
