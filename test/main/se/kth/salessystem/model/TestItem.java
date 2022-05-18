package main.se.kth.salessystem.model;

import main.se.kth.salessystem.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestItem {
    private Item item;

    @BeforeEach
    void setUp() { //setups ItemTests
        item = new Item(1, 24.5, 0.25, "\"tomat\"", 0);
    }

    @AfterEach
    void tearDown() {
        item = null;
    }

    @Test
    void toStringTest() {
        boolean expectedResult = true;
        boolean result = item.toString().contains("tomat");
        assertEquals(expectedResult, result, "toString se.kth.salessystem.test unsuccessful");
    }
}