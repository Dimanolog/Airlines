package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import javax.persistence.Column;

public class AircraftModelFilter extends AbstractFilter {

	private String name;

	private Integer firstClassSeatsMax;
	private Integer firstClassSeatsMin;
	
	private Integer secondClassSeatsMax;
	private Integer secondClassSeatsMin;

	private Integer thirdClassSeatsMax;
	private Integer thirdClassSeatsMin;

	private Integer maxPassegersMax;
	private Integer maxPassegersMin;

	private Integer maxRangeMax;
	private Integer maxRangeMin;

	private Integer cruisingSpeedMax;
	private Integer cruisingSpeedMin;

	private Integer maxTransportedCargoMin;
	private Integer maxTransportedCargoMax;

	private Integer maxCargoCapacityMin;
	private Integer maxCargoCapacityMax;
	
	private Integer serviceCeiling;

	private Integer consumPerHourMax;
	private Integer consumPerHourMin;

	private Integer  maxFuelCapacity;
	
	private boolean isFetchAircrafts;

	public String getName() {
		return name;
	}

	public Integer getFirstClassSeatsMax() {
		return firstClassSeatsMax;
	}

	public Integer getFirstClassSeatsMin() {
		return firstClassSeatsMin;
	}

	public Integer getSecondClassSeatsMax() {
		return secondClassSeatsMax;
	}

	public Integer getSecondClassSeatsMin() {
		return secondClassSeatsMin;
	}

	public Integer getThirdClassSeatsMax() {
		return thirdClassSeatsMax;
	}

	public Integer getThirdClassSeatsMin() {
		return thirdClassSeatsMin;
	}

	public Integer getMaxPassegersMax() {
		return maxPassegersMax;
	}

	public Integer getMaxPassegersMin() {
		return maxPassegersMin;
	}

	public Integer getMaxRangeMax() {
		return maxRangeMax;
	}

	public Integer getMaxRangeMin() {
		return maxRangeMin;
	}

	public Integer getCruisingSpeedMax() {
		return cruisingSpeedMax;
	}

	public Integer getCruisingSpeedMin() {
		return cruisingSpeedMin;
	}

	public Integer getMaxTransportedCargoMin() {
		return maxTransportedCargoMin;
	}

	public Integer getMaxTransportedCargoMax() {
		return maxTransportedCargoMax;
	}

	public Integer getMaxCargoCapacityMin() {
		return maxCargoCapacityMin;
	}

	public Integer getMaxCargoCapacityMax() {
		return maxCargoCapacityMax;
	}

	public Integer getServiceCeiling() {
		return serviceCeiling;
	}

	public Integer getConsumPerHourMax() {
		return consumPerHourMax;
	}

	public Integer getConsumPerHourMin() {
		return consumPerHourMin;
	}

	public Integer getMaxFuelCapacity() {
		return maxFuelCapacity;
	}

	public boolean isFetchAircrafts() {
		return isFetchAircrafts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstClassSeatsMax(Integer firstClassSeatsMax) {
		this.firstClassSeatsMax = firstClassSeatsMax;
	}

	public void setFirstClassSeatsMin(Integer firstClassSeatsMin) {
		this.firstClassSeatsMin = firstClassSeatsMin;
	}

	public void setSecondClassSeatsMax(Integer secondClassSeatsMax) {
		this.secondClassSeatsMax = secondClassSeatsMax;
	}

	public void setSecondClassSeatsMin(Integer secondClassSeatsMin) {
		this.secondClassSeatsMin = secondClassSeatsMin;
	}

	public void setThirdClassSeatsMax(Integer thirdClassSeatsMax) {
		this.thirdClassSeatsMax = thirdClassSeatsMax;
	}

	public void setThirdClassSeatsMin(Integer thirdClassSeatsMin) {
		this.thirdClassSeatsMin = thirdClassSeatsMin;
	}

	public void setMaxPassegersMax(Integer maxPassegersMax) {
		this.maxPassegersMax = maxPassegersMax;
	}

	public void setMaxPassegersMin(Integer maxPassegersMin) {
		this.maxPassegersMin = maxPassegersMin;
	}

	public void setMaxRangeMax(Integer maxRangeMax) {
		this.maxRangeMax = maxRangeMax;
	}

	public void setMaxRangeMin(Integer maxRangeMin) {
		this.maxRangeMin = maxRangeMin;
	}

	public void setCruisingSpeedMax(Integer cruisingSpeedMax) {
		this.cruisingSpeedMax = cruisingSpeedMax;
	}

	public void setCruisingSpeedMin(Integer cruisingSpeedMin) {
		this.cruisingSpeedMin = cruisingSpeedMin;
	}

	public void setMaxTransportedCargoMin(Integer maxTransportedCargoMin) {
		this.maxTransportedCargoMin = maxTransportedCargoMin;
	}

	public void setMaxTransportedCargoMax(Integer maxTransportedCargoMax) {
		this.maxTransportedCargoMax = maxTransportedCargoMax;
	}

	public void setMaxCargoCapacityMin(Integer maxCargoCapacityMin) {
		this.maxCargoCapacityMin = maxCargoCapacityMin;
	}

	public void setMaxCargoCapacityMax(Integer maxCargoCapacityMax) {
		this.maxCargoCapacityMax = maxCargoCapacityMax;
	}

	public void setServiceCeiling(Integer serviceCeiling) {
		this.serviceCeiling = serviceCeiling;
	}

	public void setConsumPerHourMax(Integer consumPerHourMax) {
		this.consumPerHourMax = consumPerHourMax;
	}

	public void setConsumPerHourMin(Integer consumPerHourMin) {
		this.consumPerHourMin = consumPerHourMin;
	}

	public void setMaxFuelCapacity(Integer maxFuelCapacity) {
		this.maxFuelCapacity = maxFuelCapacity;
	}

	public void setFetchAircrafts(boolean isFetchAircrafts) {
		this.isFetchAircrafts = isFetchAircrafts;
	}

}