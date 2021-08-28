package com.kimmoller.bookcollection;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, UUID> {
    public List<Book> findAll();
}