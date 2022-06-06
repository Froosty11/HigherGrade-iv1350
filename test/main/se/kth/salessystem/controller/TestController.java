package main.se.kth.salessystem.controller;


import main.se.kth.salessystem.controller.Controller;
import main.se.kth.salessystem.integration.DatabaseNotFoundException;
import main.se.kth.salessystem.integration.ItemNotFoundException;
import main.se.kth.salessystem.integration.TotalRevenueFileOutput;
import main.se.kth.salessystem.view.TotalRevenueView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * So, I do know that it is not perfectly ok to do testing with the string- but to compare two sales
 * in our current state would require us to addItems to both sales- which wouldn't make a difference since they're both
 * running the exact same code. We'd have to implement a makeSaleFromTxt or hardcode it.
 *
 *
 */
class TestController {
    Controller controll1;
    String string;

    /**
     * Before each se.kth.salessystem.test- setups some basic controller
     */
    @BeforeEach
    void setUp() {
        controll1 = new Controller(new TotalRevenueFileOutput(), new TotalRevenueView());
        controll1.startNewSale(1);

    }

    @AfterEach
    void tearDown() {
        controll1 = null;
        string = null;
    }

    /**
     * tests starting a new sale.
     *
     */
    @Test
    void testStartNewSale() throws DatabaseNotFoundException, ItemNotFoundException {
        controll1.startNewSale(1);
        controll1.addItem(1);
        boolean result = controll1.endSale(10000, "TEST", "TEST");
        assertTrue(result, "startNewSale controller error");
    }

    /**
     * Tests adding one item.
     * @throws DatabaseNotFoundException if the item requested is 6
     * @throws ItemNotFoundException if the item is not an item in txt
     */
    @Test
    void testAddItem() throws DatabaseNotFoundException, ItemNotFoundException {
        boolean result = false;
            controll1.addItem(0);
        if (controll1.getString().equals("1x Tomat, Ekologisk -  24.5kr\n")) {
            result = true;
        }
        assertTrue(result, "Controller.addItem is failing se.kth.salessystem.test.");

    }

    /**
     * Tests ending the sale, making sure the controller returns empty sale string.
     */
    @Test
    void testEndSale() {
        boolean result = false;
        controll1.endSale(20, "Edvin", "fortnite");
        if (controll1.getString() == null || controll1.getString() == "") {
            result = true;
        }
        assertTrue(result, "Controller.endSale failed junit se.kth.salessystem.test");
    }

    /**
     * Checks if the sale is empty now after termination.
     */
    @Test
    void testTerminate() {
        boolean result = false;
        controll1.terminate();
        if (controll1.getString() == null) {
            result = true;
        }
        assertTrue(result, "Controller.terminate failed junit se.kth.salessystem.test");
    }

    /**
     * Tests adding multiple items.
     * @throws DatabaseNotFoundException If the item id is 6 or if the database is lost.
     * @throws ItemNotFoundException If the itemID is incorrect.
     */
    @Test
    void testAddItems() throws DatabaseNotFoundException, ItemNotFoundException {
        boolean result = false;
        controll1.addItem(0, 2);
        if (controll1.getString().equals("2x Tomat, Ekologisk -  24.5kr\n")) {
            result = true;
        }
        assertTrue(result, "Controller.addItems is failing se.kth.salessystem.test.");

    }

    /**
     * Checks if undo works by adding item, undoing it and then comparing it to an empty shopping cart.
     *
     */
    @Test
    void testUndo() throws DatabaseNotFoundException, ItemNotFoundException {
        boolean isCorrect = false;
        controll1.addItem(1);
        controll1.undo();
        if(controll1.getString().equals("")) isCorrect = true;
        assertTrue(isCorrect, "Error! Undo not reseting shopping cart to 0");
    }

    /**
     *Tests undoing multiple adds.
     */
    @Test
    void testUndos() throws DatabaseNotFoundException, ItemNotFoundException {
        boolean isCorrect  = false;
        controll1.addItem(1, 2);
        controll1.addItem(2, 2);
        controll1.undo(2);
        if(controll1.getString().equals("")) isCorrect = true;
        assertTrue(isCorrect, "Undo not undoing multiple actions properly");


    }


}