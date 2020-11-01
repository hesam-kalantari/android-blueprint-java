package com.quorum.demo.network.api;

import com.quorum.demo.common.ModelMapper;
import com.quorum.demo.model.Blog;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BlogResponseMapper implements ModelMapper<BlogResponseData, Blog>
{

    @Inject
    public BlogResponseMapper() {}

    @Override
    public Blog mapFromModel(final BlogResponseData blogResponseData)
    {
        return new Blog(blogResponseData.getId(),
                blogResponseData.getTitle(),
                blogResponseData.getBody(),
                blogResponseData.getImage(),
                blogResponseData.getCategory());
    }

    @Override
    public BlogResponseData mapToModel(final Blog blog)
    {
        return new BlogResponseData(blog.getId(),
                blog.getTitle(),
                blog.getBody(),
                blog.getImage(),
                blog.getCategory());
    }

    public List<Blog> mapFromModelList(final List<BlogResponseData> responses) {
        return responses.stream()
                .map(this::mapFromModel)
                .collect(Collectors.toList());
    }
}
