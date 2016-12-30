package repository.product;

import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Producer;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.query.LaptopQueries.GET_ALL_PRODUCERS;

/**
 * @author Arsalan
 */
public class ProducerRepository {

    private static final Logger log = Logger.getLogger(ProducerRepository.class);
    private TransactionManager transactionManager;

    public ProducerRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public List<Producer> getAllProducers() {
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Producer>>() {
            @Override
            public List<Producer> doOperation() {
                List<Producer> result = new ArrayList<Producer>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(GET_ALL_PRODUCERS);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Producer producer = new Producer(resultSet.getString(2));
                        result.add(producer);
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during getting producer! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }
}
