package db.transaction;

/**
 * @author Arsalan
 */
public interface TransactionOperation<T> {

    <T> T doOperation();

}
