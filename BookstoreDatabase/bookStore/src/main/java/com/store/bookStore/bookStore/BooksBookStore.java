package com.store.bookStore.bookStore;

import com.store.bookStore.model.Book;
import com.store.bookStore.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BooksBookStore {
    private final BooksRepository booksRepository;

    public BooksBookStore(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public Book insertBook(Book book){ return booksRepository.save(book);} //Method to add and save books

    public List<Book> getAllBooks(){
        Iterable<Book> books = booksRepository.findAll(); //Return all books
        return Streamable.of(books).toList();
    }
    public Optional<Book> findBooksByISBN(String number){return booksRepository.findById(number);}

    public List<Book> insertBooks(List<Book> books){
        Iterable<Book> savedBooks = booksRepository.saveAll(books);
        return Streamable.of(savedBooks).toList();
    }

}
