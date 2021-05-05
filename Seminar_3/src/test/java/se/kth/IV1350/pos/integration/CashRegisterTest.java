/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author charl
 */
public class CashRegisterTest {

    @Test
    public void testCountAmountInRegister() {
        CashRegister instance = new CashRegister();
        double expResult = 1000;
        double result = instance.countAmountInRegister();
        assertEquals(expResult, result, 0.0);
    }
   
}
