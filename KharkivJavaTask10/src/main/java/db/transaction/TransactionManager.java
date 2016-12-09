package db.transaction;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Arsalan
 */
public class TransactionManager {

    private DataSource dataSource;
    public static final Logger log = Logger.getLogger(TransactionManager.class);

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    Connection connection = null;

    public <T> T doInTransaction(TransactionOperation operation) {
        T result = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            result = (T) operation.doInTransaction();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            log.info("SQL exceptipn during transaction operation");
            e.printStackTrace();
        }
        return result;
    }

}
