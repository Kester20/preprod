package db.sqlbuilder;

/**
 * @author Arsalan
 */
public interface SQLBuilder {

    /**
     * Gets the command attribute of the SQLBuilder object
     *
     * @return The command value or what type of Builder this is. This will return
     * a SQL command.
     */
    String getCommand();

    /**
     * Gets the table attribute of the SQLBuilder object
     *
     * @return The table name value
     */
    String getTable();

    /**
     * Gets the what value of the SQLBuilder object. This attribute will differ
     * based on what type of object we are using. This could be a list of columns
     * and data.
     *
     * @return The what value
     */
    String getWhat();

}
