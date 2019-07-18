package com.giantmachines.library.persistence;

import com.giantmachines.library.exception.EntityNotFoundException;
import com.giantmachines.library.model.Book;

import java.util.List;

public interface Persistence {

    Book save(Book book);

    List<Book> findAll();

    Book findById(Integer bookId) throws EntityNotFoundException;

}