package com.store.bookStore.repository;

import com.store.bookStore.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface BooksRepository extends CrudRepository<Book, String> {
 @Query("SELECT  b FROM Book b WHERE b.ISBN = (SELECT MAX(ISBN) FROM Book )")
 public Book findMostBooksByISBN();
}
