package com.testing.pt_wendys;

import android.media.Image;

/**
 * Created by Kati on 26.09.2017.
 */

public class Ingredient {
    int amount;
    String unit;
    String name;


    public Ingredient (int amount, String unit, String name){
        this.amount = amount;
        this.unit = unit;
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


