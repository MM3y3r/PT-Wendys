package com.testing.pt_wendys;

/**
 * Created by Maximilian Meyer
 */

public class Recipe {
    private String name;
    private int numOfCalories;
    private int thumbnail;

    public Recipe() {
    }

    public Recipe(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfCalories = numOfSongs;
        this.thumbnail = thumbnail;
    }

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
