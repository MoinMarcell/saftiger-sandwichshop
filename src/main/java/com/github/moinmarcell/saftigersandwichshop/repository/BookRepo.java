package com.github.moinmarcell.saftigersandwichshop.repository;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class BookRepo {
    private final List<Book> books;

    public BookRepo(List<Book> books) {
        this.books = books;
    }

    public List<Book> books() {
        return books;
    }

    public Book getBookById(String id){
        for(Book b : books){
            if(b.id().equals(id)){
                return b;
            }
        }
        return null;
    }
    public Book getRandomBook(){
        Random random = new Random();
        int index = random.nextInt(0, books().size());
        return books.get(index);
    }

}
