
package se.kth.IV1350.pos.discount;

import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

/**
 *Find the discounts that applies to the requierments the total price of the sale
 * @author charl
 */
public class SaleDiscount implements DiscountFinder{
    /**
     * 
     * @param saleDTO information about the sale
     * @param availableDiscounts list of all avalible discounts
     * @return the discounts that applies tot he current sale
     */
    @Override
    public List<DiscountDTO> findDiscount(SaleDTO saleDTO, List<DiscountDTO> availableDiscounts) {

        List<DiscountDTO> foundDiscounts = new ArrayList<>();
        for(DiscountDTO discount:availableDiscounts){
            if(discount.getType().equals("sale")){ 
                continue;
            }
            if(saleDTO.getTotalPrice()>= discount.getMinRequiered()){
                foundDiscounts.add(discount);
            }                      
        }
        return foundDiscounts;
    }
    
}
