package com.example.cmathew.griddlr.welcome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cmathew.griddlr.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.welcome_slideshow)
    ViewPager welcomeSlideshow;

    private WelcomeSlidePagerAdapter welcomeSlideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                R.drawable.ic_chat_bubble);

        return Arrays.asList(slide1, slide2, slide3);
    }

    private class WelcomeSlidePagerAdapter extends FragmentPagerAdapter {
        private List<WelcomeSlide> slides;

        public WelcomeSlidePagerAdapter(FragmentManager fm, List<WelcomeSlide> slides) {
            super(fm);

            this.slides = slides;
        }

        @Override
        public WelcomeSlideFragment getItem(int position) {
            WelcomeSlide slide = slides.get(position);
            return WelcomeSlideFragment.newInstance(slide);
        }

        @Override
        public int getCount() {
            return slides.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            WelcomeSlide slide = slides.get(position);
            return getString(slide.getTitle());
        }
    }
}
