package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getBook() {
        System.out.println("Getting book details...");
        bookRepository.fetchAllBooks();
    }
}
