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
    @BeforeEach
    void setUp() {
        Controller temp = new Controller(new TotalRevenueFileOutput(), new TotalRevenueView());
        toBeTested = new TotalRevenueView();
        buffer2BePrinted = new ByteArrayOutputStream();
        PrintStream toBeOuted = new PrintStream(buffer2BePrinted);
        System.setOut(toBeOuted);
    }

    @Test
    void testDoShowTotalIncome() {
        toBeTested.newSaleWasMade(69);
        String whatWasJustPrinted = buffer2BePrinted.toString();

        assertTrue(whatWasJustPrinted.contains("TOTALREVENUEVIEW"), "totalRevenueVIew print doesn't print the proper values");


    }
}