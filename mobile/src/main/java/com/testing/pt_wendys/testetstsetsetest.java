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

public class testetstsetsetest extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView listView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_planner:
                    mTextMessage.setText(R.string.title_planner);
                    return true;
                case R.id.navigation_recipes:
                    mTextMessage.setText(R.string.title_dashboard);
                    Intent viewTest = new Intent(testetstsetsetest.this, MainActivity.class);
                    startActivity(viewTest);
                    return true;
                case R.id.navigation_shopping_list:
                    mTextMessage.setText(R.string.title_notifications);
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

        //REZEPTUEBERGABE
        Bundle data = getIntent().getExtras();
        Recipe r = data.getParcelable("r");

        // Defined Array values to show in ListView
        String[] ingredients = new String[] { r.getName(), r.getDescription()
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
        listView.setAdapter(adapter);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
