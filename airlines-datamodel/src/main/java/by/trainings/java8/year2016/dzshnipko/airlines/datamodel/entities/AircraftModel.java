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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aircrafts == null) ? 0 : aircrafts.hashCode());
		result = prime * result + ((consumPerHour == null) ? 0 : consumPerHour.hashCode());
		result = prime * result + ((cruisingSpeed == null) ? 0 : cruisingSpeed.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstClassSeats == null) ? 0 : firstClassSeats.hashCode());
		result = prime * result + ((firstPilot == null) ? 0 : firstPilot.hashCode());
		result = prime * result + ((flightEngineer == null) ? 0 : flightEngineer.hashCode());
		result = prime * result + ((maxCargoCapacity == null) ? 0 : maxCargoCapacity.hashCode());
		result = prime * result + ((maxFuelCapacity == null) ? 0 : maxFuelCapacity.hashCode());
		result = prime * result + ((maxRange == null) ? 0 : maxRange.hashCode());
		result = prime * result + ((maxSpeed == null) ? 0 : maxSpeed.hashCode());
		result = prime * result + ((maxTransportedCargo == null) ? 0 : maxTransportedCargo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((navigator == null) ? 0 : navigator.hashCode());
		result = prime * result + ((radioman == null) ? 0 : radioman.hashCode());
		result = prime * result + ((secondClassSeats == null) ? 0 : secondClassSeats.hashCode());
		result = prime * result + ((secondPilot == null) ? 0 : secondPilot.hashCode());
		result = prime * result + ((serviceCeiling == null) ? 0 : serviceCeiling.hashCode());
		result = prime * result + ((stewards == null) ? 0 : stewards.hashCode());
		result = prime * result + ((thirdClassSeats == null) ? 0 : thirdClassSeats.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AircraftModel other = (AircraftModel) obj;
		if (aircrafts == null) {
			if (other.aircrafts != null)
				return false;
		} else if (!aircrafts.equals(other.aircrafts))
			return false;
		if (consumPerHour == null) {
			if (other.consumPerHour != null)
				return false;
		} else if (!consumPerHour.equals(other.consumPerHour))
			return false;
		if (cruisingSpeed == null) {
			if (other.cruisingSpeed != null)
				return false;
		} else if (!cruisingSpeed.equals(other.cruisingSpeed))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstClassSeats == null) {
			if (other.firstClassSeats != null)
				return false;
		} else if (!firstClassSeats.equals(other.firstClassSeats))
			return false;
		if (firstPilot == null) {
			if (other.firstPilot != null)
				return false;
		} else if (!firstPilot.equals(other.firstPilot))
			return false;
		if (flightEngineer == null) {
			if (other.flightEngineer != null)
				return false;
		} else if (!flightEngineer.equals(other.flightEngineer))
			return false;
		if (maxCargoCapacity == null) {
			if (other.maxCargoCapacity != null)
				return false;
		} else if (!maxCargoCapacity.equals(other.maxCargoCapacity))
			return false;
		if (maxFuelCapacity == null) {
			if (other.maxFuelCapacity != null)
				return false;
		} else if (!maxFuelCapacity.equals(other.maxFuelCapacity))
			return false;
		if (maxRange == null) {
			if (other.maxRange != null)
				return false;
		} else if (!maxRange.equals(other.maxRange))
			return false;
		if (maxSpeed == null) {
			if (other.maxSpeed != null)
				return false;
		} else if (!maxSpeed.equals(other.maxSpeed))
			return false;
		if (maxTransportedCargo == null) {
			if (other.maxTransportedCargo != null)
				return false;
		} else if (!maxTransportedCargo.equals(other.maxTransportedCargo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (navigator == null) {
			if (other.navigator != null)
				return false;
		} else if (!navigator.equals(other.navigator))
			return false;
		if (radioman == null) {
			if (other.radioman != null)
				return false;
		} else if (!radioman.equals(other.radioman))
			return false;
		if (secondClassSeats == null) {
			if (other.secondClassSeats != null)
				return false;
		} else if (!secondClassSeats.equals(other.secondClassSeats))
			return false;
		if (secondPilot == null) {
			if (other.secondPilot != null)
				return false;
		} else if (!secondPilot.equals(other.secondPilot))
			return false;
		if (serviceCeiling == null) {
			if (other.serviceCeiling != null)
				return false;
		} else if (!serviceCeiling.equals(other.serviceCeiling))
			return false;
		if (stewards == null) {
			if (other.stewards != null)
				return false;
		} else if (!stewards.equals(other.stewards))
			return false;
		if (thirdClassSeats == null) {
			if (other.thirdClassSeats != null)
				return false;
		} else if (!thirdClassSeats.equals(other.thirdClassSeats))
			return false;
		return true;
	}

	
}