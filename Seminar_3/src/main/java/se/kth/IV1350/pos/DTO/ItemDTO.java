/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.DTO;

/**
 *
 * @author charl
 */
public class ItemDTO {
    private String name;
    private double VATRate;
    private double price;
    private String description;
    private String itemIdentifier;
    
    public ItemDTO(String name, double VATRate,double price, String description, String identifer){
        this.name = name;
        this.VATRate = VATRate;
        this.price = price;
        this.description = description;
        this.itemIdentifier  = identifer;
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
    public double getPrice(){
        return price;
    }
    public double getVATRate(){
        return VATRate;
    }    
}