package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import javax.persistence.Column;

public class AircraftModelFilter extends AbstractFilter {

	private String name;

	private int firstClassSeatsMax;
	private int firstClassSeatsMin;
	
	private int secondClassSeatsMax;
	private int secondClassSeatsMin;

	private int thirdClassSeatsMax;
	private int thirdClassSeatsMin;

	private int maxPassegersMax;
	private int maxPassegersMin;

	private int maxRangeMax;
	private int maxRangeMin;

	private int cruisingSpeedMax;
	private int cruisingSpeedMin;

	private int maxTransportedCargoMin;
	private int maxTransportedCargoMax;

	private int maxCargoCapacityMin;
	private int maxCargoCapacityMax;
	
	private int serviceCeiling;

	private int consumPerHourMax;
	private int consumPerHourMin;

	private int  maxFuelCapacity;
	
	private boolean isFetchAircrafts;

	public String getName() {
		return name;
	}

	public int getFirstClassSeatsMax() {
		return firstClassSeatsMax;
	}

	public int getFirstClassSeatsMin() {
		return firstClassSeatsMin;
	}

	public int getSecondClassSeatsMax() {
		return secondClassSeatsMax;
	}

	public int getSecondClassSeatsMin() {
		return secondClassSeatsMin;
	}

	public int getThirdClassSeatsMax() {
		return thirdClassSeatsMax;
	}

	public int getThirdClassSeatsMin() {
		return thirdClassSeatsMin;
	}

	public int getMaxPassegersMax() {
		return maxPassegersMax;
	}

	public int getMaxPassegersMin() {
		return maxPassegersMin;
	}

	public int getMaxRangeMax() {
		return maxRangeMax;
	}

	public int getMaxRangeMin() {
		return maxRangeMin;
	}

	public int getCruisingSpeedMax() {
		return cruisingSpeedMax;
	}

	public int getCruisingSpeedMin() {
		return cruisingSpeedMin;
	}

	public int getMaxTransportedCargoMin() {
		return maxTransportedCargoMin;
	}

	public int getMaxTransportedCargoMax() {
		return maxTransportedCargoMax;
	}

	public int getMaxCargoCapacityMin() {
		return maxCargoCapacityMin;
	}

	public int getMaxCargoCapacityMax() {
		return maxCargoCapacityMax;
	}

	public int getServiceCeiling() {
		return serviceCeiling;
	}

	public int getConsumPerHourMax() {
		return consumPerHourMax;
	}

	public int getConsumPerHourMin() {
		return consumPerHourMin;
	}

	public int getМaxFuelCapacity() {
		return maxFuelCapacity;
	}

	public boolean isFetchAircrafts() {
		return isFetchAircrafts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstClassSeatsMax(int firstClassSeatsMax) {
		this.firstClassSeatsMax = firstClassSeatsMax;
	}

	public void setFirstClassSeatsMin(int firstClassSeatsMin) {
		this.firstClassSeatsMin = firstClassSeatsMin;
	}

	public void setSecondClassSeatsMax(int secondClassSeatsMax) {
		this.secondClassSeatsMax = secondClassSeatsMax;
	}

	public void setSecondClassSeatsMin(int secondClassSeatsMin) {
		this.secondClassSeatsMin = secondClassSeatsMin;
	}

	public void setThirdClassSeatsMax(int thirdClassSeatsMax) {
		this.thirdClassSeatsMax = thirdClassSeatsMax;
	}

	public void setThirdClassSeatsMin(int thirdClassSeatsMin) {
		this.thirdClassSeatsMin = thirdClassSeatsMin;
	}

	public void setMaxPassegersMax(int maxPassegersMax) {
		this.maxPassegersMax = maxPassegersMax;
	}

	public void setMaxPassegersMin(int maxPassegersMin) {
		this.maxPassegersMin = maxPassegersMin;
	}

	public void setMaxRangeMax(int maxRangeMax) {
		this.maxRangeMax = maxRangeMax;
	}

	public void setMaxRangeMin(int maxRangeMin) {
		this.maxRangeMin = maxRangeMin;
	}

	public void setCruisingSpeedMax(int cruisingSpeedMax) {
		this.cruisingSpeedMax = cruisingSpeedMax;
	}

	public void setCruisingSpeedMin(int cruisingSpeedMin) {
		this.cruisingSpeedMin = cruisingSpeedMin;
	}

	public void setMaxTransportedCargoMin(int maxTransportedCargoMin) {
		this.maxTransportedCargoMin = maxTransportedCargoMin;
	}

	public void setMaxTransportedCargoMax(int maxTransportedCargoMax) {
		this.maxTransportedCargoMax = maxTransportedCargoMax;
	}

	public void setMaxCargoCapacityMin(int maxCargoCapacityMin) {
		this.maxCargoCapacityMin = maxCargoCapacityMin;
	}

	public void setMaxCargoCapacityMax(int maxCargoCapacityMax) {
		this.maxCargoCapacityMax = maxCargoCapacityMax;
	}

	public void setServiceCeiling(int serviceCeiling) {
		this.serviceCeiling = serviceCeiling;
	}

	public void setConsumPerHourMax(int consumPerHourMax) {
		this.consumPerHourMax = consumPerHourMax;
	}

	public void setConsumPerHourMin(int consumPerHourMin) {
		this.consumPerHourMin = consumPerHourMin;
	}

	public void setМaxFuelCapacity(int maxFuelCapacity) {
		this.maxFuelCapacity = maxFuelCapacity;
	}

	public void setFetchAircrafts(boolean isFetchAircrafts) {
		this.isFetchAircrafts = isFetchAircrafts;
	}

	

}