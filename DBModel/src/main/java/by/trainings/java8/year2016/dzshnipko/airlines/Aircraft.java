package by.trainings.java8.year2016.dzshnipko.airlines;

import java.util.HashSet;

public class Aircraft extends AbstractModel{
	
private String aircraftNumber;
private String name;
private Integer numberOfSeats;
private Integer maxRange;
private Integer cruisingSpeed;
private Integer maxSpeed;
private Integer maxTransportedCargo;
private Integer maxCargoCapacity;
private Integer serviceCeiling;
private HashSet<AicraftCrew> airCraftCrew;


public String getAircraftNumber() {
	return aircraftNumber;
}
public void setAircraftNumber(String aircraftNumber) {
	this.aircraftNumber = aircraftNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getNumberOfSeats() {
	return numberOfSeats;
}
public void setNumberOfSeats(Integer numberOfSeats) {
	this.numberOfSeats = numberOfSeats;
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
public HashSet<AicraftCrew> getAirCraftCrew() {
	return airCraftCrew;
}
public void setAirCraftCrew(HashSet<AicraftCrew> airCraftCrew) {
	this.airCraftCrew = airCraftCrew;
} 


}
