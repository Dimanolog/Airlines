package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;

public interface UserService {
	
	public final static String PASSWORD_PATTERN 
    = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	Long count(UserFilter filter);

	List<User> find(UserFilter filter);

	@Transactional
	void save(User user);

	@Transactional
	void update(User user);

	@Transactional
	void delete(User user);

	User getUserByLoginOrEmail(String login);

	boolean checkUniqueLogin(String login);

	boolean checkUniqueEmail(String email);

}
