package se.kth.IV1350.seminar_3.model;

import java.time.LocalTime;

/**
 * One single sale made by one singular customer, payed with one payment.
 * @author charl
 */
public class Sale {
    
    private LocalTime saleTime;
    
    public Sale(){
        saleTime = LocalTime.now();
    }
}
