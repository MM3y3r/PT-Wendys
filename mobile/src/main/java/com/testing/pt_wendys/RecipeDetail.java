package com.testing.pt_wendys;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * Created by Maximilian Meyer
 */

public class RecipeDetail extends AppCompatActivity {

    //Bundle bundle=this.getIntent().getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Intent Data
        Bundle data = getIntent().getExtras();
        Recipe recipe = data.getParcelable("recipeData");

        Log.d("my name: ",recipe.getName());

        //setting image data
        ImageView detailImage = findViewById(R.id.image_detail);
        //detailImage.setImageResource(recipe.getThumbnail());
        //Glide.with(this).load(recipe.getThumbnail()).into(detailImage);
        Drawable d = getResources().getDrawable(recipe.getThumbnail(), null);
        detailImage.setImageDrawable(d);

        //setting name
        TextView detailName = findViewById(R.id.name_detail);
        detailName.setText(recipe.getName());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
