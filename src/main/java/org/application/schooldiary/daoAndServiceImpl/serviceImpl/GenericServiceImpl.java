package org.application.schooldiary.daoAndServiceImpl.serviceImpl;

import org.application.schooldiary.daosAndServices.dao.GenericDao;
import org.application.schooldiary.daosAndServices.service.GenericService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Transactional
    @Override
    public T findById(ID id) {
        return getDao().findById(id);
    }

    @Transactional
    @Override
    public T merge(T entity) {
        return getDao().merge(entity);
    }

    @Transactional
    @Override
    public T persist(T entity) {
        return getDao().persist(entity);
    }

    @Transactional
    @Override
    public T remove(T entity) {
        return getDao().remove(entity);
    }

    @Transactional
    @Override
    public long countAll() {
        return getDao().countAll();
    }

    @Transactional
    @Override
    public List<T> findAll(String... fetchRelations) {
        return getDao().findAll(fetchRelations);
    }

    protected abstract GenericDao<T, ID> getDao();
}
