package repository.product;

import db.sqlbuilder.SQLDirector;
import db.sqlbuilder.impl.CatalogSQLBuilder;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;
import static db.query.LaptopQueries.GET_ALL_LAPTOPS;

/**
 * @author Arsalan
 */
public class LaptopRepository {

    private static final Logger log = Logger.getLogger(LaptopRepository.class);
    private TransactionManager transactionManager;
    private int countOfLaptops;

    public LaptopRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public List<Laptop> getByCriteria(Map<String, Object> criteria) {
        String sql = SQLDirector.buildSQL(new CatalogSQLBuilder(GET_ALL_LAPTOPS, WHERE_SQL, criteria));
        log.info(sql);
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Laptop>>() {
            @Override
            public List<Laptop> doOperation() {
                List<Laptop> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);
                    int index = 1;
                    Iterator iterator = criteria.keySet().iterator();
                    while (iterator.hasNext()) {
                        String key = (String) iterator.next();
                        if (key.equals(LAPTOPS_PRODUCER) || key.equals(LAPTOPS_CATEGORY)) {
                            for (String value : (List<String>) criteria.get(key)) {
                                statement.setString(index++, value);
                            }
                        }
                        if (key.equals(FIRST_PRICE) || key.equals(SECOND_PRICE)) {
                            statement.setInt(index++, (int) criteria.get(key));
                        }
                    }

                    prepareQueryForGetCountOfLaptops(statement.toString());

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Laptop laptop = new Laptop(resultSet.getInt(1), new Producer(resultSet.getString(2)),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), new Category(resultSet.getString(6)));
                        result.add(laptop);
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during getting product by criteria! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    private void prepareQueryForGetCountOfLaptops(String sql) {
        StringBuilder stringBuilder = new StringBuilder(sql);
        if (sql.contains(LIMIT_SQL)) {
            stringBuilder.delete(stringBuilder.indexOf(LIMIT_SQL), stringBuilder.length()).toString();
        }
        getCountOfLaptops(stringBuilder.replace(0, sql.indexOf("`laptops`"), "SELECT COUNT(*) FROM ").toString());
    }

    private void getCountOfLaptops(String sql) {
        countOfLaptops = transactionManager.doWithoutTransaction(new TransactionOperation<Integer>() {
            @Override
            public Integer doOperation() {
                int result = 0;
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        result = resultSet.getInt(1);
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during getting count! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    public int getCountOfLaptops() {
        return countOfLaptops;
    }
}
