/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.pos.DTO;

import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.IV1350.pos.model.Item;
import se.kth.IV1350.pos.model.Sale;

/**
 *
 * @author charl
 */
public class SaleDTO {
    private LocalTime saleTime;
    private ArrayList <Item> items;
    private ArrayList <Item> publicItems; 
    private double totalPrice;
    private double totalVAT;
    
    public SaleDTO(Sale sale){
        this.saleTime = sale.getSaleTime();
        this.items = sale.getItems();
        this.totalPrice = sale.getTotalPrice();
        this.totalVAT = sale.getTotalVAT();
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
