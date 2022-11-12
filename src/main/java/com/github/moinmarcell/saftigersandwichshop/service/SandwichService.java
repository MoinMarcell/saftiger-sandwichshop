package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import com.github.moinmarcell.saftigersandwichshop.repository.SandwichRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SandwichService {

    private final SandwichRepo sandwichRepo;
    private final IdService idService;
    private final BookService bookService;

    public SandwichService(SandwichRepo sandwichRepo, IdService idService, BookService bookService) {
        this.sandwichRepo = sandwichRepo;
        this.idService = idService;
        this.bookService = bookService;
    }

    public List<Sandwich> getAllSandwiches(){
        return sandwichRepo.getAllSandwiches();
    }

    public Sandwich getSandwichById(String id){
        return sandwichRepo.getSandwichById(id);
    }

    public Sandwich saveSandwich(Sandwich sandwich){
        return sandwichRepo
                .saveSandwich(new Sandwich(
                idService.generateId(),
                sandwich.name(),
                sandwich.ingredients(),
                sandwich.numberOfCheeseLayers(),
                sandwich.bunIsGrilles(),
                bookService.getRandomBook()));
    }

    public Sandwich updateSandwich(String id, Sandwich sandwich){
        return sandwichRepo.updateSandwich(id, sandwich);
    }

    public Sandwich deleteSandwich(String id){
        return sandwichRepo.deleteSandwich(id);
    }
}
