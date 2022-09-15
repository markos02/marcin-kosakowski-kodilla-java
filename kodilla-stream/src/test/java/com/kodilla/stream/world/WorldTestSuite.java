package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent();
        Continent africa = new Continent();
        Continent asia = new Continent();
        Continent northAmerica = new Continent();

        europe.addCountry(new Country("Czechy", new BigDecimal("10705384")));
        europe.addCountry(new Country("Francja", new BigDecimal("68305148")));
        europe.addCountry(new Country("Hiszpania", new BigDecimal("47163418")));
        europe.addCountry(new Country("Islandia", new BigDecimal("357603")));
        europe.addCountry(new Country("Wielka Brytania", new BigDecimal("67791400")));

        africa.addCountry(new Country("Nigeria", new BigDecimal("225082083")));
        africa.addCountry(new Country("Egipt", new BigDecimal("107770524")));
        africa.addCountry(new Country("Uganda", new BigDecimal("46205893")));
        africa.addCountry(new Country("Burkina Faso", new BigDecimal("21935389")));

        asia.addCountry(new Country("Chiny", new BigDecimal("1410539758")));
        asia.addCountry(new Country("Indie", new BigDecimal("1389637446")));
        asia.addCountry(new Country("Pakistan", new BigDecimal("242923845")));
        asia.addCountry(new Country("Tajlandia", new BigDecimal("69648117")));
        asia.addCountry(new Country("Syria", new BigDecimal("21563800")));
        asia.addCountry(new Country("Kuwejt", new BigDecimal("3068155")));

        northAmerica.addCountry(new Country("Stany Zjednoczone", new BigDecimal("337341954")));
        northAmerica.addCountry(new Country("Meksyk", new BigDecimal("129150971")));
        northAmerica.addCountry(new Country("Kanada", new BigDecimal("38232593")));

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("4237423481");
        assertEquals(expectedResult, result);

    }
}
