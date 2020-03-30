package com.springBoot.mapper;


import com.springBoot.entity.Librarian;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductorMapper {

    Librarian selectLibrarian(int id);

}
