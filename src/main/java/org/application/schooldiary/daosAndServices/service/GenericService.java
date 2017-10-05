package org.application.schooldiary.daosAndServices.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> extends Serializable {
    /**
     * Find by id t.
     */
    T findById(ID id);

    /**
     * Merge an entity.
     */
    T merge(T entity);

    /**
     * Persist an entity.
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
     * Find all list.
     */
    List<T> findAll(String... fetchRelations);
}
