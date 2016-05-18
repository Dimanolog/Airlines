package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.io.Serializable;
import java.util.HashSet;

public class AircraftModel implements Serializable{
	
	private String name;
	private String firstClassSeats;
	private String secondClassSeats; 
	private String thirdClassSeats;
	private Integer maxRange;
	private Integer cruisingSpeed;
	private Integer maxSpeed;
	private Integer maxTransportedCargo;
	private Integer maxCargoCapacity;
	private Integer serviceCeiling;
	private Integer consumPerHour;
	private Integer мaxFuelCapacity;
	private String  description;
	private Boolean	firstPilot;
	private Boolean secondPilot;
	private Boolean navigator;
	private Boolean radioman;
	private Boolean flightEngineer;
	private Integer stewards;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstClassSeats() {
		return firstClassSeats;
	}
	public void setFirstClassSeats(String firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}
	public String getSecondClassSeats() {
		return secondClassSeats;
	}
	public void setSecondClassSeats(String secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}
	public String getThirdClassSeats() {
		return thirdClassSeats;
	}
	public void setThirdClassSeats(String thirdClassSeats) {
		this.thirdClassSeats = thirdClassSeats;
	}
	public Integer getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
	public Integer getCruisingSpeed() {
		return cruisingSpeed;
	}
	public void setCruisingSpeed(Integer cruisingSpeed) {
		this.cruisingSpeed = cruisingSpeed;
	}
	public Integer getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public Integer getMaxTransportedCargo() {
		return maxTransportedCargo;
	}
	public void setMaxTransportedCargo(Integer maxTransportedCargo) {
		this.maxTransportedCargo = maxTransportedCargo;
	}
	public Integer getMaxCargoCapacity() {
		return maxCargoCapacity;
	}
	public void setMaxCargoCapacity(Integer maxCargoCapacity) {
		this.maxCargoCapacity = maxCargoCapacity;
	}
	public Integer getServiceCeiling() {
		return serviceCeiling;
	}
	public void setServiceCeiling(Integer serviceCeiling) {
		this.serviceCeiling = serviceCeiling;
	}
	public Integer getConsumPerHour() {
		return consumPerHour;
	}
	public void setConsumPerHour(Integer consumPerHour) {
		this.consumPerHour = consumPerHour;
	}
	public Integer getМaxFuelCapacity() {
		return мaxFuelCapacity;
	}
	public void setМaxFuelCapacity(Integer мaxFuelCapacity) {
		this.мaxFuelCapacity = мaxFuelCapacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getFirstPilot() {
		return firstPilot;
	}
	public void setFirstPilot(Boolean firstPilot) {
		this.firstPilot = firstPilot;
	}
	public Boolean getSecondPilot() {
		return secondPilot;
	}
	public void setSecondPilot(Boolean secondPilot) {
		this.secondPilot = secondPilot;
	}
	public Boolean getNavigator() {
		return navigator;
	}
	public void setNavigator(Boolean navigator) {
		this.navigator = navigator;
	}
	public Boolean getRadioman() {
		return radioman;
	}
	public void setRadioman(Boolean radioman) {
		this.radioman = radioman;
	}
	public Boolean getFlightEngineer() {
		return flightEngineer;
	}
	public void setFlightEngineer(Boolean flightEngineer) {
		this.flightEngineer = flightEngineer;
	}
	public Integer getStewards() {
		return stewards;
	}
	public void setStewards(Integer stewards) {
		this.stewards = stewards;
	}
}