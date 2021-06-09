/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.pos.DTO.ItemDTO;

/**
 *
 * @author charl
 */
public class ItemTest {

    @Test
    public void testRaiseQuantity() {
        ItemDTO item = new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        Item instance = new Item(item);
        instance.raiseQuantity();
        int result = instance.getQuantity();
        int expectedOutput = 2;
        assertEquals(expectedOutput, result);    }
    
}
