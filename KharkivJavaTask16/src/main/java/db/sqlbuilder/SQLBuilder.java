package db.sqlbuilder;

/**
 * @author Arsalan
 */
public interface SQLBuilder {

    /**
     * Gets the table attribute of the SQLBuilder object
     *
     * @return The table name value
     */
    String getTable();

    /**
     * Gets the action attribute of the SQLBuilder object
     *
     * @return The action value or what type of Builder this is. This will return
     * a SQL action.
     */
    String getCommand();

    /**
     * Gets the what value of the SQLBuilder object. This attribute will differ
     * based on what type of object we are using. This could be a list of columns
     * and data.
     *
     * @return The what value
     */
    String getWhat();

}
