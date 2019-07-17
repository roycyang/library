package com.giantmachines.library.controller;

import com.giantmachines.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping ("/books")
public class BookController {

    private Map <Integer, Book> bookMap = new HashMap<>();
    private Integer counter = 0;

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookMap.put(++counter, book);
    }

    @GetMapping
    public Set<Map.Entry<Integer, Book>> getAllBook(){
        return bookMap.entrySet();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        return bookMap.get(bookId);
    }

}