package com.example.cmathew.griddlr.welcome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cmathew.griddlr.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
    private int NUM_PAGES = 3;

    @BindView(R.id.welcome_slideshow)
    ViewPager welcomeSlideshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        ArrayList<WelcomeSlide> slides = getSlides();
        this.welcomeShowAdapter = new SlideshowAdapter(getSupportFragmentManager(), slides);

        // Instantiate a ViewPager
        welcomeSlideshow.setAdapter(welcomeShowAdapter);

    }

    private ArrayList<WelcomeSlide> getSlides() {
        WelcomeSlide slide1 = new WelcomeSlide();
        WelcomeSlide slide2 = new WelcomeSlide();
        WelcomeSlide slide3 = new WelcomeSlide();

        Arrays.asList(slide1, slide2, slide3);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class WelcomeSlidePagerAdapter extends FragmentStatePagerAdapter {
        public WelcomeSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public WelcomeSlideFragment getItem(int position) {
            return new WelcomeSlideFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
