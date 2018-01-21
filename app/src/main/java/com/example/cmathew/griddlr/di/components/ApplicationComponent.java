package com.example.cmathew.griddlr.di.components;

import android.app.Application;

import com.example.cmathew.griddlr.GriddlrApplication;
import com.example.cmathew.griddlr.di.componentmodules.ActivityBindingModule;
import com.example.cmathew.griddlr.di.componentmodules.FragmentBindingModule;
import com.example.cmathew.griddlr.di.modules.SharedPreferenceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules={
        // Required by the dagger-android framework
        AndroidSupportInjectionModule.class,
        // Specify valid injection targets
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        // Provider modules
        SharedPreferenceModule.class})

public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        ApplicationComponent.Builder application(Application application);
        ApplicationComponent build();
    }

    void inject(GriddlrApplication app);
}
