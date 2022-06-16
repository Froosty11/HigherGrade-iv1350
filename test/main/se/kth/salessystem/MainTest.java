package main.se.kth.salessystem;

import main.se.kth.salessystem.controller.Controller;
import main.se.kth.salessystem.integration.ReceiptPrinter;
import main.se.kth.salessystem.integration.TotalRevenueFileOutput;
import main.se.kth.salessystem.view.TotalRevenueView;
import main.se.kth.salessystem.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    PrintStream printSysOut;
    ByteArrayOutputStream buffer2BePrinted;
    @BeforeEach
    void setUp() {
        printSysOut = System.out;
        buffer2BePrinted = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer2BePrinted));
    }

    @AfterEach
    void tearDown() {
        System.setOut(printSysOut);
    }

    @Test
    void testMain() {
        Main.main(null);
        String whatWasJustPrinted = buffer2BePrinted.toString();

        assertTrue(whatWasJustPrinted.contains("Change: 103.75"), "testMain print doesn't print the proper values");

    }
}