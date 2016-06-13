package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators;

import javax.inject.Inject;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;

public class EmailWebValidator implements IValidator<String> {

	@Inject
	UserService userService;

	private static final EmailWebValidator INSTANCE=new EmailWebValidator();

	static public EmailWebValidator getInstance() {

		return INSTANCE;
	}

	private EmailWebValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(IValidatable<String> validatable) {
		final String email = validatable.getValue();
		ValidationError error = new ValidationError();
		EmailValidator emailValidator = EmailValidator.getInstance();
		if (emailValidator.isValid(email) == false) {
			error.addKey("error.wrong.email");
			validatable.error(error);
		} else {
			if (!userService.checkUniqueEmail(email)) {
				error.addKey("error.not.unique.email");
				validatable.error(error);
				;
			}
		}
	}
}
