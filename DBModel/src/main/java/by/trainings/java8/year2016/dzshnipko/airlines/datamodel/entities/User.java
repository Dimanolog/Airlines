package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.UserRole;

public class User extends AbstractModel  {
	
private UserRole userRole;
private String email;
private String password;

public UserRole getUserRole() {
	return userRole;
}
public void setUserRole(UserRole userRole) {
	this.userRole = userRole;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
