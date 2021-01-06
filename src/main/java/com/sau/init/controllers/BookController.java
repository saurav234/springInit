package com.sau.init.controllers;


import com.sau.init.domain.Book;
import com.sau.init.repositories.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public String getBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        String bookString = "";
        for(Book book : books) {
            bookString = bookString + book.toString();
        }
        return bookString;
    }
}
