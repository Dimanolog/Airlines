package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;

public interface FlightService {
	Long count(FlightFilter filter);
    List<Flight> find(FlightFilter filter);
    @Transactional
    void save(Flight flight);
    @Transactional
    void update(Flight flight);
    @Transactional
    void delete(Flight flight);
    @Transactional
    void saveOrUpdate(Flight flight);
}
