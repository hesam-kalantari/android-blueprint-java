package com.quorum.demo.db.blog;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BlogDao
{

    @Query("SELECT * FROM TLB_BLOG")
    List<BlogEntity> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(final BlogEntity entity);
}
