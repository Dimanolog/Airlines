package by.trainings.java8.year2016.dzshnipko.airlines.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.EmployeeDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Inject
	private EmployeeDAO dao;

	@Override
	public Long count(EmployeeFilter filter) {
		Long count = dao.count(filter);
		return count;
	}

	@Override
	public List<Employee> find(EmployeeFilter filter) {
		dao.find(filter);
		return dao.find(filter);
	}

	@Override
	public void save(Employee employee) {
		dao.insert(employee);

	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);

	}
	@Override
	public void saveOrUpdate(Employee employee) {
		if (employee.getId() != null) {
			this.update(employee);
		} else {
			this.save(employee);

		}
	}

	@Override
	public void delete(Employee employee) {
		dao.delete(employee.getId());

	}

}
