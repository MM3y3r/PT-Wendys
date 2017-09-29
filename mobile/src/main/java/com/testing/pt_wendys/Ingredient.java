package com.testing.pt_wendys;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Kati on 26.09.2017.
 */

public class Ingredient implements Parcelable{
    int amount;
    String unit;
    String name;

    public Ingredient(Parcel source) {
        amount = source.readInt();
        unit = source.readString();
        name = source.readString();
    }


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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(amount);
        parcel.writeString(unit);
        parcel.writeString(name);


    }
    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>(){

        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int i) {
            return new Ingredient[i];
        }
    };
}


