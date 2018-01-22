package com.example.cmathew.griddlr.matchmaker;

public class Recipe {
    private long id;
    private String name;
    private Chef author;
    private String yield;

    private String[] instructions;
    private Ingredient[] ingredients;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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
