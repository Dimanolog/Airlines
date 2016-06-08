package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftModelFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;



public interface AircraftModelService {
	Long count(AircraftModelFilter filter);

	List<AircraftModel> find(AircraftModelFilter filter);

    @Transactional
    void save(AircraftModel aircraftModel);
    @Transactional
    void update(AircraftModel aircraftModel);
    @Transactional
    void delete(AircraftModel aircraftModel);

	
}

