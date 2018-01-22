package com.example.cmathew.griddlr.di.componentmodules;

import com.example.cmathew.griddlr.di.scopes.FragmentScope;
import com.example.cmathew.griddlr.matchmaker.MatchMakerFragment;
import com.example.cmathew.griddlr.welcome.WelcomeCompletionFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract WelcomeCompletionFragment welcomeCompletionFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract MatchMakerFragment matchMakerFragment();
}