package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AbstractDao;



public abstract class AbstractDaoImpl<T,ID,F  extends AbstractFilter> implements AbstractDao<T, ID,F> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    protected AbstractDaoImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
                       
    }
    
    
	protected abstract void handleFilterParameters(F filter, CriteriaBuilder cb, CriteriaQuery<?> cq, Root<T> from);
	
	protected abstract void fetchLazyInitilization(F filter, Root<T> from);
	
    @Override
    public List<T> getAll() {
        final CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        query.from(getEntityClass());
        final List<T> lst = entityManager.createQuery(query).getResultList();
        return lst;
    }

    @Override
    public T select(final ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public T insert(final T entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public T update(T entity) {
        entity = entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public void delete(ID id) {
        entityManager.createQuery(String.format("delete from %s e where e.id = :id", entityClass.getSimpleName())).setParameter("id", id).executeUpdate();
    }
    
    
    public Class<T> getEntityClass() {
        return entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
   
    public Long count(F filter) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        

        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<T> from = cq.from(getEntityClass());
        
        // set selection
        cq.select(cb.count(from));
   
        TypedQuery<Long> q = em.createQuery(cq);
        
        handleFilterParameters( filter,  cb,  cq, from);

        // set execute query
        return q.getSingleResult();
    }
      
    public List<T> find(F filter) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        Root<T> from = cq.from(getEntityClass());
        
        fetchLazyInitilization(filter,  from);
        
        cq.select(from);
        setSortProperty(filter, cq, from);
        handleFilterParameters( filter,  cb,  cq, from);
        
        
        TypedQuery<T> q = em.createQuery(cq);
        setPaging(filter, q);
        
        return q.getResultList();
    }

	private void setSortProperty(F filter, CriteriaQuery<T> cq, Root<T> from) {
		if (filter.getSortProperty() != null) {
            cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
        }
	}

    protected void setPaging(F filter, TypedQuery<T> q) {
        if (filter.getOffset() != null && filter.getLimit() != null) {
            q.setFirstResult(filter.getOffset());
            q.setMaxResults(filter.getLimit());
        }
     
    }
   
}