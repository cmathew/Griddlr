package com.example.cmathew.griddlr.remote;

import android.net.Uri;

import com.example.cmathew.griddlr.matchmaker.RecipeRecommendationEngine;

public class MatchClient {
    private RestClient restClient;

    public MatchClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public long[] getRecommendations(long userId) {
        RecipeRecommendationEngine engine = new RecipeRecommendationEngine();
        return engine.getRecommendations(userId, 1);
    }

    public Uri getMatchesRoot() {
        return restClient.getApiRoot().buildUpon().appendPath("matches").build();
    }
}
