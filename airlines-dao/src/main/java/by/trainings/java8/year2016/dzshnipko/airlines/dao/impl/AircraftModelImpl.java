package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftModelFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.AircraftModelDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel_;

@Repository
public class AircraftModelImpl extends AbstractDaoImpl<AircraftModel, Long, AircraftModelFilter> implements AircraftModelDAO {

	protected AircraftModelImpl() {
		super(AircraftModel.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void handleFilterParameters(AircraftModelFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq, Root<AircraftModel> from) {
		AircraftModelFilter aircraftModelFilter=(AircraftModelFilter)filter;
		List<Predicate> predicates=new ArrayList<>();
		
		if(StringUtils.isNotBlank(aircraftModelFilter.getName())){
			predicates.add(cb.equal(from.get(AircraftModel_.name), aircraftModelFilter.getName()));
		}
		
		if (aircraftModelFilter.getConsumPerHourMax()!=null) {
            predicates.add(cb.lt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMax()));
            
        }
		if (aircraftModelFilter.getConsumPerHourMin()!=null) {
            predicates.add(cb.gt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMin()));
            
        }
		
		if (aircraftModelFilter.getMaxTransportedCargoMax()!=null) {
            predicates.add(cb.lt(from.get(AircraftModel_.maxTransportedCargo), aircraftModelFilter.getMaxTransportedCargoMax()));
            
        }
		
		if (aircraftModelFilter.getConsumPerHourMin()!=null) {
            predicates.add(cb.gt(from.get(AircraftModel_.consumPerHour), aircraftModelFilter.getConsumPerHourMin()));
            
        }
		cq.where(predicates.toArray(new Predicate[] {}));
					
	}


	@Override
	protected void fetchLazyInitilization(AircraftModelFilter filter, Root<AircraftModel> from) {
		// TODO Auto-generated method stub
		
	}
}

