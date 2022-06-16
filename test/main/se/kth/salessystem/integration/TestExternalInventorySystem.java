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
    private Item item;
    private ExternalInventorySystem ext;

    /**
     * Setup to test EXT. Adds a bunch of items to it
     */
    @BeforeEach
    void setUp() {
        //beforeEach se.kth.salessystem.test is ran, we reset add some items to an inventory.
        ext = ExternalInventorySystem.getInstance();
        item = new Item(4, 6, 0.5, "banana", 4);
        ext.addItem(item);
        item = new Item(10, 16, 0.6, "Nocco pear", 5);
        ext.addItem(item);




    }

    @AfterEach
    void tearDown() {
        //should null here, but GC can handle it lol


    }

    /**
     * Tests if instock is correct, we know some stuff is in stock, so its easy.
     */
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

    /**
     * Tests adding item. We're using instock, since thats tested.
     */

    @Test
    void testAddItem() {
        //this is fine- since we've tested it previously
        assertTrue(ext.inStock(5), "Nocco pear is in stock");
    }
}