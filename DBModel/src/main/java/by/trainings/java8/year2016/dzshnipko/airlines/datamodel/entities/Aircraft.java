package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.AircraftState;

public class Aircraft {
	private String aircraftsNumber;
	private Date  manufactureDate;
	private Date dateOfPurchase;
	private AircraftModel modelName;
	private String photo; 
	private Integer totalFlight;
	private AircraftState aircraftState;
	
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
