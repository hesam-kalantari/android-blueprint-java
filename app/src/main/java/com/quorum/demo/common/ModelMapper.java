package com.quorum.demo.common;

public interface ModelMapper<M, D>
{
    D mapFromModel(final M model);
    M mapToModel(final D domainModel);
}
