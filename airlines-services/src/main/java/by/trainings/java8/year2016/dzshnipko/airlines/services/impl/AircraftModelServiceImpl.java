package by.trainings.java8.year2016.dzshnipko.airlines.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftModelFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftModelDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftModelService;

@Service
public class AircraftModelServiceImpl implements AircraftModelService {
	@Inject
	private AircraftModelDAO dao;
	@Override
	public Long count(AircraftModelFilter filter) {
		
		return dao.count(filter);
	}

	@Override
	public List<AircraftModel> find(AircraftFilter filter) {
		// TODO Auto-generated method stub
		return dao.find(filter);
	}

	@Override
	public void save(AircraftModel aircraftModel) {
		dao.insert(aircraftModel);
		
	}

	@Override
	public void update(AircraftModel aircraftModel) {
		dao.update(aircraftModel);
		
	}

	@Override
	public void delete(AircraftModel aircraftModel) {
		dao.delete(aircraftModel.getId());
		
	}

}
