package com.example.cmathew.griddlr.models;

public class Recipe {
    private long id;
    private String name;
    private Chef author;
    private String yield;

    private String photo_url;

    private String[] instructions;
    private Ingredient[] ingredients;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photo_url;
    }

    public Chef getAuthor() {
        return author;
    }

    public String getYield() {
        return yield;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }
}
