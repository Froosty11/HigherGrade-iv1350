package main.se.kth.salessystem.view;

import main.se.kth.salessystem.controller.Controller;
import main.se.kth.salessystem.integration.TotalRevenueFileOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View toBeTested;
    private PrintStream printSysOut;
    private ByteArrayOutputStream buffer2BePrinted;

    @BeforeEach
    void setUp() {
        Controller temp = new Controller(new TotalRevenueFileOutput(), new TotalRevenueView());
        toBeTested = new View(temp);
        buffer2BePrinted = new ByteArrayOutputStream();
        printSysOut = System.out;
        System.setOut(new PrintStream(buffer2BePrinted));
    }

    @AfterEach
    void tearDown() {
        System.setOut(printSysOut);

    }

    /**
     * Tests view with comparison of a buffer.
     */
    @Test
    public void testView(){
        toBeTested.hardCodedControllerCalls();
        String whatWasJustPrinted = buffer2BePrinted.toString();

        assertTrue(whatWasJustPrinted.contains("Change: 103.75"), "testView print doesn't print the proper values");

    }
}