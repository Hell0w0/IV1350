
package se.kth.IV1350.pos.integration;

/**
 *
 * @author charl
 */

import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

public class EISHandler {
    public ItemDTO findItem(String identifer){
        return new ItemDTO("Råttfälla",12.5,56.5,"Hjälper dig att fånga råttor eller nypa dina kompisar i tårna.","1");
    }
    public void updateInventory(SaleDTO saleDTO){
        System.out.println("Items logged.");
    }
}
