package com.store.bookStore.controller;

import com.store.bookStore.bookStore.BooksBookStore;
import com.store.bookStore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")

public class booksController {
    private final BooksBookStore booksBookStore;

    @Autowired
    public booksController(BooksBookStore booksBookStore ){
        this.booksBookStore = booksBookStore;
    }

    //Endpoint to add a new Book

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
       Book savedBook = booksBookStore.insertBook(book);
        return ResponseEntity.ok(savedBook); // return saved book
    }

    // Endpoint to add multiple new books

    @PostMapping ("/batch")
    public ResponseEntity<List<Book>> createBooks(@RequestBody List<Book> books){
        List<Book> savedBooks = booksBookStore.insertBooks(books);
        return ResponseEntity.ok(books);
    }

    //Endpoint to collect/retrieve all books

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = booksBookStore.getAllBooks();
        return ResponseEntity.ok(books); //Return the list of book
    }
    //Endpoint to find books using ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBooksByISBN(@PathVariable("isbn") String isbn){
        Optional<Book> book = booksBookStore.findBooksByISBN(isbn);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); //if not case

    }


}