package com.example.cmathew.griddlr.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.cmathew.griddlr.GriddlrApplication;
import com.example.cmathew.griddlr.remote.RestClient;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class RestClientModule {
    @Provides
    @Reusable
    RestClient providesRestClient(Application application) {
        return new RestClient(application);
    }
}
