package main.se.kth.salessystem.view;

import main.se.kth.salessystem.model.Observer;

public abstract class TotalRevenue implements Observer {
    protected double totalRevenue;
    protected TotalRevenue () {
        totalRevenue = 0;
    }


    /**
     * Updates an observer with an amount of money.
     * @param priceOfTheSaleThatWasJustMade the amount paid to update the observer
     */
    @Override
    public void newSaleWasMade(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome ( priceOfTheSaleThatWasJustMade );
        showTotalIncome ();
    }

    /**
     * Template function with all other functions run in same order- same exception handling too.
     */
    private void showTotalIncome () {
        try {
            doShowTotalIncome ();
        } catch ( Exception e ) {
            handleErrors ( e );
        }
    }

    /**
     * Abstract function to be overwridden
     * @throws Exception
     */
    protected abstract void doShowTotalIncome () throws Exception ;
    /**
     * Abstract function to be overwridden
     * @throws Exception
     */
    protected abstract void handleErrors ( Exception e );

    /**
     * Simply just adds money to the Observer.
     * @param moneyToAdd
     */
    private void calculateTotalIncome(double moneyToAdd){
        totalRevenue += moneyToAdd;
    }
}