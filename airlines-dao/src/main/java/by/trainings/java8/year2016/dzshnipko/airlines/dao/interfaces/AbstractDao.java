package by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces;


import java.util.List;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;

public interface AbstractDao<T, ID, F extends AbstractFilter> {

    List<T> getAll();

    T select(final ID id);

    T insert(final T entity);

    T update(T entity);

    void delete(ID id);
       
    Long count(F filter);
    
    List<T> find(F filter);

	
    
    
}
