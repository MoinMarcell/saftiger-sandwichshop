package com.github.moinmarcell.saftigersandwichshop.controller;

import com.github.moinmarcell.saftigersandwichshop.model.Sandwich;
import com.github.moinmarcell.saftigersandwichshop.service.SandwichService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SandwichController {
    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/sandwiches")
    List<Sandwich> getAllSandwiches(){
        return sandwichService.getAllSandwiches();
    }

    @GetMapping("/sandwiches/{id}")
    Sandwich getSandwichById(@PathVariable String id){
        return sandwichService.getSandwichById(id);
    }

    @PostMapping("/sandwiches")
    Sandwich saveSandwich(@RequestBody Sandwich sandwich){
        return sandwichService.saveSandwich(sandwich);
    }

    @PutMapping("/sandwiches/{id}")
    Sandwich updateSandwich(@PathVariable String id, @RequestBody Sandwich sandwich){
        return sandwichService.updateSandwich(id, sandwich);
    }

    @DeleteMapping("/sandwiches/{id}")
    Sandwich deleteSandwich(@PathVariable String id){
        return sandwichService.deleteSandwich(id);
    }

}
