package com.testing.pt_wendys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shopping2 extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView listView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_planner:
                  //  mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_recipes:
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent viewTest = new Intent(Shopping2.this, MainActivity.class);
                    startActivity(viewTest);
                    return true;
                case R.id.navigation_shopping_list:
                  //  mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping22);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] ingredients = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };


        Recipe_old r = createRecipe();

        ArrayList<Ingredient> ingredientList = r.getIngredients();

    //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredientList);//
        // listView.setAdapter(adapter);

        IngredientAdapter adapter = new IngredientAdapter(this, ingredientList);
        listView.setAdapter(adapter);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_shopping_list);
    }
    private Recipe_old createRecipe(){
        int[] foodpic = new int[]{
                R.drawable.recipe1};


        Ingredient i1 = new Ingredient (104, "kg", "Avocado");
        Ingredient i2 = new Ingredient(2, "Stück", "Zitrone");

        ArrayList<Ingredient> igua = new ArrayList<Ingredient>();
        igua.add(i1);
        igua.add(i2);

        Recipe_old r = new Recipe_old("Guacamole", 15083, foodpic[0], igua, "Avocado aufschneiden und dann Kern raus und keine Lust mehr");

        return r;
    }

}
