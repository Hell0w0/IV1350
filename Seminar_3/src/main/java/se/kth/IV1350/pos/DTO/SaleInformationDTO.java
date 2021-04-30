
package se.kth.IV1350.pos.DTO;

import se.kth.IV1350.pos.model.Item;

/**
 *
 * @author charl
 */
public class SaleInformationDTO {
    private String currentItemDescription;
    private double currentItemPrice;
    private String currentItemName;
    private double runningTotal;

    public SaleInformationDTO(ItemDTO addedItem,double runningTotal){
        this.currentItemDescription = addedItem.getDescription();
        this.currentItemPrice = addedItem.getPrice();
        this.currentItemName = addedItem.getName();
        this.runningTotal = runningTotal;
    }
    public String getCurrentItemName(){
        return currentItemName;
    }
    public String getCurrentItemDescription(){
        return currentItemDescription;
    }
    public double getCurrentItemPrice(){
        return currentItemPrice;
    }
    public double getRunningTotal(){
        return runningTotal;
    }    
}
