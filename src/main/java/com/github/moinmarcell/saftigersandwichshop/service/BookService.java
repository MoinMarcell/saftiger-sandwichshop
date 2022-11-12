package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import com.github.moinmarcell.saftigersandwichshop.repository.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book getRandomBook(){
        return bookRepo.getRandomBook();
    }
}
