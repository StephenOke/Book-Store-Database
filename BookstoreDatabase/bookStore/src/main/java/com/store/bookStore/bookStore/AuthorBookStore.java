package com.store.bookStore.bookStore;

import com.store.bookStore.model.Author;
import com.store.bookStore.model.AuthorDetails;
import com.store.bookStore.repository.AuthorRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public final class AuthorBookStore {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorBookStore(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return Streamable.of(authorRepository.findAll()).toList();
    }

//    public List<Author> getAuthor(Long id){
//        return (List<Author>) authorRepository.findAll();
//    }
    public Author getAuthorWithMaxBooks(){
        return  authorRepository.getAuthorWithMaxBooks();
    }
    public Author insertNewAuthorRecord(Author author){
       try {
           return authorRepository.save(author);
       } catch (DataAccessException e){
           throw new ServiceException("Failed to insert author to the Record.", e);
       }

    }
    public List<Author> insertAuthors(List<Author> authors){
        Iterable<Author> savedAuthors = authorRepository.saveAll(authors);
        return Streamable.of(savedAuthors).toList();
    }


}
