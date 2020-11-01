package com.quorum.demo.network.api;

import com.quorum.demo.common.ModelMapper;
import com.quorum.demo.model.Blog;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BlogResponseDtoMapper implements ModelMapper<BlogResponseData, List<Blog>>
{

    @Inject
    public BlogResponseDtoMapper() {}

    @Override
    public List<Blog> mapFromModel(final BlogResponseData model)
    {
        return model.getBlogs().stream().map(this::mapFromBlogDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlogResponseData mapToModel(final List<Blog> domainModel)
    {
        return null;
    }

    private Blog mapFromBlogDto(final BlogResponseData.BlogDto dto) {
        return new Blog(dto.getId(),
                dto.getTitle(),
                dto.getBody(),
                dto.getImage(),
                dto.getCategory());
    }

    //    @Override
//    public Blog mapFromModel(final BlogResponseData dto)
//    {
//        return new Blog(dto.getId(),
//                dto.getTitle(),
//                dto.getBody(),
//                dto.getImage(),
//                dto.getCategory());
//    }
//
//    @Override
//    public BlogResponseData mapToModel(final Blog blog)
//    {
//        return new BlogResponseData(blog.getId(),
//                blog.getTitle(),
//                blog.getBody(),
//                blog.getImage(),
//                blog.getCategory());
//    }
//
//    public List<Blog> mapFromModelList(final List<BlogResponseData> dto) {
//        return dto.stream()
//                .map(this::mapFromModel)
//                .collect(Collectors.toList());
//    }
}
