package main.se.kth.salessystem.view;

import main.se.kth.salessystem.model.Observer;

public abstract class TotalRevenue implements Observer {
    protected double totalRevenue;
    protected TotalRevenue () {
        totalRevenue = 0;
    }


    /**
     * Template method constructor- irrelevant except for super.
     * @param priceOfTheSaleThatWasJustMade
     */
    @Override
    public void newSaleWasMade(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome ( priceOfTheSaleThatWasJustMade );
        showTotalIncome ();
    }
    private void showTotalIncome () {
        try {
            doShowTotalIncome ();
        } catch ( Exception e ) {
            handleErrors ( e );
        }
    }

    protected abstract void doShowTotalIncome () throws Exception ;

    protected abstract void handleErrors ( Exception e );

    private void calculateTotalIncome(double moneyToAdd){
        totalRevenue += moneyToAdd;
    }
}