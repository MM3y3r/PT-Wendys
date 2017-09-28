package com.testing.pt_wendys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Ingredient> mDataSource;

    public IngredientAdapter(Context context, ArrayList<Ingredient> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }


    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        Ingredient ingredient = (Ingredient) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_ingredient, parent, false);
        }
       // View rowView = mInflater.inflate(R.layout.list_item_ingredient, parent, false);

        TextView titleTextView =
                (TextView) convertView.findViewById(R.id.ingredient_name);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) convertView.findViewById(R.id.ingredient_value);

// Get detail element
        TextView detailTextView =
                (TextView) convertView.findViewById(R.id.ingredient_amount);




// 2
        titleTextView.setText(ingredient.name);
        subtitleTextView.setText(""+ingredient.amount);
        detailTextView.setText(ingredient.unit);

        return convertView;
    }
}