package com.testing.pt_wendys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView listView;
    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    ArrayList<Ingredient> list = new ArrayList<Ingredient>();
   SharedPreferences mPrefs ;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

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
                    Intent viewTest = new Intent(ShoppingListActivity.this, MainActivity.class);
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

       // final ArrayList<Ingredient> ingredientList = r.getIngredients();

    //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredientList);//
        // listView.setAdapter(adapter);



        //declare the ui like this

            //the first time the activity was created
            //do the normal flow of the code
            //Example:getting the intent data for(savedList)or processing it



   //     if(savedInstanceState==null){
            Bundle data = getIntent().getExtras();
          //  list= savedInstanceState.getParcelableArrayList("savedList");
            if (data != null) {
                Recipe r = data.getParcelable("r");
                ArrayList<Ingredient> addedIngredients = r.getIngredients();
                    if (!getSavedList().isEmpty())
                    {   ArrayList<Ingredient> savedIngredients = getSavedList();
                        ArrayList<Ingredient> joinedIngredients =new ArrayList<Ingredient>();
                        joinedIngredients.addAll(savedIngredients);
                        joinedIngredients.addAll(addedIngredients);
                        updateIngredientList(joinedIngredients);
                        ingredientList = updateIngredientList(joinedIngredients);
                    }else{
                        updateIngredientList(addedIngredients);
                        ingredientList = updateIngredientList(updateIngredientList(addedIngredients));
                    }
               }else {
                ingredientList = getSavedList();
                updateIngredientList(ingredientList);
                ingredientList = updateIngredientList(ingredientList);

            }

       // }else{
            //this is called when orientation change occur
            //get the savedata
           //list= savedInstanceState.getParcelableArrayList("savedList");

       // Bundle data = getIntent().getExtras();
//            Recipe r = data.getParcelable("r");

     //       ingredientList = r.getIngredients();
          //  textname=savedInstanceState.getString("savetext");
          // ArrayList<Ingredient> newList = new ArrayList<Ingredient>(){{addAll(list);addAll(ingredientList);}};
           // updateIngredientList(list);
  //      }

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_shopping_list);
    }




    private ArrayList<Ingredient> updateIngredientList (final ArrayList<Ingredient> ingredientList){

        final IngredientAdapter adapter = new IngredientAdapter(this, ingredientList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                 ingredientList.remove(position);

                adapter.notifyDataSetChanged();
                updateData(ingredientList);
            }
        });
        return ingredientList;
        }

    private ArrayList<Ingredient> updateData(ArrayList<Ingredient> ingredientList) {
        return ingredientList;
    }


    private ArrayList<Ingredient>  getSavedList(){
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String savedjson =prefs.getString("savedJson", null);
        savedjson.length();
        ArrayList<Ingredient> savedIngredients = gson.fromJson(savedjson, new TypeToken<ArrayList<Ingredient>>() {
        }.getType());

        return savedIngredients;
    }
    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context

        //SharedPreferences settings = getSharedPreferences(String.valueOf(mPrefs), 0);
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(ingredientList); // myObject - instance of MyObject
        json.length();
        editor.putString("savedJson",json);
        // PreferencesUtils.getInstance(context).setString("players", toJson((.....ArrayList you want to convert.....)));

        //     prefsEditor.putString("MyObject", json);
        editor.commit();

    }
}
