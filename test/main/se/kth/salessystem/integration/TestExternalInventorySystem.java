package main.se.kth.salessystem.integration;

import main.se.kth.salessystem.integration.DatabaseNotFoundException;
import main.se.kth.salessystem.integration.ExternalInventorySystem;
import main.se.kth.salessystem.integration.ItemNotFoundException;
import main.se.kth.salessystem.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestExternalInventorySystem {
    private PrintStream printStreamOut;
    private ByteArrayOutputStream buffer2BePrinted;
    private Item item;
    private ExternalInventorySystem ext;


    @BeforeEach
    void setUp() {
        //beforeEach se.kth.salessystem.test is ran, we reset add some items to an inventory.
        ext = ExternalInventorySystem.getInstance();
        item = new Item(4, 6, 0.5, "banana", 4);
        ext.addItem(item);
        item = new Item(10, 16, 0.6, "Nocco pear", 5);
        ext.addItem(item);

        //for prints
        buffer2BePrinted = new ByteArrayOutputStream();
        PrintStream toBeOuted = new PrintStream(buffer2BePrinted);
        printStreamOut = System.out;
        System.setOut(toBeOuted);


    }

    @AfterEach
    void tearDown() {
        //should null here, but GC can handle it lol


    }

    @Test
    void testInStock() {
        boolean inList = false;
        for(int i = 0; i < ext.getLength() ; i++){ // checks all items.
            try{
                if(ext.getItem(i).toString().equals(item.toString())) inList = true;
            }
            catch (DatabaseNotFoundException e){
                e.printStackTrace();
            }
            catch (ItemNotFoundException itemNotFoundException){
                itemNotFoundException.getMessage();
            }
        }

        assertTrue(inList, "banana not in stock");
    }


    @Test
    void testAddItem() {
        //this is fine- since we've tested it previously
        assertTrue(ext.inStock(5), "Nocco pear is in stock");
    }
}