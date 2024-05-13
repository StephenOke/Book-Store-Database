package com.store.bookStore.controller;

import com.store.bookStore.bookStore.AuthorBookStore;
import com.store.bookStore.model.Author;
import com.store.bookStore.model.AuthorDetails;
import com.store.bookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorBookStore authorBookStore;

    @Autowired
    public AuthorController(AuthorBookStore authorBookStore){this.authorBookStore = authorBookStore;}

    // Add new Author
    @PostMapping
    public ResponseEntity<Author> insertNewAuthorRecord(@RequestBody Author author){
        Author savedAuthor = authorBookStore.insertNewAuthorRecord(author);
        return ResponseEntity.ok(savedAuthor);  //return list of all employee
    }

    // endpoint to add multiple Authors
    @PostMapping("/batch")
    public ResponseEntity<List<Author>> createAuthor(@RequestBody List<Author> authors){
        List<Author> savedAuthors = authorBookStore.insertAuthors(authors);
        return ResponseEntity.ok(savedAuthors);
    }

    @GetMapping("/most-books")
    public  ResponseEntity<List<Author>> getAuthorWithMaxBooks(){
        Author author = authorBookStore.getAuthorWithMaxBooks();
        if (author != null){
            return ResponseEntity.ok(Collections.singletonList(author));  // Returns the author with the most books
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if no employee found
        }
    }


    //endpoint to delete Author Record
    public  ResponseEntity<List<Author>> deleteAuthor(@RequestBody Author author){
      author.setAuthorId(null);
      return ResponseEntity.notFound().build();
    }

    //endpoint to get all authors
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorBookStore.getAllAuthors();
        return ResponseEntity.ok(authors);

    }

}
