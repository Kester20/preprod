package db.transaction;

/**
 * @author Arsalan
 */
public abstract class TransactionOperation<T> {
    public abstract <T> T doInTransaction();
}
