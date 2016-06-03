package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;

@Repository
public class AircraftDaoImpl extends AbstractDaoImpl<Aircraft, String> implements AircraftDAO {

	protected AircraftDaoImpl() {
		super(Aircraft.class);
		// TODO Auto-generated constructor stub
	}
	

	


	@Override
	public void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Aircraft> from) {
		// TODO Auto-generated method stub
		
	}
	
	
}
