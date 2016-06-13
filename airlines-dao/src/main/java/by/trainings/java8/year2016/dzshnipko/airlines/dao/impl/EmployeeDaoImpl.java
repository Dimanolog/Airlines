package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.EmployeeDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee_;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, Long> implements EmployeeDAO {

	protected EmployeeDaoImpl() {
		super(Employee.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<Employee> from) {
		EmployeeFilter empFilter = setFilter(filter);

		List<Predicate> predicates = new ArrayList<>();

		if (empFilter.getSpecialty() != null) {
			predicates.add(cb.equal(from.get(Employee_.specialty), empFilter.getSpecialty().ordinal()));
		}

		if (empFilter.getEmployeeStatus() != null) {
			predicates.add(cb.equal(from.get(Employee_.employeeStatus), empFilter.getEmployeeStatus().ordinal()));
		}

		cq.where(predicates.toArray(new Predicate[] {}));

	}

	@Override
	protected void fetchLazyInitilization(AbstractFilter filter, Root<Employee> from) {
		EmployeeFilter empFilter = setFilter(filter);
		if (empFilter.isFetchFlight()) {
			from.fetch(Employee_.flights, JoinType.LEFT);
		}
	}

	private EmployeeFilter setFilter(AbstractFilter filter) {
		EmployeeFilter empFilter;
		if (filter instanceof EmployeeFilter) {
			empFilter = (EmployeeFilter) filter;
		} else {
			throw new IllegalArgumentException("wrong filter, nead EmployeeFilter");
		}
		return empFilter;
	}

}
