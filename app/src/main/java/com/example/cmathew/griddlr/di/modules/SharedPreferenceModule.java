package com.example.cmathew.griddlr.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.cmathew.griddlr.GriddlrApplication;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class SharedPreferenceModule {
    @Provides
    @Reusable
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences(GriddlrApplication.PREFS_PATH, Context.MODE_PRIVATE);
    }
}
