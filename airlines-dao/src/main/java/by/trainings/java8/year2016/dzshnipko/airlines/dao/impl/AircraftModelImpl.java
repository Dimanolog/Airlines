package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftModelDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;

@Repository
public class AircraftModelImpl extends AbstractDaoImpl<AircraftModel, Long> implements AircraftModelDAO {

	protected AircraftModelImpl() {
		super(AircraftModel.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<AircraftModel> cq,
			Root<?> from) {
		// TODO Auto-generated method stub
	}
}
