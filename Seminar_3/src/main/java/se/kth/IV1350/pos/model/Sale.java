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
    
        public boolean checkForDuplicateItem(ItemDTO itemDTO){
            for(Item item:items){
                if(item.getItemIdentifier().equals(itemDTO.getItemIdentifier())){
                    item.raiseQuantity();
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
    
    /**
     * Adds a new item to the Sale, if the item is already in Sale, rasise the item quantity by 1 and send back the saleInformation.
     * @param itemDTO contains information about the item.
     * @return 
     */
    public SaleInformationDTO addItem(ItemDTO itemDTO){
        if(!checkForDuplicateItem(itemDTO)){
            addedItem = new Item(itemDTO);
            items.add(addedItem);
        }
        
        calculateRunningTotal();
        return new SaleInformationDTO(itemDTO, totalPrice);
    }
    
    public SaleDTO createSaleDTO(){
        return new SaleDTO(this);
    }
    public void createAndPrintReceipt(SaleDTO saleDTO,PaymentDTO paymentDTO){
        Receipt receipt = new Receipt(saleDTO,paymentDTO);
        receipt.sendReceiptToPrinter();
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public double getTotalVAT(){
        return totalVAT;
    }
    public ArrayList getItems(){
       
        for(Item item:items){
            publicItems.add(new Item(item));
        }
        return publicItems;
    }
    public LocalTime getSaleTime(){
        return saleTime;
    }
}
