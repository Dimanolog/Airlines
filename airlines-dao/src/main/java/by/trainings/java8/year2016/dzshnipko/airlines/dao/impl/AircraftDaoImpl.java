package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;

@Repository
public class AircraftDaoImpl extends AbstractDaoImpl<Aircraft, String, AircraftFilter> implements AircraftDAO {

	protected AircraftDaoImpl() {
		super(Aircraft.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void handleFilterParameters(AircraftFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Aircraft> from) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fetchLazyInitilization(AircraftFilter filter, Root<Aircraft> from) {
		// TODO Auto-generated method stub
		
	}
}
