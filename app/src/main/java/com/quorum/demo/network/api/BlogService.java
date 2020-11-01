package com.quorum.demo.network.api;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BlogService
{

    @GET("blogs")
    Call<BlogResponseData> getBlogs();
}
