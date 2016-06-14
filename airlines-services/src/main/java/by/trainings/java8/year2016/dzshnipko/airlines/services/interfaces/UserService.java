package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile;

public interface UserService {
	
	public final static String PASSWORD_PATTERN 
    = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#$%_-]).{6,20})";
	
	Long count(UserFilter filter);

	List<UserProfile> find(UserFilter filter);

	@Transactional
	void save(UserProfile userProfile);

	@Transactional
	void update(UserProfile userProfile);

	@Transactional
	void delete(UserProfile userProfile);

	UserProfile getUserByLoginOrEmail(String login);

	boolean checkUniqueLogin(String login);

	boolean checkUniqueEmail(String email);

}
