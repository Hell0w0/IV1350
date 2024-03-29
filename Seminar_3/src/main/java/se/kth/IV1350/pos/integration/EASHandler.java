
package se.kth.IV1350.pos.integration;

import se.kth.IV1350.pos.DTO.PaymentDTO;

/**
 * The class is a placeholder for the external database for the accounting.
 * @author charl
 */
public class EASHandler {
    /**
     * The function registers the latest payment made into the database.
     * @param paymentDTO a object holding a collection of data about the latest payment.
     */
    public void registerPayment(PaymentDTO paymentDTO){
        System.out.println("Payment logged");
    }
}
