package repository;

import exceptions.BusinessException;

/**
 * @author Arsalan
 */
public interface CrudRepository<T> {

    /**
     * creates new item
     * @param object - item
     */
    void create(T object) throws BusinessException;

    /**
     * gets item by some criteria
     * @param criteria
     * @return item
     */
    T get (String criteria) throws BusinessException;

    /**
     * updates item
     * @param object - item
     */
    void update(T object) throws BusinessException;

    /**
     * deletes item
     * @param object - item
     */
    void delete(T object) throws BusinessException;

}
