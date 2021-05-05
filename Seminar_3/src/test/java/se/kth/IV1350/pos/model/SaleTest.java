/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;

/**
 *
 * @author charl
 */
public class SaleTest {
    
    public SaleTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemDTO itemDTO = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        Sale instance = new Sale();
        String expResult = "Råttfälla";
        String result = instance.addItem(itemDTO).getCurrentItemName();
        assertEquals(expResult, result);
    }
}