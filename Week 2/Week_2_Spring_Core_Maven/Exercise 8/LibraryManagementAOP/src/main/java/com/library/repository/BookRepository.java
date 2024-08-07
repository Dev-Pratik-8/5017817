package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void fetchAllBooks() {
        System.out.println("Fetching all books...");
    }
}
