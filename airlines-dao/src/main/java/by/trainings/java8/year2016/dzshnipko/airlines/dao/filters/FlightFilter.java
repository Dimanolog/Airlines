package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.util.Date;

public class FlightFilter extends AbstractFilter {
	
	
	private String departurePointName;
	
	private String departureAirport;
	
	private Date departureTimeMax;
	private Date departureTimeMin; 
	
	private String destinationPointName;
	
	private String destinationAirport;
	
	private Date arrivalTimeMax;
	private Date arrivalTimeMin;
	
	private boolean fetchRoutePoints;
		
	private boolean fetchFlightResult;
	
	private boolean fetchEmployees;

	public String getDeparturePointName() {
		return departurePointName;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public Date getDepartureTimeMax() {
		return departureTimeMax;
	}

	public Date getDepartureTimeMin() {
		return departureTimeMin;
	}

	public String getDestinationPointName() {
		return destinationPointName;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public Date getАrrivalTimeMax() {
		return arrivalTimeMax;
	}

	public Date getАrrivalTimeMin() {
		return arrivalTimeMin;
	}

	public boolean isFetchRoutePoints() {
		return fetchRoutePoints;
	}

	public boolean isFetchFlightResult() {
		return fetchFlightResult;
	}

	public boolean isFetchEmployees() {
		return fetchEmployees;
	}

	public void setDeparturePointName(String departurePointName) {
		this.departurePointName = departurePointName;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public void setDepartureTimeMax(Date departureTimeMax) {
		this.departureTimeMax = departureTimeMax;
	}

	public void setDepartureTimeMin(Date departureTimeMin) {
		this.departureTimeMin = departureTimeMin;
	}

	public void setDestinationPointName(String destinationPointName) {
		this.destinationPointName = destinationPointName;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public void setАrrivalTimeMax(Date arrivalTimeMax) {
		this.arrivalTimeMax = arrivalTimeMax;
	}

	public void setАrrivalTimeMin(Date arrivalTimeMin) {
		this.arrivalTimeMin = arrivalTimeMin;
	}

	public void setFetchRoutePoints(boolean fetchRoutePoints) {
		this.fetchRoutePoints = fetchRoutePoints;
	}

	public void setFetchFlightResult(boolean fetchFlightResult) {
		this.fetchFlightResult = fetchFlightResult;
	}

	public void setFetchEmployees(boolean fetchEmployees) {
		this.fetchEmployees = fetchEmployees;
	}
		
}
