package com.workflow.mapper;

public interface BaseMapper<E, D> {

    D map(E entity);
}
