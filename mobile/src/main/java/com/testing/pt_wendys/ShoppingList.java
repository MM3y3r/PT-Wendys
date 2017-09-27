package com.testing.pt_wendys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class ShoppingList extends AppCompatActivity {

    private TextView mTextMessage;
    ListView listView ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_planner:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_recipes:
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent viewShoppingList = new Intent(ShoppingList.this, MainActivity.class);
                    startActivity(viewShoppingList);
                    return true;
                case R.id.navigation_shopping_list:
                    //mTextMessage.setText(R.string.title_notifications);

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setContentView(R.layout.activity_shopping);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
      /* String[] ingredients = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };*/



        //Recipe_old r = createRecipe();

        //final Ingredient[] ingredientList = r.getIngredients();

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredientList);
     //   listView.setAdapter(adapter);
// 2
      // IngredientAdapter adapter = new IngredientAdapter(this, ingredientList);
       //listView.setAdapter(adapter);

        // String [] ingredients =
        //https://www.raywenderlich.com/124438/android-listview-tutorial

      //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
       // listView.setAdapter(adapter);
// 3



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
