package repository.laptop;

import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Laptop;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import repository.CrudRepository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.query.LaptopQueries.GET_ALL_LAPTOPS;

/**
 * @author Arsalan
 */
public class LaptopRepository implements CrudRepository<Laptop> {

    private static final Logger log = Logger.getLogger(LaptopRepository.class);
    private TransactionManager transactionManager;

    public LaptopRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    @Override
    public void create(Laptop object) throws BusinessException {

    }

    @Override
    public Laptop get(String criteria) throws BusinessException {
        return null;
    }

    @Override
    public void update(Laptop object) throws BusinessException {

    }

    @Override
    public void delete(Laptop object) throws BusinessException {

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
                        Laptop laptop = new Laptop(resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
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
}
