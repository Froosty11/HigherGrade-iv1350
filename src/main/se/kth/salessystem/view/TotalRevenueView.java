package main.se.kth.salessystem.view;


/**
 * TotalRevenueView sends information to display about the current revenue
 */
class TotalRevenueView extends TotalRevenue {
    private double totalPaid;
    public TotalRevenueView(){
        totalPaid = 0;
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("OBSERVER TOTALREVENUEVIEW UPDATE");
        System.out.println("TotalRevenue: " + totalRevenue);
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println("This shouldn't ever happen, but theres been some error to printing the ObserverView");

    }
}