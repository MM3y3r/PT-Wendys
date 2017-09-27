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

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

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
                    Intent viewTest = new Intent(MainActivity.this, testetstsetsetest.class);
                    startActivity(viewTest);
                    return true;
                case R.id.navigation_recipes:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_shopping_list:
                    //mTextMessage.setText(R.string.title_notifications);
                    Intent viewShoppingList = new Intent(MainActivity.this, Shopping2.class);
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

        prepareAlbums();

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
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.recipe1,
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
        Ingredient i1 = new Ingredient (104, "kg", "Kekse");

        Ingredient[] igua = new Ingredient[]{i1};


        // Rezept: Name, Kalorien, Bild, Array Ingredients, Beschreibung

        Recipe a = new Recipe("Kamut semolina porridge", 130, covers[0], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Couscous summer salad", 800, covers[1], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Muffin tin egg cups", 1111, covers[2], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Gnocchi with peas and Parmesan", 120, covers[3], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Loaded omelette", 140, covers[4], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Tuna salad sandwich", 123, covers[5], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Mini frittatas with spinach and bacon", 167, covers[6], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Tomato and goat cheese tartlets", 1400, covers[7], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("Leek and apple quiche with bacon", 110, covers[8], igua, "hmm");
        recipeList.add(a);

        a = new Recipe("German-style leek and cheese soup", 170, covers[9], igua, "hmm");
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


/*    private void createRecipe(){
        int[] foodpic = new int[]{
                R.drawable.album1};

        Ingredient i1 = new Ingredient (104, "kg", "Avocado");

        Ingredient[] igua = new Ingredient[]{i1};

        Recipe_old r = new Recipe_old ("Guacamole", 15083, foodpic[0], igua, "Avocado aufschneiden und dann Kern raus und keine Lust mehr");
    }*/

}
