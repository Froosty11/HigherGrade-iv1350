package main.se.kth.salessystem.view;

import main.se.kth.salessystem.controller.Controller;
import main.se.kth.salessystem.integration.TotalRevenueFileOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TotalRevenueViewTest {
    private TotalRevenueView toBeTested;
    private ByteArrayOutputStream buffer2BePrinted;

    /**
     * https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
     */
    @BeforeEach
    void setUp() {
        Controller temp = new Controller(new TotalRevenueFileOutput(), new TotalRevenueView());
        toBeTested = new TotalRevenueView();
        buffer2BePrinted = new ByteArrayOutputStream();
        System.setOut(new PrintStream( buffer2BePrinted));
    }

    /**
     * Tests showing income by buffer comparison
     */
    @Test
    void testDoShowTotalIncome() {
        toBeTested.newSaleWasMade(69);
        String whatWasJustPrinted = buffer2BePrinted.toString();

        assertTrue(whatWasJustPrinted.contains("TOTALREVENUEVIEW"), "totalRevenueVIew print doesn't print the proper values");


    }
}