package com.example.cmathew.griddlr.welcome;

public class WelcomeSlide {
    private int drawableResourceId;
    private int captionResourceId;
    private int headerResourceId;

    public WelcomeSlide(int drawableId, int headerId, int captionId) {
        this.drawableResourceId = drawableId;
        this.headerResourceId = headerId;
        this.captionResourceId = captionId;
    }

    public int getDrawableResourceId() {
        return drawableResourceId;
    }

    public int getHeaderResourceId() {
        return headerResourceId;
    }

    public int getCaptioneResourceId() {
        return captionResourceId;
    }
}
