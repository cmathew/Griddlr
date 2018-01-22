package com.example.cmathew.griddlr.viewdatabinding;

import android.databinding.BindingAdapter;
import android.view.View;

public class VisibilityAdapter {
    @BindingAdapter(value={"visibility"})
    public static void setVisibility(View view, Boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
