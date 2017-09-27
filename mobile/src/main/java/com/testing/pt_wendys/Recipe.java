package com.testing.pt_wendys;

/**
 * Created by Maximilian Meyer
 */

public class Recipe {
    private String name;
    private int numOfCalories;
    private int thumbnail;
    private Ingredient[] ingredients;
    private String description;

    public Recipe() {
    }

    public Recipe(String name, int numOfCalories, int thumbnail, Ingredient[] ingredients, String description) {
        this.name = name;
        this.numOfCalories = numOfCalories;
        this.thumbnail = thumbnail;
        this.ingredients = ingredients;
        this.description = description;
    }


    public Ingredient[] getIngredients() { return ingredients; }

    public void setIngredients(Ingredient[] ingredients) { this.ingredients = ingredients; }

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
