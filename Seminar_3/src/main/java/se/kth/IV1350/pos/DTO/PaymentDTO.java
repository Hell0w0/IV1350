package se.kth.IV1350.pos.DTO;

/**
 *
 * @author charl
 */
public class PaymentDTO {
    private double amountPaid;
    private String currency;
    
    public PaymentDTO(double amountPaid,String currency){
        this.amountPaid=amountPaid;
        this.currency=currency;
    }
    public double getAmountPaid(){
        return amountPaid;
    }
    public String getCurrency(){
        return currency;
    }
}
