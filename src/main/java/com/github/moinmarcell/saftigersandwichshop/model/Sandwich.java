package com.github.moinmarcell.saftigersandwichshop.model;

import java.util.List;

public record Sandwich(
        String id,
        String name,
        List<String> ingredients,
        int numberOfCheeseLayers,
        boolean bunIsGrilles,
        Book giftBook
) {

}
