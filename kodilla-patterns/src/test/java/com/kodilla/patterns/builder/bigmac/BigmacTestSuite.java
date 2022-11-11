package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigMacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(2)
                .bun(Bun.BUN_PLAIN)
                .addIngredient(Ingredient.ONION)
                .sauce(Sauce.SAUCE_BARBECUE)
                .addIngredient(Ingredient.CHEESE)
                .addIngredient(Ingredient.LETTUCE)
                .build();
        System.out.println(bigmac);

        //When
        Bun bun = bigmac.getBun();
        Sauce sauce = bigmac.getSauce();
        int burgers = bigmac.getBurgers();
        int numberIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(Bun.BUN_PLAIN, bun);
        assertEquals(Sauce.SAUCE_BARBECUE, sauce);
        assertEquals(2, burgers);
        assertEquals(3, numberIngredients);
    }
}
