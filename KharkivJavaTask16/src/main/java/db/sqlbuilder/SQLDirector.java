package db.sqlbuilder;

/**
 * @author Arsalan
 */
public class SQLDirector {

    public static String buildSQL(SQLBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(builder.getTable());
        stringBuilder.append(builder.getCommand());
        stringBuilder.append(builder.getWhat());
        return stringBuilder.toString();
    }

}
