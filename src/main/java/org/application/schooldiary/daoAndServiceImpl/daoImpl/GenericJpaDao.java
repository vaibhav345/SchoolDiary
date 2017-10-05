package org.application.schooldiary.daoAndServiceImpl.daoImpl;

import org.application.schooldiary.daosAndServices.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {
    private final Class<T> entityClass;

    /**
     * Instantiates a new Generic jpa dao.
     */
    protected GenericJpaDao(final Class<T> clazz) {
        entityClass = clazz;
    }

    @Override
    public T findById(ID id) {
        return getEntityManager().find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(String... fetchRelations) {
        if (fetchRelations == null || fetchRelations.length == 0) {
            final Query query = this.getEntityManager().createQuery("select o from " + entityClass.getSimpleName() + " o");
            return query.getResultList();
        } else {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<T> root = criteriaQuery.from(entityClass);
            criteriaQuery.distinct(true);
            fetchChild(root, fetchRelations);
            return getEntityManager().createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public T persist(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T remove(T entity) {
        getEntityManager().remove(entity);
        return entity;
    }

    @Override
    public long countAll() {
        final Query query = this.getEntityManager().createQuery("select count(1) from " + entityClass.getSimpleName() + " o");
        return ((Number) query.getSingleResult()).longValue();
    }

    public T findWithDepth(String idName, Serializable id, String... fetchRelations) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        fetchChild(root, fetchRelations);
        criteriaQuery.where(criteriaBuilder.equal(root.get(idName), id));
        return getSingleOrNoneResult(getEntityManager().createQuery(criteriaQuery));
    }

    public T findWithDepthById(Serializable id, String... fetchRelations) {
        return findWithDepth("id", id, fetchRelations);
    }

    /**
     * Gets single or none result.
     */
    private T getSingleOrNoneResult(TypedQuery<T> query) {
        query.setMaxResults(1);
        List<T> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }

    public T handleSingleResultQuery(CriteriaQuery<T> criteriaQuery, String format, Object... arguments) {
        T entity;
        try {
            entity = getEntityManager().createQuery(criteriaQuery).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

        return entity;
    }

    @Override
    public T removeById(ID id) {
        return remove(findById(id));
    }

    /**
     * Gets entity manager.
     */
    protected abstract EntityManager getEntityManager();

    public Class<T> getEntityClass() {
        return entityClass;
    }

    private void fetchChild(Root<T> root, String[] fetchRelations) {
        Arrays.stream(fetchRelations).forEach(relation -> {
            FetchParent<T, T> fetch = root;
            for (String pathSegment : relation.split("\\.")) {
                fetch = fetch.fetch(pathSegment, JoinType.LEFT);
            }
        });
    }
}
