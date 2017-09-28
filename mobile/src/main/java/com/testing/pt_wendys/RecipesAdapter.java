package com.testing.pt_wendys;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Maximilian Meyer
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyViewHolder> {
    private Context mContext;
    private List<Recipe> recipeList;
    private int position;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public Recipe recipe;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.recipe_thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

          view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, RecipeDetail.class);
            intent.putExtra("recipeData",recipe);
            /*intent.putExtra("recipeIngredients", recipe.getIngredients());
            intent.putExtra("recipeName", recipe.getName());
            intent.putExtra("recipeCals", recipe.getNumOfCalories());
            intent.putExtra("recipeDesc", recipe.getDescription());*/
            // Pass data object in the bundle and populate details activity.
            //intent.putExtra(RecipeDetail.ExtraData, contact);
            //intent.putExtra("test", "we are totally famous");
            //ActivityOptions options = ActivityOptions.
                    //makeSceneTransitionAnimation(this, (View) RecipeDetail, "recipeDetailContainer");
            mContext.startActivity(intent);
        }
    }




    public RecipesAdapter(Context mContext, List<Recipe> recipeList) {
        this.mContext = mContext;
        this.recipeList = recipeList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Recipe recipe = recipeList.get(position);
        holder.recipe = recipe;
        holder.title.setText(recipe.getName());
        holder.count.setText(recipe.getNumOfCalories() + " Calories");

        // loading recipe cover using Glide library
        Glide.with(mContext).load(recipe.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow, recipe);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view, Recipe recipe) {
        // inflate menu

        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(recipe));
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        Recipe recipe;

        public MyMenuItemClickListener(Recipe recipe) {
          this.recipe = recipe;
        }


        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_to_cart:
                    Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();


                    Intent viewAddtoCart = new Intent(mContext, Shopping2.class);
                    viewAddtoCart.putExtra("r",recipe);

                    mContext.startActivity(viewAddtoCart);


                    return true;
                case R.id.action_view_detail:
                    Toast.makeText(mContext, "View ingredients", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
