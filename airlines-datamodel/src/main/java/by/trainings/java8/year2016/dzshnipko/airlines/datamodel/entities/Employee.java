package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.EmloyeeStatus;


@Entity
public class Employee extends AbstractModel {
	
	@Column
    @Enumerated(value = EnumType.ORDINAL)
	private Specialty specialty;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String gender;
	@Column
	private String dateOfBirth;
	@Column
	private String photo;
	@Column
	private String description; 
	@Column
	private Date employmentDate;
	@Column
	private Integer totalFlight; 
	@Column
	private  EmloyeeStatus employeeStatus;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
    @ManyToMany(targetEntity = Flight.class, fetch = FetchType.LAZY)
	private Set<Flight>flights;
	
	
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

	public EmloyeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setEmployeeStatus(EmloyeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
			
}
