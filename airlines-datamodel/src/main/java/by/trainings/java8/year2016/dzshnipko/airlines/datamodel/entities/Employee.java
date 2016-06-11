package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.type.TrueFalseType;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.EmloyeeStatus;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Gender;


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
    @Enumerated(value = EnumType.ORDINAL)
	private Gender gender;
	@Column
	private Date dateOfBirth;
	@Column
	private String photo;
	@Column
	private String description; 
	@Column 
	private Date employmentDate;
	@Column
	private Integer totalFlight; 
	@Column
    @Enumerated(value = EnumType.ORDINAL)
	private  EmloyeeStatus employeeStatus;
	
/*	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn*/
	
	@MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
	private User user;
	
    @ManyToMany(targetEntity = Flight.class, fetch = FetchType.LAZY, mappedBy="employees")
	private Set<Flight>flights;
	
	
	public Integer getTotalFlight() {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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
	
	public String getFullName()
	{
		return String.format("%s %s" , surname , name );
	}
			
}
