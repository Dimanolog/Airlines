package by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;

public interface UserService {
	Long count(UserFilter filter);
    List<User> find(UserFilter filter);
    @Transactional
    void save (User user);
    @Transactional
    void update(User user);
    @Transactional
    void delete(User user);
	User getUserByLoginOrEmail(String login);
	
}
