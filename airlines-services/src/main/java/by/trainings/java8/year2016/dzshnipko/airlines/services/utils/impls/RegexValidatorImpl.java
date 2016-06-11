package by.trainings.java8.year2016.dzshnipko.airlines.services.utils.impls;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.RegexValidator;

@Service
public class RegexValidatorImpl implements RegexValidator {

	private Pattern loginPattern=Pattern.compile(LOGIN_PATTERN);
	private Matcher matcher;

	private static final String LOGIN_PATTERN = "^[a-z0-9_-]{3,15}$";

	@Override
	public boolean validateLogin(final String login) {
		matcher = loginPattern.matcher(login);
		if (matcher.matches()) {
			return true;
		}

		return false;
	}

}
