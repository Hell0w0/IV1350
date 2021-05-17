
package se.kth.IV1350.pos.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.discount.DiscountFinder;

/**
 *The class is a placeholder for the external database for the Discount handler.
 * This is currently hardcoded with values for each discounted situation.
 * @author charl
 */

public class DCHandler {
    
    ArrayList<DiscountDTO> discounts = new ArrayList<DiscountDTO>();

    /**
     * Adds discounts when program is run
     */
    public DCHandler(){
        discounts.add(new DiscountDTO(1-0.5,"2"));
        discounts.add(new DiscountDTO(20,56));
    }
    
    
    /**
     * Finds discounts
     * @param sale Object holding information regarding the sale
     * @param finder finder method that is used
     * @return 
     */
    
    public List<DiscountDTO> findDiscounts(SaleDTO sale, DiscountFinder finder){
       return finder.findDiscount(sale,discounts); 
    } 

    
}
