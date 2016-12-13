package repository.laptop;

import db.sqlbuilder.CatalogSQLBuilder;
import db.sqlbuilder.SQLDirector;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import repository.CrudRepository;

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

    public LaptopRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public List<Laptop> getAllLaptops() {
        String sql = GET_ALL_LAPTOPS;
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Laptop>>() {
            @Override
            public List<Laptop> doOperation() {
                List<Laptop> result = new ArrayList<Laptop>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Laptop laptop = new Laptop(resultSet.getInt(1), new Producer(resultSet.getString(2)),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), new Category(resultSet.getString(6)));
                        result.add(laptop);
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    public List<Laptop> getByParameters(Map<String, Object> criteria) {
        CatalogSQLBuilder sqlBuilder = new CatalogSQLBuilder(GET_ALL_LAPTOPS, criteria);
        String sql = SQLDirector.buildSQL(sqlBuilder);
        log.info(sql);
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Laptop>>() {
            @Override
            public List<Laptop> doOperation() {
                List<Laptop> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    //statement.setString(1, producers[0]);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Laptop laptop = new Laptop(resultSet.getInt(1), new Producer(resultSet.getString(2)),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), new Category(resultSet.getString(6)));
                        result.add(laptop);
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
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