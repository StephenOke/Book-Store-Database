package com.store.bookStore.repository;

import com.store.bookStore.model.Author;
import com.store.bookStore.model.AuthorDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    //get author with the most publishing
    @Query("SELECT a FROM Author a WHERE a.noOfBooks = (SELECT MAX(noOfBooks) FROM Author)")
    public Author getAuthorWithMaxBooks();


    //remove an author from the database
//    @Query("DELETE FROM Author a WHERE a.authorId = a.authorId")
//    public Author deleteAuthorBy(Long id);

    //fetch all authors
//    @Query("SELECT new com.store.bookStore.model.AuthorDetails(a.authorId ,  a.firstName, a.lastName, a.noOfBooks,b) FROM Author a JOIN a.noOfBooks b " )
//    List<AuthorDetails> findAllAuthors();

    //get all books the author has written
//    @Query("SELECT a")

//    @Query("SELECT a FROM Author a  WHERE EXISTS (SELECT a FROM Author WHERE a.authorId = Author.authorId) ")
//    public Author findAuthorBy(Long id);

}
