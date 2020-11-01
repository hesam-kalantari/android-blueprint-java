package com.quorum.demo;

import android.app.Application;
import com.quorum.demo.common.log.ReleaseTree;
import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class DemoApplication extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        else
            Timber.plant(new ReleaseTree());
    }
}
