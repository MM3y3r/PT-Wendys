package com.testing.pt_wendys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shopping2 extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView listView;
    //private ArrayList<Ingredient> ingredientList;


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




        //Recipe_old r = createRecipe();

       // final ArrayList<Ingredient> ingredientList = r.getIngredients();

    //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredientList);//
        // listView.setAdapter(adapter);


        Bundle data = getIntent().getExtras();

        if (data != null) {
            Recipe r = data.getParcelable("r");
            //ArrayList<Ingredient> addedIngredients = r.getIngredients();
            //ingredientList.addAll(addedIngredients);
            final ArrayList<Ingredient> ingredientList = r.getIngredients()   ;
            final IngredientAdapter adapter = new IngredientAdapter(this, ingredientList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    ingredientList.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
        }


        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_shopping_list);
    }


}
