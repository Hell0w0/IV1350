/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;

/**
 *
 * @author charl
 */
public class SaleTest {
    @Test
    public void testAddItem() {
        ItemDTO itemDTO = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        Sale instance = new Sale();
        String expResult = "Råttfälla";
        String result = instance.addItem(itemDTO).getCurrentItemName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDuplicateItem() {
        ItemDTO itemDTO = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        Sale instance = new Sale();
        int expResult = 2;
        instance.addItem(itemDTO);
        int result = instance.addItem(itemDTO).getCurrentItemQuantity();
        assertEquals(expResult, result);
    }
    @Test
    public void testTotalPriceWithOneItemAdded() {
        ItemDTO itemDTO = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        Sale instance = new Sale();
        String identifier = "1";
        double totalPrice = instance.addItem(itemDTO).getRunningTotal();
        assertEquals(62.72, totalPrice,"Calculate totalPrice is not working");
    } 

    @Test
    public void testTotalPriceWithTwoItemsAdded() {
        ItemDTO firstItem = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        ItemDTO secondItem = new ItemDTO("Sko",12,2,"Bra att ha på fötterna","2");
        Sale instance = new Sale();
        instance.addItem(firstItem);
        double totalPrice = instance.addItem(secondItem).getRunningTotal();
        assertEquals(64.96, totalPrice,"Calculate totalPrice is not working");
    } 
    
    @Test
    public void testPrintReceipt() {
        Sale instance = new Sale();
        
        ItemDTO firstItem = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        ItemDTO secondItem = new ItemDTO("Sko",12,2,"Bra att ha på fötterna","2");
        instance.addItem(firstItem);
        instance.addItem(secondItem);
        
        PaymentDTO paymentDTO = new PaymentDTO(100,"kr");
        
        String expResult = "ICA,Ringvägen 1, 666 42\nItems: \nRåttfälla 1 56.0 kr\nSko 1 2.0 kr\nTotal: 64.96 kr\nVAT: 6.96 kr\nAmount paid: 100 kr";
        String result = instance.printReceipt(paymentDTO);
        
        assertEquals(expResult, result);
    }

}