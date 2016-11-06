package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.UserRole;

public class UserFilter extends AbstractFilter {

	private static final long serialVersionUID = 1L;
	
	private UserRole userRole;
	private String login;
	private String email;
	private boolean FetchEmployee;
	
	public UserRole getUserRole() {
		return userRole;
	}
	public String getLogin() {
		return login;
	}
	public String getEmail() {
		return email;
	}
	public boolean isFetchEmployee() {
		return FetchEmployee;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFetchEmployee(boolean fetchEmployee) {
		FetchEmployee = fetchEmployee;
	}

}
