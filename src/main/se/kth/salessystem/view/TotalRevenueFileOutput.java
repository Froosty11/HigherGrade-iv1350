package main.se.kth.salessystem.view;

import main.se.kth.salessystem.model.Observer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Observer that observes a sale and prints information after each sale to make sure the proper amount of money is correct
 */
class TotalRevenueFileOutput extends TotalRevenue{
    private FileWriter logger;
    String fileLoc = "";
    String errorLoc = "";
    TotalRevenueFileOutput(){
        fileLoc = "src/main/se/kth/salessystem/model/totalRevenue.txt";
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