package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.crew.validators;

import java.util.Collection;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;

public class NumberStuardValidator implements IValidator<Collection<Employee>> {
	
	private static final long serialVersionUID = 1L;
	private AircraftModel aircraftModel;

	public NumberStuardValidator(AircraftModel aircraftModel) {
		super();
		this.aircraftModel = aircraftModel;
	}

	@Override
	public void validate(IValidatable<Collection<Employee>> validatable) {
		final Collection<Employee> employees = validatable.getValue();
		ValidationError error = new ValidationError();

		if (employees.size() != aircraftModel.getStewards()) {
			error.addKey("error.worng.number.stweards");
			validatable.error(error);
		}

	}
}
