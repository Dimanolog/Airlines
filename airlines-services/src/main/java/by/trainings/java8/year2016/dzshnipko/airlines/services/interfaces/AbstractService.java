package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;


import java.util.List;

import javax.transaction.Transactional;



public interface AbstractService<E, F> {
	Long count(F filter);

    List<E> find(F filter);

    @Transactional
    void saveOrUpdate(E aircraft);

    @Transactional
    void delete(E aircraft);
}


