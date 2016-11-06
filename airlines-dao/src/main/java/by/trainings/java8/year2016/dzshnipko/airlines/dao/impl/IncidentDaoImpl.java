package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.IncidentFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.IncidentDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Incident;

@Repository
public class IncidentDaoImpl extends AbstractDaoImpl<Incident, Long, IncidentFilter> implements IncidentDAO{

	protected IncidentDaoImpl() {
		super(Incident.class);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	protected void handleFilterParameters(IncidentFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Incident> from) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fetchLazyInitilization(IncidentFilter filter, Root<Incident> from) {
		// TODO Auto-generated method stub
		
	}

	

}
