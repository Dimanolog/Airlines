package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class AircraftModel extends AbstractModel {
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
	private Integer мaxFuelCapacity;
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

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Aircraft> aircraftsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(Integer firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public Integer getSecondClassSeats() {
		return secondClassSeats;
	}

	public void setSecondClassSeats(Integer secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}

	public Integer getThirdClassSeats() {
		return thirdClassSeats;
	}

	public void setThirdClassSeats(Integer thirdClassSeats) {
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