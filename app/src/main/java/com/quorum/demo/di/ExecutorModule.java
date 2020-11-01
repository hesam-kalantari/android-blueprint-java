package com.quorum.demo.di;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Module
@InstallIn(ApplicationComponent.class)
public class ExecutorModule
{

    @Singleton
    @Provides
    @Named("diskIO")
    public Executor provideDiskIO() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    @Provides
    @Named("mainThread")
    public Executor provideMainThread() {
        return new MainThreadExecutor();
    }

    private static class MainThreadExecutor implements Executor {

        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
