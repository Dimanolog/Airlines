package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;

public class Employee extends AbstractModel {
	
	private Specialty specialty;
	private String name;
	private String surname;
	private String gender;
	private String dateOfBirth;
	private String photo;
	private String description; 
	private Date employmentDate;
	private Integer totalFlight; 
	private User user;
	
	
	
	private Integer getTotalFlight() {
		return totalFlight;
	}

	private void setTotalFlight(Integer totalFlight) {
		this.totalFlight = totalFlight;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
			
}
