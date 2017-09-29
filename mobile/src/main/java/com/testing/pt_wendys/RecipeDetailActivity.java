package com.testing.pt_wendys;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * Created by Maximilian Meyer
 */

public class RecipeDetailActivity extends AppCompatActivity {

    private Recipe recipe;
    //Bundle bundle=this.getIntent().getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Intent Data
        Bundle data = getIntent().getExtras();
        recipe = data.getParcelable("recipeData");

        Log.d("my name: ",recipe.getName());

        ListView ingredientsList;

        //setting image data
        ImageView detailImage = findViewById(R.id.image_detail);
        Drawable d = getResources().getDrawable(recipe.getThumbnail(), null);
        detailImage.setImageDrawable(d);


        //setting name
        TextView detailName = findViewById(R.id.name_detail);
        detailName.setText(recipe.getName());

        //setting description
        TextView detailDescription = findViewById(R.id.description_detail);
        detailDescription.setText(recipe.getDescription());

        // ingredients list
        // This is the Adapter being used to display the list's data
        SimpleCursorAdapter mAdapter;
        ingredientsList = findViewById(R.id.ingredients_detail);
        //ingredientsList.set


        final ArrayList<Ingredient> ingredientList = recipe.getIngredients()   ;
        final IngredientAdapter adapter = new IngredientAdapter(this, ingredientList);
        ingredientsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ingredientsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ingredientList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added ingredients to cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent viewAddtoCart = new Intent(RecipeDetailActivity.this, ShoppingListActivity.class);
                recipe.getIngredients();
                viewAddtoCart.putExtra("r",recipe);

                startActivity(viewAddtoCart);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
