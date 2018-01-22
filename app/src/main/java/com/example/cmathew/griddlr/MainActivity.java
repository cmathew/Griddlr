package com.example.cmathew.griddlr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cmathew.griddlr.matchmaker.Recipe;
import com.example.cmathew.griddlr.remote.RecipeClient;
import com.example.cmathew.griddlr.remote.RestClient;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {
    @Inject
    RestClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeClient recipeClient = new RecipeClient(restClient);
        Recipe recipe = recipeClient.getRecipe(1);
    }
}
