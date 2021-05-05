package se.kth.IV1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.IV1350.pos.DTO.ItemDTO;
import se.kth.IV1350.pos.DTO.PaymentDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;
import se.kth.IV1350.pos.DTO.SaleInformationDTO;

/**
 * One single sale made by one singular customer, payed with one payment.
 * @author charl
 */
public class Sale {
    private LocalTime saleTime;
    private ArrayList <Item> items; 
    private ArrayList <Item> publicItems; 
    private double totalPrice;
    private double totalVAT;
    
    private Item addedItem;
    
    public Sale(){
        saleTime = LocalTime.now();
        items = new ArrayList<Item>();
    }
    /**
     * Checks the list of items currently in sale with the scanned item.
     * Raises the quantity of the item if its already in the system.
     * @param itemDTO an object ItemDTO holding infromation about an item.
     * @return true if item is already in sale else false.
     */
    private boolean checkForDuplicateItem(ItemDTO itemDTO){
        for(Item item:items){
            if(item.getItemIdentifier().equals(itemDTO.getItemIdentifier())){
                item.raiseQuantity();
                System.out.println("Quantity raised");
                return true;
            }
        }
        return false;
    }
    /**
     * This function calculates the running total based of the items price, vat and quantity.
     */
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
    
    /**
     * This function adds an item to sale. if item is duplicate the quantity is raised in checkForDuplicateItem. 
     * Calculates the new running total.
     * @param itemDTO an object ItemDTO contains information about the item.
     * @return an object that holds the information about the most recent added item ans the running total.
     */
    public SaleInformationDTO addItem(ItemDTO itemDTO){
        if(!checkForDuplicateItem(itemDTO)){
            addedItem = new Item(itemDTO);
            items.add(addedItem);
        }
        
        calculateRunningTotal();
        return new SaleInformationDTO(itemDTO,this);
    }
    /**
     * This function creates a SaleDTO from the Sale object.
     * @return SaleDTO, an object that holds information about the sale.
     */
    public SaleDTO createSaleDTO(){
        return new SaleDTO(this);
    }
    /**
     * This function creates a receipt for the current sale and prints the receipt.
     * @param saleDTO an object that holds information about the sale.
     * @param paymentDTO an object that holds information about the payment.
     * @return placeholder receipt because ReceiptPrinter isnt fully implemented.
     */
    public String printReceipt(PaymentDTO paymentDTO){
        Receipt receipt = new Receipt(this.createSaleDTO(),paymentDTO);
        receipt.sendReceiptToPrinter();
        return receipt.getReceiptSummary();
    }
    /**
     * Returns the total price of the sale
     * @return total price of sale
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * Returns total Vat of the sale
     * @return total vat of sale
     */
    public double getTotalVAT(){
        return totalVAT;
    }
    /**
     * Return a duplicate list of items, this list is made up of duplicates of the Item objects in items.
     * publicItems refers to a duplicate list of items.
     * @return a list of Item objects.
     */
    public ArrayList getItems(){
        publicItems = new ArrayList<Item>();

        for(Item item:items){
            publicItems.add(new Item(item));
        }
        return publicItems;
    }
    /**
     * returns time of completed sale
     * @return time of sale
     */
    public LocalTime getSaleTime(){
        return saleTime;
    }
    /**
     * Find the items quantity based on its identifer.
     * @param itemIdentifer  identifer of the item wanting to be found.
     * @return the quantity of the item wanting to be found.
     */
    public int getQuantityOfItem(String itemIdentifer){
        for(Item item:items){
            if(item.getItemIdentifier().equals(itemIdentifer)){
                return item.getQuantity();
            }
        }
        return 0;
    }
    
}
