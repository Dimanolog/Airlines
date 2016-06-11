package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.FlightResult;

@Repository
public class FlightResultDaoImpl extends AbstractDaoImpl<FlightResult, Long> {

	protected FlightResultDaoImpl() {
		super(FlightResult.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<FlightResult> from) {
		// TODO Auto-generated method stub
		
	}

	
		
}


