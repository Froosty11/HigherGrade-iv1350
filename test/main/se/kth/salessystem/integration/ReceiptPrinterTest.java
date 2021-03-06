package main.se.kth.salessystem.integration;

import main.se.kth.salessystem.controller.Controller;
import main.se.kth.salessystem.dtos.SaleDTO;
import main.se.kth.salessystem.dtos.StoreDTO;
import main.se.kth.salessystem.model.Item;
import main.se.kth.salessystem.model.Receipt;
import main.se.kth.salessystem.view.TotalRevenueView;
import main.se.kth.salessystem.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptPrinterTest {
    ReceiptPrinter rPrinter;
    PrintStream printSysOut;
    ByteArrayOutputStream buffer2BePrinted;

    /**
     * Same setup we do for all printtests, setups a buffer, and changes out to our printstream
     */
    @BeforeEach
    void setUp() {
        Controller temp = new Controller(new TotalRevenueFileOutput(), new TotalRevenueView());
        rPrinter = new ReceiptPrinter();
        buffer2BePrinted = new ByteArrayOutputStream();
        printSysOut = System.out;
        System.setOut(new PrintStream(buffer2BePrinted));
    }
    @AfterEach
    void tearDown(){
        System.setOut(printSysOut);
    }

    /**
     * Tests that the receipt contains the correct information- we're simlpy doing this by the price
     * and checking that the price is correct. Should be changed to more thorough.
     */
    @Test
    void testPrintReceipt() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, 1, 1, "Awooga", 1));

        SaleDTO saleDTO = new SaleDTO(69420, 0.25, list, "dsa", 2);
        Receipt r = new Receipt(saleDTO, new StoreDTO("Edvin", "Awooga 2", "30123"), 294);
        rPrinter.PrintReceipt(r);
        String whatWasJustPrinted = buffer2BePrinted.toString();
        assertTrue(whatWasJustPrinted.contains("69420"), "ReceiptPrinter is not printing proper string saved");


    }
}