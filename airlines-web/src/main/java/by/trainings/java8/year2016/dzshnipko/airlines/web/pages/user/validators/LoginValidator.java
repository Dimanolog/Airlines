package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators;

import javax.inject.Inject;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.RegexValidator;

public class LoginValidator implements IValidator<String> {

	@Inject
	RegexValidator regexValidator;
	@Inject
	UserService userService;

	@Override
	public void validate(IValidatable<String> validatable) {
		final String login = validatable.getValue();
		ValidationError error = new ValidationError();
		if (regexValidator.validateLogin(login) == false) {
			error.addKey("error.wrong.login");
		} else {
			if (userService.checkUniqueLogin(login) == false) {
				error.addKey("error.not.unique.login");
			}

		}
	}
}
