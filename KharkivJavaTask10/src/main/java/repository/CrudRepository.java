package repository;

/**
 * @author Arsalan
 */
public interface CrudRepository<T> {

    void create(T object);

    T get (String criteria);

    void update(T object);

    void delete(T object);

}
