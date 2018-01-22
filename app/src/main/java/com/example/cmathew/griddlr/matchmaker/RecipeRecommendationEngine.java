package com.example.cmathew.griddlr.matchmaker;

import java.util.Date;
import java.util.Random;

public class RecipeRecommendationEngine {
    private static final int RECIPE_COUNT = 5;

    private Random generator;

    public RecipeRecommendationEngine() {
        Date now = new Date();
        this.generator = new Random(now.getTime());
    }

    public long[] getRecommendations(long userId, int recommendationCount) {
        long[] recommendations = new long[recommendationCount];
        long pivotVal = Math.abs(generator.nextLong());
        for (int i = 0; i < recommendationCount; i++) {
            recommendations[i] = ((pivotVal + i) % RECIPE_COUNT) + 1;
        }

        return recommendations;
    }
}
