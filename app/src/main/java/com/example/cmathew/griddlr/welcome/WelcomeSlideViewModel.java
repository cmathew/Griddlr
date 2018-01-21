package com.example.cmathew.griddlr.welcome;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class WelcomeSlideViewModel {
    private WelcomeSlide slide;

    public WelcomeSlideViewModel(WelcomeSlide slide) {
        this.slide = slide;
    }

    public @StringRes int getHeader() {
        return slide.getHeader();
    }

    public @StringRes int getMessage() {
        return slide.getMessage();
    }

    public @DrawableRes int getImage() {
        return slide.getImage();
    }
}
