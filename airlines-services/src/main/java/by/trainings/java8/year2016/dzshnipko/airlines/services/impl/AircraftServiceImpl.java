package by.trainings.java8.year2016.dzshnipko.airlines.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AircraftServiceImpl.class);
	@Inject
	private AircraftDAO dao;

	@Override
	public Long count(AircraftFilter filter) {
		Long count = dao.count(filter);
		this.getClass();
		return count;
	}

	@Override
	public List<Aircraft> find(AircraftFilter filter) {
		dao.find(filter);
		return dao.find(filter);
	}

	@Override
	public void save(Aircraft aircraft) {
		boolean uniqueNumber = dao.select(aircraft.getAircraftsNumber()) == null;
		if (uniqueNumber) {
			dao.insert(aircraft);
		} else {
			throw new IllegalArgumentException("not unique aircraft number");

		}

	}

	@Override
	public void update(Aircraft aircraft) {
		dao.update(aircraft);

	}

	@Override
	public void delete(Aircraft aircraft) {
		dao.delete(aircraft.getAircraftsNumber());

	}
	@Override
	public boolean checkUniqueAircraftNumber(String number) {

		return dao.select(number) == null;

	}

}
