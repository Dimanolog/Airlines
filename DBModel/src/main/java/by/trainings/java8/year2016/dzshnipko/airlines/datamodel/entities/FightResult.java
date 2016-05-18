package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.awt.SecondaryLoop;
import java.math.BigDecimal;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.FlightState;

public class FightResult {
	private Flight flight;
	private Integer firstClassPassengers;
	private Integer secondClassPassengers;
	private Integer thirdClassPassengers;
	private Integer cargoWeight;
	private Integer fuelConsumption;
	private FlightState flightState;
	private BigDecimal costs;
	private BigDecimal income;
	private BigDecimal profit;
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Integer getFirstClassPassengers() {
		return firstClassPassengers;
	}
	public void setFirstClassPassengers(Integer firstClassPassengers) {
		this.firstClassPassengers = firstClassPassengers;
	}
	public Integer getSecondClassPassengers() {
		return secondClassPassengers;
	}
	public void setSecondClassPassengers(Integer secondClassPassengers) {
		this.secondClassPassengers = secondClassPassengers;
	}
	public Integer getThirdClassPassengers() {
		return thirdClassPassengers;
	}
	public void setThirdClassPassengers(Integer thirdClassPassengers) {
		this.thirdClassPassengers = thirdClassPassengers;
	}
	public Integer getCargoWeight() {
		return cargoWeight;
	}
	public void setCargoWeight(Integer cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	public Integer getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(Integer fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public FlightState getFlightState() {
		return flightState;
	}
	public void setFlightState(FlightState flightState) {
		this.flightState = flightState;
	}
	public BigDecimal getCosts() {
		return costs;
	}
	public void setCosts(BigDecimal costs) {
		this.costs = costs;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
	
}
