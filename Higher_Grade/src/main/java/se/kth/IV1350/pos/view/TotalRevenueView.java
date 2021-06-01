/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.view;

import se.kth.IV1350.pos.model.SaleObserver;

/**
 * Prints out total revenue when a new sale is completed
 * @author charl
 */
class TotalRevenueView extends TotalRevenueDisplay {
    @Override
    protected void doShowTotalIncome(double totalRevenue) throws Exception {
        System.out.println("The total revenue since the program started is: " + totalRevenue);
        
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Could not display total revenue :(");
    }
}