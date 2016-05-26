package by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;

public interface AbstractDao<T, ID> {

    List<T> getAll();

    T select(final ID id);

    T insert(final T entity);

    T update(T entity);

    void delete(ID id);
    
    void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<T> cq, Root<T> from);
}
