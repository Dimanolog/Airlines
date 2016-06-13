package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.FlightDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight_;

@Repository
public class FlightDaoImpl extends AbstractDaoImpl<Flight, Long> implements FlightDAO {

	protected FlightDaoImpl() {
		super(Flight.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Flight> from) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fetchLazyInitilization(AbstractFilter filter, Root<Flight> from) {
		FlightFilter fltFilter = setFilter(filter);
		if (fltFilter.isFetchEmployees()) {
			from.fetch(Flight_.employees, JoinType.LEFT);
		}
		
	}
	

	private FlightFilter setFilter(AbstractFilter filter) {
		FlightFilter fltfilter;
		if (filter instanceof FlightFilter) {
			fltfilter= (FlightFilter) filter;
		} else {
			throw new IllegalArgumentException("wrong filter, nead FlightFilter");
		}
		return fltfilter;
	}

}
