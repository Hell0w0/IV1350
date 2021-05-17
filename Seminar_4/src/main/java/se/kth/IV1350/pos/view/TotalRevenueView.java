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
public class TotalRevenueView implements SaleObserver {
    private double totalRevenue;
    
    TotalRevenueView(){
        totalRevenue=0;
    }
    
    
    public void newSale(double priceOfPurchase){
        totalRevenue+=priceOfPurchase;
        System.out.println("The total revenue since the program started is: " + totalRevenue);

    }
    
}