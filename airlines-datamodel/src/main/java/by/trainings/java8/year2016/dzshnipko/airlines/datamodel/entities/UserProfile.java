package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.UserRole;;

@Entity
public class UserProfile  extends AbstractModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="employee_id" , unique= true, nullable=true, insertable=true, updatable=true)
	private Employee employee;
	@Column
	private UserRole userRole;
	@Column
	String login;
	@Column
	private String email;
	@Column
	private String password;

	public UserRole getUserRole() {
		return userRole;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
}
