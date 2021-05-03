
package se.kth.IV1350.pos.integration;

/**
 *The class is a placeholder for the external database for the inventory system.
 * This is currently hardcoded with values for each item.
 * @author charl
 */

import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

public class EISHandler {
    /**
     * A function that handles finding the item information that correspond to the items identifer.
     * @param identifier the scanned items identifier,
     * @return a object ItemDTO holding the information about the scanned item.
     */
    public ItemDTO findItem(String identifier){
        if(identifier.equals("1"))
            return new ItemDTO("Råttfälla",12,56,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
        else if(identifier.equals("2"))
            return new ItemDTO("Sko",12,2,"Bra att ha på fötter.","2");
        else
            return new ItemDTO("Pannkakor",12,8,"Gott att äta.","3");


    }
    /**
     * The function is a placeholder for when the system updates the inventory in the external system.
     * @param saleDTO an object SaleDTO holding the infromaiton about the current sale.
     */
    public void updateInventory(SaleDTO saleDTO){
        System.out.println("Items logged.");
    }
}
