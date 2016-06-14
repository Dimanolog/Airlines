package by.trainings.java8.year2016.dzshnipko.airlines.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.UserDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.RegexValidator;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	@Inject
	RegexValidator regexValidator;

	@Override
	public Long count(UserFilter filter) {

		return dao.count(filter);
	}

	@Override
	public List<UserProfile> find(UserFilter filter) {
		// TODO Auto-generated method stub
		return dao.find(filter);
	}

	@Override
	public void save(UserProfile userProfile) {
		dao.insert(userProfile);

	};

	@Override
	public void update(UserProfile userProfile) {
		dao.update(userProfile);

	}

	@Override
	public void delete(UserProfile userProfile) {
		dao.delete(userProfile.getId());

	}

	@Override
	public UserProfile getUserByLoginOrEmail(String loginOrEmail) {
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		boolean isEmailValid = emailValidator.isValid(loginOrEmail);
	
		if (isEmailValid) {
			return dao.getUserByEmail(loginOrEmail);
		}

		boolean isLoginValid = regexValidator.validateLogin(loginOrEmail);
		if (isLoginValid) {
			return dao.getUserByLogin(loginOrEmail);
		}
		throw new IllegalArgumentException("is not email or login");
				
}

	@Override
	public boolean checkUniqueLogin(String login) {
		return dao.getUserByLogin(login)==null;
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		return dao.getUserByEmail(email)==null;
	}

}
