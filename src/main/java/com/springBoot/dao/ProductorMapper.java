package com.springBoot.dao;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductorMapper {

    Librarian selectLibrarian(int id);

}
