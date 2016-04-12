package by.trainings.java8.year2016.dzshnipko.airlines;

import java.util.Date;
import java.util.HashSet;

public class Flight extends AbstractModel
{
	private Aircraft aircraft;
	private String departurePointName;
	private String departureAirport;
	private Date departureTime; 
	private String destinationPointName;
	private String destinationAirport;
	private Date аrrivalTime;
	private HashSet<RoutePoint> route;
	
	
	public Aircraft getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public String getDeparturePointName() {
		return departurePointName;
	}
	public void setDeparturePointName(String departurePointName) {
		this.departurePointName = departurePointName;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestinationPointName() {
		return destinationPointName;
	}
	public void setDestinationPointName(String destinationPointName) {
		this.destinationPointName = destinationPointName;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public Date getАrrivalTime() {
		return аrrivalTime;
	}
	public void setАrrivalTime(Date аrrivalTime) {
		this.аrrivalTime = аrrivalTime;
	}
	public HashSet<RoutePoint> getRoute() {
		return route;
	}
	public void setRoute(HashSet<RoutePoint> route) {
		this.route = route;
	}

}
