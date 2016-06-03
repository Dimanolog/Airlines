package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;

public interface AircraftService {
	Long count(AircraftFilter filter);
    List<Aircraft> find(AircraftFilter filter);
    @Transactional
    void save(Aircraft aircraft);
    @Transactional
    void delete(Aircraft aircraft);
    @Transactional
    void Update(Aircraft aircraft);
}
