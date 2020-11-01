package com.quorum.demo.db.blog;

import com.quorum.demo.common.ModelMapper;
import com.quorum.demo.model.Blog;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BlogEntityMapper implements ModelMapper<BlogEntity, Blog>
{

    @Inject
    public BlogEntityMapper() {}

    @Override
    public Blog mapFromModel(final BlogEntity entity)
    {
        return new Blog(entity.getId(),
                entity.getTitle(),
                entity.getBody(),
                entity.getImage(),
                entity.getCategory());
    }

    @Override
    public BlogEntity mapToModel(final Blog blog)
    {
        return new BlogEntity(blog.getId(),
                blog.getTitle(),
                blog.getBody(),
                blog.getImage(),
                blog.getCategory());
    }

    public List<Blog> mapFromModelList(final List<BlogEntity> entities) {
        return entities.stream()
                .map(this::mapFromModel)
                .collect(Collectors.toList());
    }
}
