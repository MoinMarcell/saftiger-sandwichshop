package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import com.github.moinmarcell.saftigersandwichshop.repository.BookRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepo bookRepo = mock(BookRepo.class);

    BookService bookService = new BookService(bookRepo);

    @Test
    void getRandomBook_whenIdExist_thenReturnBook() {
        //GIVEN
        Book expected = new Book("1", "title", "author");
        //WHEN
        when(bookRepo.getRandomBook()).thenReturn(expected);
        Book actual = bookService.getRandomBook();
        //THEN
        assertEquals(expected, actual);
        verify(bookRepo).getRandomBook();
    }
}