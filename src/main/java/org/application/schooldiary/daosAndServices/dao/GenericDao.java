package org.application.schooldiary.daosAndServices.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    /**
     * Find by id t.
     */
    T findById(ID id);

    /**
     * Find all list.
     */
    List<T> findAll(String... fetchRelations);

    /**
     * Persist an entity.
     */
    T merge(T entity);

    /**
     * Persist t.
     */
    T persist(T entity);

    /**
     * Remove.
     */
    T remove(T entity);

    /**
     * Count all long.
     */
    long countAll();

    /**
     * Remove by id t.
     */
    T removeById(ID id);
}
