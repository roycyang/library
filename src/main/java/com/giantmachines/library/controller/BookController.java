package com.giantmachines.library.controller;

import com.giantmachines.library.exception.EntityNotFoundException;
import com.giantmachines.library.model.Book;
import com.giantmachines.library.persistence.Persistence;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("/books")
public class BookController {

    private Persistence persistence;

    public BookController(Persistence persistence) {
        this.persistence = persistence;
    }

    private Map <Integer, Book> bookMap = new HashMap<>();

    @PostMapping
    public ResponseEntity addBook(@Valid @RequestBody Book book) {
        return ResponseUtility.buildCreatedResponse(persistence.save(book));
    }

    @GetMapping
    public ResponseEntity getAllBooks() {
        return ResponseUtility.buildOkResponse(persistence.findAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity getBookById(@PathVariable Integer bookId) throws EntityNotFoundException {
        return ResponseUtility.buildOkResponse(persistence.findById(bookId));
    }

}