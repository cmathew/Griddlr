package com.example.cmathew.griddlr.di.componentmodules;

import com.example.cmathew.griddlr.MainActivity;
import com.example.cmathew.griddlr.di.scopes.ActivityScope;
import com.example.cmathew.griddlr.welcome.WelcomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract WelcomeActivity welcomeActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}