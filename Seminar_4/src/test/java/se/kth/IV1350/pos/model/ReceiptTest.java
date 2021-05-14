/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

/**
 *
 * @author charl
 */
public class ReceiptTest {
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
      
    }
    
    @AfterEach
    public void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testSendReceiptToPrinter() {
        System.out.println("sendReceiptToPrinter");
        String printout = printoutBuffer.toString();
        
        Sale sale = new Sale();
        
        ItemDTO firstItem = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        ItemDTO secondItem = new ItemDTO("Sko",12,2,"Bra att ha på fötterna","2");
        sale.addItem(firstItem);
        sale.addItem(secondItem);
        
        SaleDTO saleDTO = new SaleDTO(sale);
        PaymentDTO paymentDTO = new PaymentDTO(100,"kr");
        Receipt instance = new Receipt(saleDTO,paymentDTO);
        
        String result = instance.sendReceiptToPrinter();
        String expectedOutput = "Receipt printed.";
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testGetReceiptSummary() {
        System.out.println("getReceiptSummary");
        Sale sale = new Sale();
        
        ItemDTO firstItem = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        ItemDTO secondItem = new ItemDTO("Sko",12,2,"Bra att ha på fötterna","2");
        sale.addItem(firstItem);
        sale.addItem(secondItem);
        
        SaleDTO saleDTO = new SaleDTO(sale);
        PaymentDTO paymentDTO = new PaymentDTO(100,"kr");
        Receipt instance = new Receipt(saleDTO,paymentDTO);
        
        String expResult = "ICA,Ringvägen 1, 666 42\nItems: \nRåttfälla 1 56.0 kr\nSko 1 2.0 kr\nTotal: 64.96 kr\nVAT: 6.96 kr\nAmount paid: 100 kr";
        String result = instance.getReceiptSummary();
        
        assertEquals(expResult, result);
    }

    
}
