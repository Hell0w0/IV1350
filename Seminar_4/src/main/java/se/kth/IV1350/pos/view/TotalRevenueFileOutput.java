
package se.kth.IV1350.pos.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.IV1350.pos.model.SaleObserver;

/**
 *
 * @author charl
 */
/**
 * TotalRevenueFileOutput This class writes the total income from the register since the program was started.
 */
class TotalRevenueFileOutput implements SaleObserver {
    private PrintWriter logFile;
    private double totalRevenue;

    TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            logFile = new PrintWriter(new FileWriter("total-revenue.txt"), true);
        } catch (IOException ex) {
            System.out.println("Logger couldnt be created.");
            ex.printStackTrace();
        }
    }

    public void newSale(double priceOfPurchase) {
        totalRevenue += priceOfPurchase;
        logFile.println("Total revenue: " + totalRevenue);
    }
}