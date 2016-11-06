package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.EmployeeDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee_;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, Long, EmployeeFilter> implements EmployeeDAO {

	protected EmployeeDaoImpl() {
		super(Employee.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(EmployeeFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Employee> from) {
		
		List<Predicate> predicates = new ArrayList<>();

		if (filter.getSpecialty() != null) {
			predicates.add(cb.equal(from.get(Employee_.specialty), filter.getSpecialty().ordinal()));
		}
		if (filter.getEmployeeStatus() != null) {
			predicates.add(cb.equal(from.get(Employee_.employeeStatus), filter.getEmployeeStatus().ordinal()));
		}
		cq.where(predicates.toArray(new Predicate[] {}));
	}

	@Override
	protected void fetchLazyInitilization(EmployeeFilter filter, Root<Employee> from) {
		
		if (filter.isFetchFlight()) {
			from.fetch(Employee_.flights, JoinType.LEFT);
		}
	}

	

}
