package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.util.Date;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.AircraftState;

public class AircraftFilter extends AbstractFilter{
	private String aircraftsNumber;
	private AircraftModel aircraftModel;
	private AircraftState aircraftState;
	private Integer totalFlightMax;
	private Integer totalFlightMin;
	private Date  manufactureDateMax;
	private Date  manufactureDateMin;
	private Date dateOfPurchaseMax;
	private Date dateOfPurchaseMin;
	private boolean isFetchFlights;
	
	public String getAircraftsNumber() {
		return aircraftsNumber;
	}
	public void setAircraftsNumber(String aircraftsNumber) {
		this.aircraftsNumber = aircraftsNumber;
	}
	public AircraftModel getAircraftModel() {
		return aircraftModel;
	}
	public boolean isFetchFlights() {
		return isFetchFlights;
	}
	public void setFetchFlights(boolean isFetchFlights) {
		this.isFetchFlights = isFetchFlights;
	}
	public void setAircraftModel(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
	}
	public AircraftState getAircraftState() {
		return aircraftState;
	}
	public void setAircraftState(AircraftState aircraftState) {
		this.aircraftState = aircraftState;
	}
	public Integer getTotalFlightMax() {
		return totalFlightMax;
	}
	public void setTotalFlightMax(Integer totalFlightMax) {
		this.totalFlightMax = totalFlightMax;
	}
	public Integer getTotalFlightMin() {
		return totalFlightMin;
	}
	public void setTotalFlightMin(Integer totalFlightMin) {
		this.totalFlightMin = totalFlightMin;
	}
	public Date getManufactureDateMax() {
		return manufactureDateMax;
	}
	public void setManufactureDateMax(Date manufactureDateMax) {
		this.manufactureDateMax = manufactureDateMax;
	}
	public Date getManufactureDateMin() {
		return manufactureDateMin;
	}
	public void setManufactureDateMin(Date manufactureDateMin) {
		this.manufactureDateMin = manufactureDateMin;
	}
	public Date getDateOfPurchaseMax() {
		return dateOfPurchaseMax;
	}
	public void setDateOfPurchaseMax(Date dateOfPurchaseMax) {
		this.dateOfPurchaseMax = dateOfPurchaseMax;
	}
	public Date getDateOfPurchaseMin() {
		return dateOfPurchaseMin;
	}
	public void setDateOfPurchaseMin(Date dateOfPurchaseMin) {
		this.dateOfPurchaseMin = dateOfPurchaseMin;
	}
	
}
