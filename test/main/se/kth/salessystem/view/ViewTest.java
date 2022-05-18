package main.se.kth.salessystem.view;

import main.se.kth.salessystem.controller.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View toBeTested;
    private PrintStream printStreamOut;
    private ByteArrayOutputStream buffer2BePrinted;

    @BeforeEach
    void setUp() {
        Controller temp = new Controller();
        toBeTested = new View(temp);

        buffer2BePrinted = new ByteArrayOutputStream();
        PrintStream toBeOuted = new PrintStream(buffer2BePrinted);
        printStreamOut = System.out;
        System.setOut(toBeOuted);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testView(){
        toBeTested.hardCodedControllerCalls();
        String whatWasJustPrinted = buffer2BePrinted.toString();

        assertTrue(whatWasJustPrinted.contains("Change: 103.75"), "testView print doesn't print the proper values");

    }
}