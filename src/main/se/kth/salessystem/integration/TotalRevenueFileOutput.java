package main.se.kth.salessystem.integration;

import main.se.kth.salessystem.model.Observer;
import main.se.kth.salessystem.view.TotalRevenue;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Observer that observes a sale and prints information after each sale to make sure the proper amount of money is correct
 * Stores/prints to a txt file. Txt file gets wiped upon restart of program- in theory the file would be
 * backuped after each workday
 */
public class TotalRevenueFileOutput extends TotalRevenue{
        private
        FileWriter logger;
        String fileLoc = "";
        String errorLoc = "";
        public TotalRevenueFileOutput(){
            fileLoc = "src/main/se/kth/salessystem/integration/totalRevenue.txt";
            try{
                logger = new FileWriter(fileLoc);
            }
            catch (
                    IOException exception
            ){
                exception.printStackTrace();
            }
        }

    @Override
    protected void doShowTotalIncome() throws Exception {
        logger = new FileWriter(fileLoc, false);
        logger.write("TOTAL REVENUE: " + totalRevenue);
        logger.close();
    }
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("Error when handling errors for FileOutput");
        e.printStackTrace();

    }
}
