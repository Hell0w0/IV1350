
package se.kth.IV1350.pos.DTO;

    /**
 * DiscountDTO is a class that holds data about the payment made and is used to transfer data between classes.
 * It is created in the pay function in Controller.
 * @author charl
 */
public class DiscountDTO {
    private double amount;
    private final String type;
    private String idOfDiscountedItem;
    private double minRequired;
    
    /**
     * @param amount refers to the discount amount
     * @param id refers to the identifier of the discounted item
     * 
     */
    public DiscountDTO(double amount,String id){
        this.amount=amount;
        this.type="item";
        this.idOfDiscountedItem=id;

    }
    public DiscountDTO(double amount,double min){
        this.amount=amount;
        this.type="sale";
        this.minRequired = min;
    }
     /**
     * Return the amount the customer paid with
     * @return double amount paid
     */
    public double getAmount(){
        return amount;
    }
     /**
     * Return the Currency the customer payed with.
     * @return String name of currency
     */
    public String getType(){
        return type;
    }
    public String getIdOfDiscountedItem(){
        return idOfDiscountedItem;
    }
    public double getMinRequiered(){
        return minRequired;
    }
}
