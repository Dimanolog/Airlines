package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.util.Date;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.EmloyeeStatus;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;

public class EmployeeFilter extends AbstractFilter {
	
	private Specialty specialty;
	
	private String name;
	
	private String surname;
	
	private String gender;
	
	private String dateOfBirthMax;
	private String dateOfBirthMin;
	
	private Date employmentDateMax;
	private Date employmentDateMin;
	
	private int totalFlightMax;
	private int totalFlightMin;
	
	private boolean fetchFlight;
	private boolean fetchUser;
	
	private EmloyeeStatus employeeStatus;
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getGender() {
		return gender;
	}
	public String getDateOfBirthMax() {
		return dateOfBirthMax;
	}
	public String getDateOfBirthMin() {
		return dateOfBirthMin;
	}
	public Date getEmploymentDateMax() {
		return employmentDateMax;
	}
	public Date getEmploymentDateMin() {
		return employmentDateMin;
	}
	public int getTotalFlightMax() {
		return totalFlightMax;
	}
	public int getTotalFlightMin() {
		return totalFlightMin;
	}
	public boolean isFetchFlight() {
		return fetchFlight;
	}
	public boolean isFetchUser() {
		return fetchUser;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDateOfBirthMax(String dateOfBirthMax) {
		this.dateOfBirthMax = dateOfBirthMax;
	}
	public void setDateOfBirthMin(String dateOfBirthMin) {
		this.dateOfBirthMin = dateOfBirthMin;
	}
	public void setEmploymentDateMax(Date employmentDateMax) {
		this.employmentDateMax = employmentDateMax;
	}
	public void setEmploymentDateMin(Date employmentDateMin) {
		this.employmentDateMin = employmentDateMin;
	}
	public void setTotalFlightMax(int totalFlightMax) {
		this.totalFlightMax = totalFlightMax;
	}
	public void setTotalFlightMin(int totalFlightMin) {
		this.totalFlightMin = totalFlightMin;
	}
	public void setFetchFlight(boolean fetchFlight) {
		this.fetchFlight = fetchFlight;
	}
	public void setFetchUser(boolean fetchUser) {
		this.fetchUser = fetchUser;
	}
	public EmloyeeStatus getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(EmloyeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	
}
