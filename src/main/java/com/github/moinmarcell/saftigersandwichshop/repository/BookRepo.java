package com.github.moinmarcell.saftigersandwichshop.repository;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@Repository
public class BookRepo {
    private final Book[] books;

    public BookRepo() {
        this.books = WebClient
                .builder()
                .baseUrl("https://my-json-server.typicode.com/Flooooooooooorian")
                .build()
                .method(HttpMethod.GET)
                .uri("/BookApi/books")
                .exchangeToMono(
                    clientResponse -> clientResponse.bodyToMono(Book[].class)
                )
                .block();
    }

    public Book getRandomBook(){
        Random random = new Random();
        int index = random.nextInt(0, books.length);
        return books[index];
    }

}
