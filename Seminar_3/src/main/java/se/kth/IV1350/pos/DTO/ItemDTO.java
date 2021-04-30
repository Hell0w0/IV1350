package se.kth.IV1350.pos.DTO;

/**
 * ItemDTO transfers a copy of Item so values in Item cant be changed changed by unauthorized programs.
 * name refers to the name of the item
 * VATRate refers to the VATRate of the item
 * price refers to the price of the item
 * description 
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
