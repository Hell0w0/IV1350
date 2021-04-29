package se.kth.IV1350.seminar_3.model;

import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;
import se.kth.IV1350.pos.model.Item;

/**
 * One single sale made by one singular customer, payed with one payment.
 * @author charl
 */
public class Sale {
    private LocalTime saleTime;
    ArrayList <Item> items; 
    private double totalPrice;
    private double totalVAT;
    
    private Item addedItem;
    
    public Sale(){
        saleTime = LocalTime.now();
        items = new ArrayList<Item>();
    }
    
        public boolean checkForDuplicateItem(ItemDTO itemDTO){
            for(Item item:items){
                if(item.getItemIdentifier().equals(itemDTO.getItemIdentifier())){
                    return true;
                }
            }
            return false;
        }
    
    private void calculateRunningTotal(){
        double price = 0;
        double VAT = 0;
        for (Item item:items){
            price+=item.getPrice()*item.getQuantity();
            VAT+=item.getVATAmount()*item.getQuantity();
        }
        totalVAT = VAT;
        totalPrice=price+VAT;
    }
    public SaleInformationDTO addItem(ItemDTO itemDTO){
        if(!checkForDuplicateItem(itemDTO)){
            addedItem = new Item(itemDTO);
            items.add(addedItem);
        }
        else{
            for(Item item:items){
                if (item.getItemIdentifier().equals(itemDTO.getItemIdentifier())){
                    addedItem = item;
                }
            }
        }
        calculateRunningTotal();
        return new SaleInformationDTO(addedItem, totalPrice);
    }
}
