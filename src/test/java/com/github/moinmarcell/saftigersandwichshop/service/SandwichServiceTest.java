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
        Sandwich expected = new Sandwich(
                "1",
                "sandwich",
                Collections.emptyList(),
                2,
                false,
                new Book("1", "title", "author"));

        String id = "1";

        //WHEN
        when(sandwichRepo.getSandwichById(id)).thenReturn(expected);
        Sandwich actual = sandwichService.getSandwichById(id);

        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).getSandwichById(id);

    }

    @Test
    void saveSandwich_whenSandwichNotExist_thenAddSandwichToListAndReturnAddedSandwich() {
        //GIVEN
        String expectedId = "1";
        Book bookExpected = new Book("1", "title", "author");
        Sandwich expected = new Sandwich(
                "1",
                "expected",
                Collections.emptyList(),
                2,
                false,
                new Book("1", "title", "author"));

        //WHEN
        when(sandwichRepo.saveSandwich(any())).thenReturn(expected);
        when(idService.generateId()).thenReturn(expectedId);
        when(bookService.getRandomBook()).thenReturn(bookExpected);

        Sandwich actual = sandwichService.saveSandwich(expected);

        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).saveSandwich(expected);

    }

    @Test
    void updateSandwich_whenSandwichIdExist_thenReturnEditSandwich() {

        //GIVEN
        Sandwich expected = new Sandwich(
                "1",
                "sandwichneu",
                Collections.emptyList(),
                2,
                false,
                new Book("1", "title", "author"));
        String id = "1";

        //WHEN
        when(sandwichRepo.updateSandwich(id, expected)).thenReturn(expected);
        Sandwich actual = sandwichService.updateSandwich(id, expected);

        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).updateSandwich(id, expected);
    }

    @Test
    void deleteSandwich_whenSandwichIdExist_thenDeleteSandwichByIdAndReturnDeletedSandwich() {
        //GIVEN
        Sandwich expected = new Sandwich(
                "1",
                "sandwichneu",
                Collections.emptyList(),
                2,
                false,
                new Book("1", "title", "author"));
        String id = "1";

        //WHEN
        when(sandwichRepo.deleteSandwich(id)).thenReturn(expected);
        Sandwich actual = sandwichService.deleteSandwich(id);

        //THEN
        assertEquals(expected, actual);
        verify(sandwichRepo).deleteSandwich(id);
    }
}