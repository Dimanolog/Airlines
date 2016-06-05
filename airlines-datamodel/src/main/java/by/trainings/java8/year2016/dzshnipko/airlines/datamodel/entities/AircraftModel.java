package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class AircraftModel extends AbstractModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7918513140650976517L;
	@Column
	private String name;
	@Column
	private Integer firstClassSeats;
	@Column
	private Integer secondClassSeats;
	@Column
	private Integer thirdClassSeats;
	@Column
	private Integer maxRange;
	@Column
	private Integer cruisingSpeed;
	@Column
	private Integer maxSpeed;
	@Column
	private Integer maxTransportedCargo;
	@Column
	private Integer maxCargoCapacity;
	@Column
	private Integer serviceCeiling;
	@Column
	private Integer consumPerHour;
	@Column
	private Integer maxFuelCapacity;
	@Column
	private String description;
	@Column
	private Boolean firstPilot;
	@Column
	private Boolean secondPilot;
	@Column
	private Boolean navigator;
	@Column
	private Boolean radioman;
	@Column
	private Boolean flightEngineer;
	@Column
	private Integer stewards;

	@OneToMany(mappedBy="aircraftModel", fetch = FetchType.LAZY)
	private Set<Aircraft> aircrafts;

	public String getName() {
		return name;
	}

	public Integer getFirstClassSeats() {
		return firstClassSeats;
	}

	public Integer getSecondClassSeats() {
		return secondClassSeats;
	}

	public Integer getThirdClassSeats() {
		return thirdClassSeats;
	}

	public Integer getMaxRange() {
		return maxRange;
	}

	public Integer getCruisingSpeed() {
		return cruisingSpeed;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public Integer getMaxTransportedCargo() {
		return maxTransportedCargo;
	}

	public Integer getMaxCargoCapacity() {
		return maxCargoCapacity;
	}

	public Integer getServiceCeiling() {
		return serviceCeiling;
	}

	public Integer getConsumPerHour() {
		return consumPerHour;
	}

	public Integer getMaxFuelCapacity() {
		return maxFuelCapacity;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getFirstPilot() {
		return firstPilot;
	}

	public Boolean getSecondPilot() {
		return secondPilot;
	}

	public Boolean getNavigator() {
		return navigator;
	}

	public Boolean getRadioman() {
		return radioman;
	}

	public Boolean getFlightEngineer() {
		return flightEngineer;
	}

	public Integer getStewards() {
		return stewards;
	}

	public Set<Aircraft> getAircraftsList() {
		return aircrafts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstClassSeats(Integer firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public void setSecondClassSeats(Integer secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}

	public void setThirdClassSeats(Integer thirdClassSeats) {
		this.thirdClassSeats = thirdClassSeats;
	}

	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}

	public void setCruisingSpeed(Integer cruisingSpeed) {
		this.cruisingSpeed = cruisingSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setMaxTransportedCargo(Integer maxTransportedCargo) {
		this.maxTransportedCargo = maxTransportedCargo;
	}

	public void setMaxCargoCapacity(Integer maxCargoCapacity) {
		this.maxCargoCapacity = maxCargoCapacity;
	}

	public void setServiceCeiling(Integer serviceCeiling) {
		this.serviceCeiling = serviceCeiling;
	}

	public void setConsumPerHour(Integer consumPerHour) {
		this.consumPerHour = consumPerHour;
	}

	public void setMaxFuelCapacity(Integer maxFuelCapacity) {
		this.maxFuelCapacity = maxFuelCapacity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFirstPilot(Boolean firstPilot) {
		this.firstPilot = firstPilot;
	}

	public void setSecondPilot(Boolean secondPilot) {
		this.secondPilot = secondPilot;
	}

	public void setNavigator(Boolean navigator) {
		this.navigator = navigator;
	}

	public void setRadioman(Boolean radioman) {
		this.radioman = radioman;
	}

	public void setFlightEngineer(Boolean flightEngineer) {
		this.flightEngineer = flightEngineer;
	}

	public void setStewards(Integer stewards) {
		this.stewards = stewards;
	}

	public void setAircraftsList(Set<Aircraft> aircraftsList) {
		this.aircrafts = aircraftsList;
	}

	
}