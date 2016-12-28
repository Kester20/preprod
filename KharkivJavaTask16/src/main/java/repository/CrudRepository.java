package repository;

import exceptions.BusinessException;

/**
 * @author Arsalan
 */
public interface CrudRepository<T> {
    void create(T object) throws BusinessException;
}
