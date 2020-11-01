package com.quorum.demo.common;

public interface ModelMapper<Model, DomainModel>
{
    DomainModel mapFromModel(final Model model);
    Model mapToModel(final DomainModel domainModel);
}
