package repository.laptop;

import db.sqlbuilder.impl.CatalogSQLBuilder;
import db.sqlbuilder.SQLDirector;
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
import java.util.*;

import static constants.Constants.*;
import static db.query.LaptopQueries.*;

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

    public List<Laptop> getAllLaptops(int limit) {
        getCountOfLaptops(GET_COUNT_OF_LAPTOPS);
        String sql = GET_ALL_LAPTOPS + " LIMIT 0, " + limit;
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Laptop>>() {
            @Override
            public List<Laptop> doOperation() {
                List<Laptop> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Laptop laptop = new Laptop(resultSet.getInt(1), new Producer(resultSet.getString(2)),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), new Category(resultSet.getString(6)));
                        result.add(laptop);
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting laptop! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    public List<Laptop> getByCriteria(Map<String, Object> criteria) {
        String sql = SQLDirector.buildSQL(new CatalogSQLBuilder(GET_ALL_LAPTOPS, criteria));
        log.info(sql);

        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Laptop>>() {
            @Override
            public List<Laptop> doOperation() {
                List<Laptop> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    int index = 1;
                    Iterator iterator = criteria.keySet().iterator();
                    while (iterator.hasNext()){
                        String key = (String) iterator.next();
                        if(key.equals(LAPTOPS_PRODUCER) || key.equals(LAPTOPS_CATEGORY)){
                            for (String value : (List<String>)criteria.get(key)) {
                                statement.setString(index++, value);
                            }
                        }
                        if(key.equals(FIRST_PRICE) || key.equals(SECOND_PRICE)){
                            statement.setInt(index++, (int)criteria.get(key));
                        }
                    }

                    getCountOfLaptops(statement.toString());

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Laptop laptop = new Laptop(resultSet.getInt(1), new Producer(resultSet.getString(2)),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), new Category(resultSet.getString(6)));
                        result.add(laptop);
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting laptop by criteria! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    public void getCountOfLaptops(String sql) {
        if(sql.contains("LIMIT")){
            sql = replaceSelect(sql);
            sql = deleteLimitFromQuery(sql);
        }
        String finalSql = sql;
        countOfLaptops = transactionManager.doWithoutTransaction(new TransactionOperation<Integer>() {
            @Override
            public Integer doOperation() {
                int result = 0;
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(finalSql);

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

    private String deleteLimitFromQuery(String sql){
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.delete(stringBuilder.indexOf("LIMIT"), stringBuilder.length());
        return stringBuilder.toString();
    }

    private String replaceSelect(String sql){
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.replace(0, stringBuilder.indexOf("FROM") + 4,"SELECT COUNT(*) FROM ");
        return stringBuilder.toString();
    }

    public int getCountOfLaptops() {
        return countOfLaptops;
    }

    public List<Producer> getAllProducers() {
        String sql = GET_ALL_PRODUCERS;
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Producer>>() {
            @Override
            public List<Producer> doOperation() {
                List<Producer> result = new ArrayList<Producer>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

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

    public List<Category> getAllCategories() {
        String sql = GET_ALL_CATEGORIES;
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Category>>() {
            @Override
            public List<Category> doOperation() {
                List<Category> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Category category = new Category(resultSet.getString(2));
                        result.add(category);
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting category! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }
}
