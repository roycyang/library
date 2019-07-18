package com.giantmachines.library.persistence;

import com.giantmachines.library.exception.EntityNotFoundException;
import com.giantmachines.library.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Primary
@Transactional
public class H2Persistence implements Persistence {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book save(Book book) {

        entityManager.persist(book);
        return book;
    }

    @Override
    public Book findById(Integer bookId) throws EntityNotFoundException {
        Book book = entityManager.find(Book.class, bookId);

        if (book == null) {
            throw new EntityNotFoundException();
        }

        return book;
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createNamedQuery("findAllBooks").getResultList();
    }

}