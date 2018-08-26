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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        Intent intent = getIntent();

        int positionId = intent.getIntExtra(RECIPE_ID, 0);
        ArrayList<Product> list = (ArrayList<Product>) intent.getSerializableExtra(LIST_RECIPES);

        final TextView nameTV = findViewById(R.id.name_recipe);
        nameTV.setText(list.get(positionId).getName());

        TextView tv = findViewById(R.id.text_ingredients);
        tv.setText(list.get(positionId).getDescription());

        ImageView iv = findViewById(R.id.image_ingredients);
        iv.setImageResource(list.get(positionId).getPhoto());

        View view = findViewById(R.id.linear_ingredients);
        Snackbar sb = Snackbar.make(view, "New message", Snackbar.LENGTH_LONG);
        sb.show();

        sb.setAction("Change recipe's name", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTV.setText("New recipe");
            }
        });
    }
}
