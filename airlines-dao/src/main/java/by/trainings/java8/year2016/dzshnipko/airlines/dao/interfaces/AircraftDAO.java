package by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;

public interface AircraftDAO extends AbstractDao<Aircraft, String, AircraftFilter> {
	
}
