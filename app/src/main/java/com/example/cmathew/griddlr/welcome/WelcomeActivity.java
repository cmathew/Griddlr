package com.example.cmathew.griddlr.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cmathew.griddlr.MainActivity;
import com.example.cmathew.griddlr.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class WelcomeActivity extends AppCompatActivity {
    public static final String PREFS_KEY_WELCOME_COMPLETE = "show_tutorial";

    @BindView(R.id.welcome_slideshow)
    ViewPager welcomeSlideshow;

    @Inject
    SharedPreferences prefs;

    private WelcomeSlidePagerAdapter welcomeSlideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        if (prefs.getBoolean(PREFS_KEY_WELCOME_COMPLETE, false)) {
            onUserWelcomed();
            return;
        }

        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        List<WelcomeSlide> slides = getSlides();
        this.welcomeSlideAdapter = new WelcomeSlidePagerAdapter(getSupportFragmentManager(), slides);

        // Instantiate a ViewPager
        welcomeSlideshow.setAdapter(welcomeSlideAdapter);
    }

    private List<WelcomeSlide> getSlides() {
        WelcomeSlide slide1 = new WelcomeSlide(
                R.string.welcome_slide1_title,
                R.string.welcome_slide1_header,
                R.string.welcome_slide1_message,
                R.drawable.waffle_icon);

        WelcomeSlide slide2 = new WelcomeSlide(
                R.string.welcome_slide2_title,
                R.string.welcome_slide2_header,
                R.string.welcome_slide2_message,
                R.drawable.welcome_tableau);

        WelcomeSlide slide3 = new WelcomeSlide(
                R.string.welcome_slide3_title,
                R.string.welcome_slide3_header,
                R.string.welcome_slide3_message,
                R.drawable.waffle_talk);

        return Arrays.asList(slide1, slide2, slide3);
    }

    public void onUserWelcomed() {
        finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private class WelcomeSlidePagerAdapter extends FragmentPagerAdapter {
        private List<WelcomeSlide> slides;

        public WelcomeSlidePagerAdapter(FragmentManager fm, List<WelcomeSlide> slides) {
            super(fm);

            this.slides = slides;
        }

        @Override
        public Fragment getItem(int position) {
            if (position <= 2) {
                WelcomeSlide slide = slides.get(position);
                return WelcomeSlideFragment.newInstance(slide);
            } else {
                return WelcomeCompletionFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return slides.size() + 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0 || position == 3) {
                return null;
            }

            WelcomeSlide slide = slides.get(position);
            return getString(slide.getTitle());
        }
    }
}
