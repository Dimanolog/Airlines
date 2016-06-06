package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators;

import javax.inject.Inject;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.RegexValidator;

public class EmailWebValidator implements IValidator<String> {
	
	@Inject
	UserService userService;
		
	@Override
	public void validate(IValidatable<String> validatable) {
		final String email = validatable.getValue();
		ValidationError error = new ValidationError();
		EmailValidator emailValidator = EmailValidator.getInstance();
		if(emailValidator.isValid(email)==false)
		{
			error.addKey("error.wrong.email");
		}else{
			if(!userService.checkUniqueEmail(email)){
				error.addKey("error.not.unique.email");
			}
		}
	}
}
