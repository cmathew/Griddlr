package com.example.cmathew.griddlr.matchmaker;

import com.example.cmathew.griddlr.BR;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.DrawableRes;

import com.example.cmathew.griddlr.models.Recipe;

public class RecipeViewModel extends BaseObservable {
    private Context context;
    private Recipe currentRecipe = null;
    public ObservableBoolean visibility = new ObservableBoolean(false);

    public RecipeViewModel(Context context) {
        this.context = context;
    }

    public void setCurrentRecipe(Recipe recipe) {
        this.currentRecipe = recipe;

        visibility.set(true);

        notifyPropertyChanged(BR.name);
        notifyPropertyChanged(BR.photo);
    }

    @Bindable
    public String getName() {
        return currentRecipe.getName();
    }

    @Bindable
    public @DrawableRes int getPhoto() {
        String drawableIdentifier = currentRecipe.getPhotoUrl();
        return context.getResources().getIdentifier(drawableIdentifier, "drawable", context.getPackageName());
    }
}
