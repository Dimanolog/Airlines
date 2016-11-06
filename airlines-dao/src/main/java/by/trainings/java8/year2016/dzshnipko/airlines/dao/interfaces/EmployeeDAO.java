package by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;

public interface EmployeeDAO extends AbstractDao<Employee, Long, EmployeeFilter> {

}
