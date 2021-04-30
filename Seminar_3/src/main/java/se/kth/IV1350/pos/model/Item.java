/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.model;

import se.kth.IV1350.pos.DTO.ItemDTO;

/**
 *
 * @author charl
 */
public class Item {
    private int quantity;
    private String name;
    private double VATRate;
    private double price;
    private String description;
    private String itemIdentifier;
    
    public Item(Item item) {
        description = item.getDescription();
        VATRate = item.getVATRate();
        price = item.getPrice();
        name = item.getName();
        itemIdentifier = item.getItemIdentifier();
        quantity = item.getQuantity();
    }
        
    public Item(ItemDTO itemDTO){
        this.quantity = 1;
        this.name = itemDTO.getName();
        this.VATRate = itemDTO.getVATRate();
        this.price = itemDTO.getPrice();
        this.description = itemDTO.getDescription();
        this.itemIdentifier  = itemDTO.getItemIdentifier();
    }
    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getItemIdentifier(){
        return itemIdentifier;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    
    public double getVATRate(){
        return VATRate;
    }
    public double getVATAmount(){
        return 0.01*VATRate* price;
    }  
    public void raiseQuantity(){
        quantity+=1;
    }  
}
