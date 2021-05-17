
package se.kth.IV1350.pos.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.discount.DiscountFinder;

/**
 *The class is a placeholder for the external database for the inventory system.
 * This is currently hardcoded with values for each item.
 * @author charl
 */

public class DCHandler {
    
    ArrayList<DiscountDTO> discounts = new ArrayList<DiscountDTO>();

    public DCHandler(){
        discounts.add(new DiscountDTO(1-0.5,"2"));
        discounts.add(new DiscountDTO(20,56));
    }
    public List<DiscountDTO> findDiscounts(SaleDTO sale, DiscountFinder finder){
       return finder.findDiscount(sale,discounts); 
    } 

    
}
