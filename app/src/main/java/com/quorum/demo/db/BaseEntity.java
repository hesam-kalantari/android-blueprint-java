package com.quorum.demo.db;

import androidx.annotation.Nullable;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable
{

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(@Nullable final Object obj);
}
