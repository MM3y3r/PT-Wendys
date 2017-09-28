package com.testing.pt_wendys;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

// transitions

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Maximilian Meyer
 */

//Bottom Nav Bar

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecipesAdapter adapter;
    private List<Recipe> recipeList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_planner:
                    //mTextMessage.setText(R.string.title_home);
                    Intent viewTest = new Intent(MainActivity.this, MarketFinderActivity.class);
                    //REZEPTUEBERGABE
                    //viewTest.putExtra("r",r);
                    startActivity(viewTest);
                    return true;
                case R.id.navigation_recipes:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_shopping_list:
                    //mTextMessage.setText(R.string.title_notifications);
                    Intent viewShoppingList = new Intent(MainActivity.this, ShoppingListActivity.class);
                    startActivity(viewShoppingList);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bottom Nav Bar
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_recipes);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recipeList = new ArrayList<>();
        adapter = new RecipesAdapter(this, recipeList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareRecipes();

        try {
            Glide.with(this).load(R.drawable.foodcover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */

    private void prepareRecipes() {
        int[] recipeImages = new int[]{

                R.drawable.foodpic0,
                R.drawable.foodpic1,
                R.drawable.foodpic2,
                R.drawable.foodpic3,
                R.drawable.foodpic4,
                R.drawable.foodpic5,
                R.drawable.foodpic6,
                R.drawable.foodpic7,
                R.drawable.foodpic8,
                R.drawable.foodpic9,
                /*R.drawable.food,
                R.drawable.album11*/};
        Ingredient[] minifritt = {new Ingredient (50, "g", "bacon"), new Ingredient(1," ", "onion"), new Ingredient(1,"", "green onion"), new Ingredient(1, "clove", "garlic"), new Ingredient(225, "g", "spinach"), new Ingredient(7, " ", "eggs"), new Ingredient(120, "g", "milk"), new Ingredient(50, "g", "parmesan cheese"), new Ingredient (1, " ", "olive oil for frying"), new Ingredient(1, " ", "butter for greasing"), new Ingredient(1, " ", "salt"), new Ingredient(1, " ", "pepper")};
        ArrayList<Ingredient> minifrittatas = new ArrayList<Ingredient>();
        minifrittatas.addAll(Arrays.asList(minifritt));

        Ingredient[] kamuts = {new Ingredient(70, "g", "kamut semolina"), new Ingredient(375, "ml", "plant-based milk"), new Ingredient(2, "tbsp", "poppy seeds"), new Ingredient(1, "tbsp", "maple syrup"), new Ingredient(200, "g", "fresh berries (e.g. raspberries, blueberries, gooseberries"), new Ingredient(1, " ", "maple syrup for serving")};
        ArrayList<Ingredient> kamutPorridge = new ArrayList<Ingredient>();
        kamutPorridge.addAll(Arrays.asList(minifritt));

        Ingredient[] loadedO = {new Ingredient(5, " ", "eggs"), new Ingredient(100, "ml", "milk"), new Ingredient(100, "g", "cherry tomatoes"), new Ingredient(1, "bell", "pepper (red"), new Ingredient(1, "", "avocado"), new Ingredient(2, "", "spring onions"),new Ingredient(100, "", "gchorizo"), new Ingredient(100, "g", "mozzarella cheese"), new Ingredient(10, "g", "parsley"), new Ingredient(1, "tsp", "oregano (dried)"), new Ingredient(1, "", "nutmeg"),new Ingredient(1, "", "butter for frying"), new Ingredient(1, "", "salt"), new Ingredient(1, "", "pepper")};
        ArrayList<Ingredient> loadedOmelette = new ArrayList<Ingredient>();
        kamutPorridge.addAll(Arrays.asList(loadedO));

        Ingredient[] leekAndCheese = {new Ingredient(500, "g", "ground beef"), new Ingredient(2, "", "leeks"), new Ingredient(1, "", "onion (white)"), new Ingredient(750, "ml", "vegetable stock"), new Ingredient(400, "g", "melting cheese"), new Ingredient(1, "tbsp", "vegetable oil"), new Ingredient(200, "g", "crème fraiche"), new Ingredient(1, "", "salt"), new Ingredient(1, "", "pepper"), new Ingredient(1, "", "lemon zest fpr serving"), new Ingredient(1, "", "nutmeg for serving"), new Ingredient(1, "", "bread for serving")};
        ArrayList<Ingredient> leekAndCheeseSoup = new ArrayList<Ingredient>();
        kamutPorridge.addAll(Arrays.asList(leekAndCheese));

        Ingredient[] leekAndAppleQ = {new Ingredient(250, "g", "spelt flour"), new Ingredient(150, "g", "butter (cold)"), new Ingredient(2, "egg", "volks"), new Ingredient(2, "tbsp", "water"), new Ingredient(1, "", "leek"), new Ingredient(1, "", "apples"), new Ingredient(50, "g", "hazelnuts"), new Ingredient(2, "", "eggs"), new Ingredient(400, "ml", "sour cream"), new Ingredient(1, "tbsp", "vegetable oil"), new Ingredient(200, "g", "bacon"), new Ingredient(1, "", "butter for greasing"), new Ingredient(1, "", "salt"), new Ingredient(1, "", "pepper"), };
        ArrayList<Ingredient> leekAndAppleQuiche = new ArrayList<Ingredient>();
        kamutPorridge.addAll(Arrays.asList(leekAndCheese));

        // Rezept: Name, Kalorien, Bild, Array Ingredients, Beschreibung

        Recipe a = new Recipe("Kamut semolina porridge", 230, recipeImages[0], kamutPorridge, "Add plant-based milk to a saucepan over medium-low heat and bring to a boil. Add kamut semolina, poppy seeds, and maple syrup and stir to combine. Remove from heat.\n" +
                "While still hot, transfer porridge to serving bowls and let sit for approx. 5 – 10 min. Garnish with berries and top with more maple syrup, if desired. Enjoy!\n");
        recipeList.add(a);

        a = new Recipe("Couscous summer salad", 668, recipeImages[1],minifrittatas, "hmm");
        recipeList.add(a);

        a = new Recipe("Muffin tin egg cups", 60, recipeImages[2], minifrittatas, "hmm");
        recipeList.add(a);

        a = new Recipe("Gnocchi with peas and Parmesan", 618, recipeImages[3], minifrittatas, "hmm");
        recipeList.add(a);

        a = new Recipe("Loaded omelette", 733, recipeImages[4], minifrittatas, "Halve the tomatoes and cut the bell pepper and avocado into cubes. Cut the chorizo, spring onions, and mozzarella into large pieces, and chop the parsley.\n" +
                "Beat the eggs and whisk in the milk. Add oregano, half of the parsley, nutmeg, and salt and pepper to taste.\n" +
                "Melt the butter in a nonstick pan over medium-high heat. Fry the chorizo for approx. 2 min., or until the fat begins to render. Add bell pepper and fry for approx. 2 min. longer before reducing the heat to medium-low. Add the tomatoes, then add the egg mixture. Cook the omelette for approx. 4 min. with the lid on.\n" +
                "As soon as the omelette is half-cooked, spread the avocado, mozzarella, and spring onions over it. Place the lid back on and allow the omelet to cook for approx. 2 min. more. Serve and garnish with parsley. Enjoy!\n");
        recipeList.add(a);

        a = new Recipe("Tuna salad sandwich", 634, recipeImages[5], minifrittatas, "hmm");
        recipeList.add(a);

        a = new Recipe("Mini frittatas with spinach and bacon", 98, recipeImages[6], loadedOmelette, "\"Preheat oven to 180°C/350°F. Finely dice bacon. Peel and dice onion. Thinly slice green onion. Peel and chop garlic. Roughly chop spinach. Beat eggs with milk in a measuring cup or mixing bowl and season generously with salt and pepper. Set aside.\\n\" +\n" +
                "                \"Heat olive oil in a large frying pan set over medium heat. Add diced bacon, onion, and garlic and sauté for approx. 2 – 3 min. Add green onion and spinach, season well with salt and pepper, and fry over medium heat for approx. 4 - 5 min.\\n\" +\n" +
                "                \"Add spinach mixture and grated Parmesan cheese to egg mixture and stir to combine. Grease muffin cups with butter and spoon mixture into muffin cups.\\n\" +\n" +
                "                \"Transfer to oven and bake at 180°C/350°F for approx. 20 min., or until golden brown. Serve warm. Enjoy!\"");
        recipeList.add(a);

        a = new Recipe("Tomato and goat cheese tartlets", 345, recipeImages[7], minifrittatas, "hmm");
        recipeList.add(a);

        a = new Recipe("Leek and apple quiche with bacon", 704, recipeImages[8], leekAndAppleQuiche, "Cube chilled butter. Pulse the flour, cold butter, egg yolk, and a pinch of salt together with a little cold water until a smooth dough forms. If dough seems too dry, add more cold water a little at a time until dough comes together. Cover for approx. 30 min. with plastic wrap and refrigerate.\n" +
                "Preheat oven to 200°C/400°F. Wash leeks and cut into rings. Core and dice apples. Finely chop hazelnuts and set aside. Mix together the eggs and sour cream and season with salt and pepper.\n" +
                "Heat oil in a large frying pan set over medium-high heat. Fry the bacon, leeks, and apples together until bacon until browned and fragrant.\n" +
                "Roll out chilled quiche dough between 2 layers of plastic wrap into a circle approx. 28 cm/11 in. in diameter.\n" +
                "Grease the tart pan and transfer dough to the pan. Gently press dough evenly into corners and up sides. Add the apple, leeks, and bacon to pan. Sprinkle half of the hazelnuts on top, then top with egg mixture.\n" +
                "Sprinkle with the remaining hazelnuts and bake for approx. 35 min. at 200°C/400°F. Allow to cool and enjoy!\n");
        recipeList.add(a);

        a = new Recipe("German-style leek and cheese soup", 954, recipeImages[9], leekAndCheeseSoup, "Dice onion. Wash the leeks, then slice into rings.\n" +
                "Heat oil in a large saucepan set over medium-high heat, then add the ground beef and fry until browned. Add the onion and leeks after approx. 2 min. Cook for approx. 5 min. more. Deglaze with vegetable stock, then let simmer for approx. 10 min.\n" +
                "Stir in the cheese and let melt. Stir in crème fraîche and boil again briefly.\n" +
                "Season the soup with salt, pepper, nutmeg, and some lemon zest to taste. Serve with a slice of fresh bread and enjoy!\n");

        recipeList.add(a);

        adapter.notifyDataSetChanged();
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
