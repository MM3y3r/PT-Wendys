package com.testing.pt_wendys;

import java.util.ArrayList;

/**
 * Created by Maximilian Meyer
 */

public class Recipe_old {
    private String name;
    private int numOfCalories;
    private int thumbnail;
    private ArrayList<Ingredient> ingredients;
    private String description;

    public Recipe_old() {
    }

    public Recipe_old(String name, int numOfCalories, int thumbnail,  ArrayList<Ingredient> ingredients, String description) {
        this.name = name;
        this.numOfCalories = numOfCalories;
        this.thumbnail = thumbnail;
       this.ingredients = new ArrayList<Ingredient>();
        this.description = description;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

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
}
