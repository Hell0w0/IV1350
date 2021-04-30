/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.integration;

import se.kth.IV1350.pos.DTO.PaymentDTO;

/**
 *
 * @author charl
 */
public class EASHandler {
    public void registerPayment(PaymentDTO paymentDTO){
        System.out.println("Payment logged");
    }
}
