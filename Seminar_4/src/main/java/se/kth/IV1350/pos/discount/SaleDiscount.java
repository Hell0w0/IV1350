/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.discount;

import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

/**
 *
 * @author charl
 */
public class SaleDiscount implements DiscountFinder{

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
