package com.quorum.demo.di;

import android.content.Context;
import androidx.room.Room;
import com.quorum.demo.db.DemoDatabase;
import com.quorum.demo.db.blog.BlogDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

import javax.inject.Singleton;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule
{

    @Singleton
    @Provides
    public DemoDatabase provideDemoDatabase(@ApplicationContext Context context) {
        return Room
                .databaseBuilder(context, DemoDatabase.class, DemoDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    public BlogDao provideBlogDAO(final DemoDatabase demoDatabase) {
        return demoDatabase.blogDao();
    }
}
