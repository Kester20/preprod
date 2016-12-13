package db.transaction;

import exceptions.BusinessException;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Arsalan
 */
public class TransactionManager {

    private DataSource dataSource;
    private Connection connection;
    public static final Logger log = Logger.getLogger(TransactionManager.class);

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T doInTransaction(TransactionOperation operation) throws BusinessException {
        T result;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            result = (T) operation.doOperation();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            log.info("SQL exceptipn during transaction operation");
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                log.info("SQL exceptipn during closing connection");
                e.printStackTrace();
            }
        }
        return result;
    }

    public <T> T doWithoutTransaction(TransactionOperation operation) {
        T result = null;
        try {
            connection = dataSource.getConnection();
            result = (T) operation.doOperation();
        } catch (SQLException e) {
            log.info("SQL exceptipn during transaction operation");
            e.printStackTrace();
        }
        return result;
    }

    public Connection getConnection() {
        return connection;
    }
}
