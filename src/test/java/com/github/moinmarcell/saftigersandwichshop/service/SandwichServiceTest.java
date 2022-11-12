package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import com.github.moinmarcell.saftigersandwichshop.repository.SandwichRepo;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SandwichServiceTest {

    SandwichRepo sandwichRepo = mock(SandwichRepo.class);
    IdService idService = mock(IdService.class);
    BookService bookService = mock(BookService.class);
    SandwichService sandwichService = new SandwichService(sandwichRepo, idService, bookService);

    @Test
    void getAllSandwiches_whenSandwichListIsNotEmpty_thenReturnListOfSandwiches() {
        //GIVEN
        List<Sandwich> expected = Collections.emptyList();
        //WHEN
        when(sandwichRepo.getAllSandwiches()).thenReturn(expected);
        List<Sandwich> actual = sandwichService.getAllSandwiches();
        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).getAllSandwiches();
    }

    @Test
    void getSandwichById_whenIdExist_thenReturnSandwichById() {
        //GIVEN
        Sandwich expected = new Sandwich("1", "sandwich", Collections.emptyList(), 2, false, new Book("1", "title", "author"));
        String id = "1";
        //WHEN
        when(sandwichRepo.getSandwichById(id)).thenReturn(expected);
        Sandwich actual = sandwichService.getSandwichById(id);
        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).getSandwichById(id);
    }

    @Test
    void saveSandwich() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void updateSandwich() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void deleteSandwich() {
        //GIVEN

        //WHEN

        //THEN
    }
}