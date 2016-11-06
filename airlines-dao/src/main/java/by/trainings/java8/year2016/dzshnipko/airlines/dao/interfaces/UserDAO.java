package by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile;

public interface UserDAO extends AbstractDao<UserProfile, Long,UserFilter> {
	UserProfile getUserByLogin(String login);
	UserProfile getUserByEmail(String email);
	
}
