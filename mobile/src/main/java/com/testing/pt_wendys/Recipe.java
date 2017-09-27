package com.testing.pt_wendys;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Maximilian Meyer
 */

public class Recipe implements Parcelable {
    private String name;
    private int numOfCalories;
    private int thumbnail;
    private ArrayList<Ingredient> ingredients;
    private String description;

    public Recipe(Parcel source) {
        this.name = source.readString();
        this.numOfCalories = source.readInt();
        this.ingredients = source.readArrayList(null);
        this.description = source.readString();

    }

    public Recipe(String name, int numOfCalories, int thumbnail, ArrayList <Ingredient> ingredients, String description) {
        this.name = name;
        this.numOfCalories = numOfCalories;
        this.thumbnail = thumbnail;
        this.ingredients = new ArrayList <Ingredient>();
        this.description = description;
    }


    public ArrayList <Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList <Ingredient> ingredients) { this.ingredients = ingredients; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfCalories() {
        return numOfCalories;
    }

    public void setNumOfCalories(int numOfSongs) {
        this.numOfCalories = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    // Rezept: Name, Kalorien, Bild, Array Ingredients, Beschreibung
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(numOfCalories);

        parcel.writeList(ingredients);
        parcel.writeString(description);
    }


    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>(){

        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int i) {
            return new Recipe[i];
        }
    };
}
