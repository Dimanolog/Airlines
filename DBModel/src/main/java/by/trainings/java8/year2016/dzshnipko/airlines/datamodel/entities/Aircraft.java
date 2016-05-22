package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

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
public class Aircraft {
	@Id
	private String aircraftsNumber;
	@Column
	private Date  manufactureDate;
	@Column
	private Date dateOfPurchase;
	@ManyToOne(fetch = FetchType.LAZY)
	private AircraftModel modelName;
	@Column
	private String photo; 
	@Column
	private Integer totalFlight;
	@Column
    @Enumerated(value = EnumType.ORDINAL)
	private AircraftState aircraftState;
	
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Flight> flights; 
	
	private String getAircraftsNumber() {
		return aircraftsNumber;
	}
	private void setAircraftsNumber(String aircraftsNumber) {
		this.aircraftsNumber = aircraftsNumber;
	}
	private Date getManufactureDate() {
		return manufactureDate;
	}
	private void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	private Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	private void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	private AircraftModel getModelName() {
		return modelName;
	}
	private void setModelName(AircraftModel modelName) {
		this.modelName = modelName;
	}
	private String getPhoto() {
		return photo;
	}
	private void setPhoto(String photo) {
		this.photo = photo;
	}
	private Integer getTotalFlight() {
		return totalFlight;
	}
	private void setTotalFlight(Integer totalFlight) {
		this.totalFlight = totalFlight;
	}
	private AircraftState getAircraftState() {
		return aircraftState;
	}
	private void setAircraftState(AircraftState aircraftState) {
		this.aircraftState = aircraftState;
	}
	
	
}
