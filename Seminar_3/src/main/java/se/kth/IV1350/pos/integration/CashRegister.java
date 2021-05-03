package se.kth.IV1350.pos.integration;

/**
 * CashRegister is a placeholder for an actual cash register, this class holds the current amount of money in the register.
 * @author charl
 */
public class CashRegister {
    private double amountInRegister;
    /**
     * When the class is created the constructer counts the current amount of money in the register.
     */
    public CashRegister(){
        this.amountInRegister = countAmountInRegister();
    }
    /**
     * The function counts the amount of money in the register.
     * @return the current amount of money in the register, this value is current hardcoded.
     */
    public double countAmountInRegister(){
        return 1000;
    } 
    /**
     * The funciton returns the current amount in the cash register.
     * @return the current amount in the register.
     */
    public double getAmountInRegister(){
        return amountInRegister;
    }
    /**
     * Updates the amount of money in the register with the amount the cusomter paid.
     * @param amountPaid  amount of money the customer paid
     */
    public void updateAmountInRegister(double amountPaid){
        amountInRegister += amountPaid;
    }
}
