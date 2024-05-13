package com.store.bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDetails {
    private Long authorId;
    private String firstName;
    private String lastName;
    private Double noOfBooks;
    private Book book;
}


