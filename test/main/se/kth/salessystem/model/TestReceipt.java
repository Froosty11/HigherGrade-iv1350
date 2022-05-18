package main.se.kth.salessystem.model;

import main.se.kth.salessystem.dtos.SaleDTO;
import main.se.kth.salessystem.dtos.StoreDTO;
import main.se.kth.salessystem.integration.ExternalInventorySystem;
import main.se.kth.salessystem.model.Item;
import main.se.kth.salessystem.model.Receipt;
import main.se.kth.salessystem.model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestReceipt {
    private ExternalInventorySystem ext;
    private Receipt rec;

    @BeforeEach
    void setUp() { // sets up a string equal to a DTO
        ext = ExternalInventorySystem.getInstance();
        Item chips = new Item(6, 15.0, 0.25, "chips", 3);
        ext.addItem(chips);
        Sale sale = new Sale();
        sale.addItem(chips, ext);
        SaleDTO temp = sale.endSale("Edvin", "Butik");
        rec = new Receipt(temp, new StoreDTO("Ica Nära", "Björkvägen 2", "037417"),2000);

    }

    @AfterEach
    void tearDown() {
        rec = null;
    }

    @Test
    void receiptToStringTest() { //compares string to dto output
        boolean expectedResult = true;
        String st2 = rec.toString();
        boolean result = st2.contains("Ica Nära");
        assertEquals(expectedResult, result, "Receipt does not match expected output. ");
    }
}