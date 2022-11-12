package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import com.github.moinmarcell.saftigersandwichshop.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> books(){
        return bookRepo.books();
    }

    public Book getBookById(String id){
        return bookRepo.getBookById(id);
    }

    public Book getRandomBook(){
        return bookRepo.getRandomBook();
    }
}
