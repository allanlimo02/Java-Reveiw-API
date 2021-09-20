package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodtypeTest {

    @Test
    void getName() {
        Foodtype food = new Foodtype("Brochettes");
        assertEquals("Brochettes",food.getName());
    }

    @Test
    void setName() {
        Foodtype food = new Foodtype("Brochettes");
        assertNotEquals("Ugali",food.getName());
    }


}