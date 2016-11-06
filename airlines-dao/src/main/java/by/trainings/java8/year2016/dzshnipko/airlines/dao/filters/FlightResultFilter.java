package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.math.BigDecimal;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.FlightState;

public class FlightResultFilter extends AbstractFilter {
	
	private int  firstClassPassengersMax;
	private int  firstClassPassengersMin;

	private int secondClassPassengersMax;
	private int secondClassPassengersMin;
	
	private int thirdClassPassengersMax;
	private int thirdClassPassengersMin;
	
	private int passegersMax;
	private int passegersMin;
	
	private int cargoWeightMax;
	private int cargoWeightMin;
	
	private int fuelConsumption;
	
	private FlightState flightState;
	
	private BigDecimal costs;
	
	private BigDecimal income;
	
	private BigDecimal profit;
	
	private boolean fetchFlight;

	public int getFirstClassPassengersMax() {
		return firstClassPassengersMax;
	}

	public int getFirstClassPassengersMin() {
		return firstClassPassengersMin;
	}

	public int getSecondClassPassengersMax() {
		return secondClassPassengersMax;
	}

	public int getSecondClassPassengersMin() {
		return secondClassPassengersMin;
	}

	public int getThirdClassPassengersMax() {
		return thirdClassPassengersMax;
	}

	public int getThirdClassPassengersMin() {
		return thirdClassPassengersMin;
	}

	public int getPassegersMax() {
		return passegersMax;
	}

	public int getPassegersMin() {
		return passegersMin;
	}

	public int getCargoWeightMax() {
		return cargoWeightMax;
	}

	public int getCargoWeightMin() {
		return cargoWeightMin;
	}

	public int getFuelConsumption() {
		return fuelConsumption;
	}

	public FlightState getFlightState() {
		return flightState;
	}

	public BigDecimal getCosts() {
		return costs;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setFirstClassPassengersMax(int firstClassPassengersMax) {
		this.firstClassPassengersMax = firstClassPassengersMax;
	}

	public void setFirstClassPassengersMin(int firstClassPassengersMin) {
		this.firstClassPassengersMin = firstClassPassengersMin;
	}

	public void setSecondClassPassengersMax(int secondClassPassengersMax) {
		this.secondClassPassengersMax = secondClassPassengersMax;
	}

	public void setSecondClassPassengersMin(int secondClassPassengersMin) {
		this.secondClassPassengersMin = secondClassPassengersMin;
	}

	public void setThirdClassPassengersMax(int thirdClassPassengersMax) {
		this.thirdClassPassengersMax = thirdClassPassengersMax;
	}

	public void setThirdClassPassengersMin(int thirdClassPassengersMin) {
		this.thirdClassPassengersMin = thirdClassPassengersMin;
	}

	public void setPassegersMax(int passegersMax) {
		this.passegersMax = passegersMax;
	}

	public void setPassegersMin(int passegersMin) {
		this.passegersMin = passegersMin;
	}

	public void setCargoWeightMax(int cargoWeightMax) {
		this.cargoWeightMax = cargoWeightMax;
	}

	public void setCargoWeightMin(int cargoWeightMin) {
		this.cargoWeightMin = cargoWeightMin;
	}

	public void setFuelConsumption(int fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public void setFlightState(FlightState flightState) {
		this.flightState = flightState;
	}

	public void setCosts(BigDecimal costs) {
		this.costs = costs;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public boolean isFetchFlight() {
		return fetchFlight;
	}

	public void setFetchFlight(boolean fetchFlight) {
		this.fetchFlight = fetchFlight;
	}
}
