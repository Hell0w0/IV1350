
package se.kth.IV1350.pos.discount;

import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.model.Item;

/**
 *
 * @author charl
 */
public class ItemDiscount implements DiscountFinder{

    @Override
    public List<DiscountDTO> findDiscount(SaleDTO saleDTO, List<DiscountDTO> availableDiscounts) {

        List<DiscountDTO> foundDiscounts = new ArrayList<DiscountDTO>();
        for(DiscountDTO discount:availableDiscounts){
            for(Item item : saleDTO.getItems()){
                if(discount.getType().equals("item"))
                    continue;
                if(item.getItemIdentifier().equals(discount.getIdOfDiscountedItem())){
                    foundDiscounts.add(discount);
                }                    
            } 
            
        }
        return foundDiscounts;
    }
}    

