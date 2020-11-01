package com.quorum.demo.repository;

import androidx.annotation.NonNull;
import com.quorum.demo.common.Result;
import com.quorum.demo.db.blog.BlogDao;
import com.quorum.demo.db.blog.BlogEntity;
import com.quorum.demo.db.blog.BlogEntityMapper;
import com.quorum.demo.model.Blog;
import com.quorum.demo.network.ApiResponseCallback;
import com.quorum.demo.network.api.BlogResponseData;
import com.quorum.demo.network.api.BlogResponseDtoMapper;
import com.quorum.demo.network.api.BlogService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public class BlogRepository
{

    private final BlogDao blogDao;
    private final BlogService blogService;
    private final BlogEntityMapper blogEntityMapper;
    private final BlogResponseDtoMapper blogResponseDtoMapper;
    private final Executor diskIO;
    private final Executor mainThread;

    @Inject
    public BlogRepository(final BlogDao blogDao, final BlogService blogService, final BlogEntityMapper blogEntityMapper,
                          final BlogResponseDtoMapper blogResponseDtoMapper, final @Named("diskIO") Executor diskIO,
                          final @Named("mainThread") Executor mainThread)
    {
        this.blogDao = blogDao;
        this.blogService = blogService;
        this.blogEntityMapper = blogEntityMapper;
        this.blogResponseDtoMapper = blogResponseDtoMapper;
        this.diskIO = diskIO;
        this.mainThread = mainThread;
    }

    //TODO: temporary, repository should be transparently called
    private void getAllCachedBlogs(final Result<List<Blog>> callback) {
        Runnable runnable = () -> {
            try
            {
                final List<BlogEntity> entities = blogDao.findAll();
                mainThread.execute(() -> callback.success(blogEntityMapper.mapFromModelList(entities)));
            }
            catch (Exception ex) {
                mainThread.execute(() -> callback.failed(ex.getMessage()));
            }
        };

        this.diskIO.execute(runnable);
    }

    //TODO: temporary, repository should be transparently called
    private void getAllBlogs(final Result<List<Blog>> callback) {
        this.blogService.getBlogs().enqueue(new ApiResponseCallback<>(callback, new BlogResponseDtoMapper()));
//        this.blogService.getBlogs().enqueue(new Callback<List<BlogResponseData>>()
//        {
//            @Override
//            public void onResponse(final @NonNull Call<List<BlogResponseData>> call, final @NonNull Response<List<BlogResponseData>> response)
//            {
//                callback.success(blogResponseDtoMapper.mapFromModelList(Objects.requireNonNull(response.body())));
//            }
//
//            @Override
//            public void onFailure(final @NonNull Call<List<BlogResponseData>> call, final @NonNull Throwable t)
//            {
//                callback.failed(t.getMessage());
//            }
//        });
    }
}
