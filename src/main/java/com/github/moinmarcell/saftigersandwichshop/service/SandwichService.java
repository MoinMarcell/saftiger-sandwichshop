package com.github.moinmarcell.saftigersandwichshop.service;

import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import com.github.moinmarcell.saftigersandwichshop.repository.SandwichRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SandwichService {

    private final SandwichRepo sandwichRepo;
    private final IdService idService;

    public SandwichService(SandwichRepo sandwichRepo, IdService idService) {
        this.sandwichRepo = sandwichRepo;
        this.idService = idService;
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
                sandwich.bunIsGrilles()));
    }

    public Sandwich updateSandwich(String id, Sandwich sandwich){
        return sandwichRepo.updateSandwich(id, sandwich);
    }

    public Sandwich deleteSandwich(String id){
        return sandwichRepo.deleteSandwich(id);
    }
}
