package com.github.moinmarcell.saftigersandwichshop.repository;

import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepo {
    private final List<Sandwich> sandwiches;

    public SandwichRepo() {
        sandwiches = new ArrayList<>();
    }

    public List<Sandwich> getAllSandwiches() {
        return sandwiches;
    }

    public Sandwich getSandwichById(String id){
        for (Sandwich s : sandwiches){
            if(s.id().equals(id)){
                return s;
            }
        }
        return null;
    }

    public Sandwich saveSandwich(Sandwich sandwich){
        for(Sandwich s : sandwiches){
            if(s.id().equals(sandwich.id())){
                return s;
            }
        }
        sandwiches.add(sandwich);
        return sandwich;
    }

    public Sandwich updateSandwich(String id, Sandwich sandwich){
        Sandwich toSave = new Sandwich(id, sandwich.name(), sandwich.ingredients(), sandwich.numberOfCheeseLayers(), sandwich.bunIsGrilled(), sandwich.giftBook());
        sandwiches.remove(getSandwichById(id));
        sandwiches.add(toSave);
        return toSave;
    }

    public Sandwich deleteSandwich(String id){
        Sandwich copy = getSandwichById(id);
        sandwiches.remove(getSandwichById(id));
        return copy;
    }
}
