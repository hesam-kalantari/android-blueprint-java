package com.quorum.demo.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.quorum.demo.db.blog.BlogDao;
import com.quorum.demo.db.blog.BlogEntity;

@Database(entities = {BlogEntity.class}, version = 1)
public abstract class DemoDatabase extends RoomDatabase
{
    public static final String DATABASE_NAME = "demo_db";

    public abstract BlogDao blogDao();
}
