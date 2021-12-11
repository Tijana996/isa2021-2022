package com.ftn.ISA2122.helper;

public interface MapperInterface<T,U> {

    T toEntity(U dto);

    U toDto(T entity);
}

