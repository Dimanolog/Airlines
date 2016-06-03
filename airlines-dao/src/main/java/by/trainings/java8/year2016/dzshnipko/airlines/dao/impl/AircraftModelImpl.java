package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftModelFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftModelDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel_;
import org.apache.commons.lang.StringUtils;

@Repository
public class AircraftModelImpl extends AbstractDaoImpl<AircraftModel, Long> implements AircraftModelDAO {

	protected AircraftModelImpl() {
		super(AircraftModel.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq, Root<AircraftModel> from) {
		AircraftModelFilter aircraftModelFilter=(AircraftModelFilter)filter;
		List<Predicate> predicates=new ArrayList<>();
		
		if(StringUtils.isNotBlank(aircraftModelFilter.getName())){
			predicates.add(cb.equal(from.get(AircraftModel_.name), aircraftModelFilter.getName()));
		}
		
		if (aircraftModelFilter.getConsumPerHourMax()!=0) {
            predicates.add(cb.lt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMax()));
            
        }
		if (aircraftModelFilter.getConsumPerHourMin()!=0) {
            predicates.add(cb.gt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMin()));
            
        }
		
		if (aircraftModelFilter.getMaxTransportedCargoMax()!=0) {
            predicates.add(cb.lt(from.get(AircraftModel_.maxTransportedCargo), aircraftModelFilter.getMaxTransportedCargoMax()));
            
        }
		
		if (aircraftModelFilter.getConsumPerHourMin()!=0) {
            predicates.add(cb.gt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMin()));
            
        }
					
	}
}

