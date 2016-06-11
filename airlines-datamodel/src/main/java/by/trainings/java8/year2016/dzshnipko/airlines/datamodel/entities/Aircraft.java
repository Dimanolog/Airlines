package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.AircraftState;

@Entity
public class Aircraft implements Serializable {

	@Id
	private String aircraftsNumber;
	@Column
	private Date manufactureDate;
	@Column
	private Date dateOfPurchase;
	@ManyToOne(fetch = FetchType.EAGER)
	private AircraftModel aircraftModel;
	@Column
	private String photo;
	@Column
	private Integer totalFlight;
	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private AircraftState aircraftState;
	@OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY)
	private Set<Flight> flights;
	
	

	public String getAircraftsNumber() {
		return aircraftsNumber;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public AircraftModel getAircraftModel() {
		return aircraftModel;
	}

	public String getPhoto() {
		return photo;
	}

	public Integer getTotalFlight() {
		return totalFlight;
	}

	public AircraftState getAircraftState() {
		return aircraftState;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setAircraftsNumber(String aircraftsNumber) {
		this.aircraftsNumber = aircraftsNumber;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public void setAircraftModel(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setTotalFlight(Integer totalFlight) {
		this.totalFlight = totalFlight;
	}

	public void setAircraftState(AircraftState aircraftState) {
		this.aircraftState = aircraftState;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

}
