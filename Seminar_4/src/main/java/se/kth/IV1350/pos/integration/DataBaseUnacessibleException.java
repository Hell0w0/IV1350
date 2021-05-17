
package se.kth.IV1350.pos.integration;

/**
 *
 * @author charl
 */
public class DataBaseUnacessibleException extends Exception {
    private String dataBaseNotRunning;

    /**
     * Creates a new instance with a message specifying for which identifier isnt in the system database.
     *
     * @param dataBaseNotRunning The database that wont run.
     */
    public DataBaseUnacessibleException(String dataBaseNotRunning) {
        super("Unable to start database" + dataBaseNotRunning + ", since it wont start");
        this.dataBaseNotRunning = dataBaseNotRunning;
    }


}