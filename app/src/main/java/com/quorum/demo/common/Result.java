package com.quorum.demo.common;

public interface Result<T>
{
    void success(final T result);
    default void failed(final String message) {}
}
