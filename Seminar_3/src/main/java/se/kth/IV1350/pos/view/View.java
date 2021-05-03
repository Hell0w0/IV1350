package se.kth.IV1350.pos.view;

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
        contr.startSale();
        System.out.println("Sale has started");
    }
}
