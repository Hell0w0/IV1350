
package se.kth.IV1350.pos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *PrintWriterInhertance, implemented printwriter using inhertance.
 * @author charl
 */
public class PrintWriterInhertance extends PrintWriter {
    /**
     * Creates a new instance of the PrintWriterInhertance class
     * @throws IOException when the file does not exist but cannot be created, or cannot be opened for any other reason
     */
    public PrintWriterInhertance() throws IOException {
        super(new FileWriter("total-revenue-inheritance.txt"), true);
    }

    @Override
    public void println(String message) {
        LocalTime timeOfWrite = LocalTime.now();
        LocalDate dateOfWrite = LocalDate.now();
        super.println("Print from " + dateOfWrite + " at " + timeOfWrite.getHour() + ":" + timeOfWrite.getMinute() + " \n" + message);
    }
    
}
