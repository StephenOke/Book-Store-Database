package com.store.bookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String firstName;
    private String lastName;
    private Long noOfBooks;

    // foreignKey
    @Column(name = "isbn")
    private Integer isbn;

    // Relationships to Books
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
//    private Book book;



}
