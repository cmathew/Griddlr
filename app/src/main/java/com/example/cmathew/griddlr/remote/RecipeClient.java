package com.example.cmathew.griddlr.remote;

import android.net.Uri;

import com.example.cmathew.griddlr.Recipe;
import com.google.gson.Gson;

public class RecipeClient {
    private RestClient restClient;

    public RecipeClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Recipe getRecipe(long id) {
        Uri uri = getRecipesRoot().buildUpon().appendPath(String.valueOf(id)).build();
        HttpResponse response = restClient.makeGetRequest(uri);
        Gson gson = new Gson();
        return gson.fromJson(response.getData(), Recipe.class);
    }

    public Uri getRecipesRoot() {
        return restClient.getApiRoot().buildUpon().appendPath("recipes").build();
    }
}
