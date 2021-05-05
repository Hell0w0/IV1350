package se.kth.IV1350.pos.view;

import se.kth.IV1350.pos.DTO.SaleInformationDTO;
import se.kth.IV1350.pos.controller.Controller;

/**
 * Placeholder for the real view. Hardcoded with 
 * calls to all system operations in the controller.
 * @author charl
 */
public class View {
    private Controller contr;
    /**
     * Creates a new instance.
     * @param contr , The controller used for all calls to other layers.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Preforms a fake sale, by calling all system operaitions in the controller.
     */
    public void runFakeExe(){
        double amountPaid = 80;
        String currency = "kr";
        String itemIdentifier = "1";
        contr.startSale();
        System.out.println("Sale has started");
        SaleInformationDTO addedItem = contr.enterItem("3");
        SaleInformationDTO secondItem = contr.enterItem(itemIdentifier);
        System.out.println(addedItem.getCurrentItemName()+" has been added");
        System.out.println(secondItem.getCurrentItemName()+" has been added");
        double totalPrice = secondItem.getRunningTotal();
        System.out.println("Total price: "+totalPrice+" "+currency);
        System.out.println("Customer pays "+amountPaid+" "+currency);
        double change = contr.pay(amountPaid, currency);
        String receipt = contr.completeSale();
        System.out.println("________________");
        System.out.println("Receipt \n"+receipt);
        System.out.println("Change: "+change+" "+currency);
    }
}
