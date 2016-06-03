package by.trainings.java8.year2016.dzshnipko.airlines.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.FlightDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Inject
	private FlightDAO dao;
	@Override
	public Long count(FlightFilter filter) {
		
		return  dao.count(filter);
	}

	@Override
	public List<Flight> find(FlightFilter filter) {
		// TODO Auto-generated method stub
		return dao.find(filter);
	}

	@Override
	public void save(Flight flight) {
		dao.insert(flight);
	
	}
	
	@Override
	public void saveOrUpdate(Flight flight){
		if(flight.getId()==null)
		{
			save(flight);
		}else{
			update(flight);
			
		}
	}

	@Override
	public void update(Flight flight) {
		dao.update(flight);
		
	}

	@Override
	public void delete(Flight flight) {
		dao.delete(flight.getId());
		
	}
	
	

}
