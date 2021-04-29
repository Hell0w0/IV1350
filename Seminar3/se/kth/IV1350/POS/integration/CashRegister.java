/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.seminar_3.integration;

/**
 *
 * @author charl
 */
public class CashRegister {
    private double amount;
    public CashRegister(){
        this.amount = countAmountInRegister();
    }
    public double countAmountInRegister(){
        return 1000;
    }
    public double getAmountInRegister(){
        return amount;
    }
}
