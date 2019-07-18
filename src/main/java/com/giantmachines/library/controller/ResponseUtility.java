package com.giantmachines.library.controller;

import com.giantmachines.library.model.Book;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class ResponseUtility {

    public static ResponseEntity buildOkResponse(Object entity) {

        return ResponseEntity.ok().body(entity);
    }

    public static ResponseEntity buildCreatedResponse(Book book) {

        URI location = URI.create("http:localhost:8080/users/" + book.getId());

        return ResponseEntity.created(location).build();
    }
}
