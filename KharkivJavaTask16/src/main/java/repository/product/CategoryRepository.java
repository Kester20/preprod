package repository.product;

import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Category;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.query.LaptopQueries.GET_ALL_CATEGORIES;

/**
 * @author Arsalan
 */
public class CategoryRepository {

    private static final Logger log = Logger.getLogger(CategoryRepository.class);
    private TransactionManager transactionManager;

    public CategoryRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public List<Category> getAllCategories() {
        return transactionManager.doWithoutTransaction(new TransactionOperation<List<Category>>() {
            @Override
            public List<Category> doOperation() {
                List<Category> result = new ArrayList<>();
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(GET_ALL_CATEGORIES);
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
