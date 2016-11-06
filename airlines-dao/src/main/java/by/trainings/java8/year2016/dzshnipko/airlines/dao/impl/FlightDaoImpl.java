package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.FlightDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight_;

@Repository
public class FlightDaoImpl extends AbstractDaoImpl<Flight, Long, FlightFilter> implements FlightDAO {

	protected FlightDaoImpl() {
		super(Flight.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(FlightFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Flight> from) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fetchLazyInitilization(FlightFilter filter, Root<Flight> from) {
		
		if (filter.isFetchEmployees()) {
			from.fetch(Flight_.employees, JoinType.LEFT);
		}
		
	}
	

	

}
