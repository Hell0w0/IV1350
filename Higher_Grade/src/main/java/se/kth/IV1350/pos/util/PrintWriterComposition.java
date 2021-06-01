
package se.kth.IV1350.pos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;


public class PrintWriterComposition {
    private PrintWriter printWriter;

    /**
     *PrintWriterComposition, implemented PrintWriter using Composition
     * @throws IOException if the file doesnt exisit or cant be opened for some reason
     */
    public PrintWriterComposition() throws IOException {
        printWriter = new PrintWriter(new FileWriter("total-revenue-compotion.txt"), true);
    }
    /**
     * writes the time and message, total revenue in the file total-revenue-composition.txt
     * @param message a string consisiting of the total revenue made.
     */
    public void println(String message) {
        LocalTime writeTime = LocalTime.now();
        printWriter.println("Print from " + writeTime.getHour() + ":" + writeTime.getMinute() + " \n" + message);
    }
}
