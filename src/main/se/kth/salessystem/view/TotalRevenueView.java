package main.se.kth.salessystem.view;


/**
 * TotalRevenueView sends information to display about the current revenue
 */
public class TotalRevenueView extends TotalRevenue {
    private double totalPaid;
    public TotalRevenueView(){
        totalPaid = 0;
    }

    /**
     * Prints the new money to view.
     * @throws Exception never- this is one of the downsides of using Template
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("OBSERVER TOTALREVENUEVIEW UPDATE");
        System.out.println("TotalRevenue: " + totalRevenue);
    }

    /**
     * Should never happen. 
     * @param e
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("This shouldn't ever happen, but theres been some error to printing the ObserverView");

    }
}