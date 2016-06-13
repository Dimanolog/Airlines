package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;

public interface EmployeeService {
	Long count(EmployeeFilter filter);

	List<Employee> find(EmployeeFilter filter);

	@Transactional
	void save(Employee employee);

	@Transactional
	void update(Employee employee);

	@Transactional
	void delete(Employee employee);
	@Transactional
	void saveOrUpdate(Employee employee);

}
