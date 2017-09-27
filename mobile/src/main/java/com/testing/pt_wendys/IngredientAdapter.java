package com.testing.pt_wendys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Regina on 27.09.2017.
 */

public class IngredientAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private Ingredient[] mDataSource;

    public IngredientAdapter(Context context,Ingredient[] items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.length;
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource[position];
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
        View rowView = mInflater.inflate(R.layout.activity_shopping, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(com.testing.pt_wendys.R.id.recipe_list_title);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(com.testing.pt_wendys.R.id.recipe_list_subtitle);

// Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(com.testing.pt_wendys.R.id.recipe_list_detail);




        Ingredient ingredient = (Ingredient) getItem(position);

// 2
        titleTextView.setText(ingredient.name);
        subtitleTextView.setText((int) ingredient.amount);
        detailTextView.setText(ingredient.unit);

        return rowView;
    }
}
