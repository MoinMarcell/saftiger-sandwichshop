package com.github.moinmarcell.saftigersandwichshop.controller;

import com.github.moinmarcell.saftigersandwichshop.model.Book;
import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SandwichControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DirtiesContext
    void getAllSandwiches_whenSandwichesListIsNotEmpty_thenReturnListOfSandwiches() throws Exception {
        mvc.perform(get("/api/sandwiches"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    void getSandwichById_whenIdExist_thenReturnSandwichById() throws Exception{
        Sandwich sandwichExpected = new Sandwich(
                "1",
                "sandwichneu",
                Collections.emptyList(),
                2,
                false,
                new Book("1", "title", "author"));

        mvc.perform(get("/api/sandwiches/" + sandwichExpected.id()))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                {
                                    "id": "1",
                                    "name": "sandwichneu",
                                    "ingredients": [],
                                    "numberOfCheeseLayers": 2,
                                    "bunIsGrilled": false,
                                    "giftBook": {
                                        "id": "1",
                                        "title": "title",
                                        "author": "author"
                                    }
                                }
                                """
                ));
    }

    @Test
    void saveSandwich() {
    }

    @Test
    void updateSandwich() {
    }

    @Test
    void deleteSandwich() {
    }
}