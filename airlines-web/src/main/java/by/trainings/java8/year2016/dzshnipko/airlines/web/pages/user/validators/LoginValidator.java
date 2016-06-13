package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators;

import javax.inject.Inject;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.omg.CORBA.PRIVATE_MEMBER;

import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.RegexValidator;

public class LoginValidator implements IValidator<String> {

	
	private static final long serialVersionUID = 1L;

	private static final LoginValidator INSTANCE=new LoginValidator();
	
	@Inject
	private RegexValidator regexValidator;
	@Inject
	private UserService userService;
	
	
	private LoginValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static LoginValidator getInstance(){
		return INSTANCE;
	}

	@Override
	public void validate(IValidatable<String> validatable) {
		final String login = validatable.getValue();
		ValidationError error = new ValidationError();
		if (regexValidator.validateLogin(login) == false) {
			error.addKey("error.wrong.login");
			validatable.error(error);
		} else {
			if (userService.checkUniqueLogin(login) == false) {
				error.addKey("error.not.unique.login");
				validatable.error(error);
			}

		}
	}
}
