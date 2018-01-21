package com.example.cmathew.griddlr.viewdatabinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class DrawableSourceAdapter {
    @BindingAdapter(value={"android:src"})
    public static void loadImage(ImageView view, int drawableResourceId) {
        view.setImageResource(drawableResourceId);
    }
}
