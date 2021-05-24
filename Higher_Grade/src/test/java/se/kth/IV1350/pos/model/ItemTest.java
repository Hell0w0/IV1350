/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.pos.DTO.ItemDTO;

/**
 *
 * @author charl
 */
public class ItemTest {
    Item item;
    @BeforeEach
    public void setUp() {
        item = new Item(new ItemDTO("Name",12,10,"description","identifier"));
    }

    @AfterEach
    public void tearDown() {
        item = null;
    }
    @Test
    public void testIncreaseQuantity() {
        int startQuantity = item.getQuantity();
        item.raiseQuantity();
        assertEquals(startQuantity + 1, item.getQuantity(),"Increase quantity did not give expected output");
    }
    
}
