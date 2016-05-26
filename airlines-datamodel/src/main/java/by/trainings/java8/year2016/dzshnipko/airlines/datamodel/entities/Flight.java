package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class Flight extends AbstractModel
{
	@ManyToOne(fetch = FetchType.LAZY)
	private Aircraft aircraft;
	@Column
	private String departurePointName;
	@Column
	private String departureAirport;
	@Column
	private Date departureTime; 
	@Column
	private String destinationPointName;
	@Column
	private String destinationAirport;
	@Column
	private Date аrrivalTime;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<RoutePoint> route;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private FlightResult flightResult;
	
	@ManyToMany(targetEntity = Employee.class, fetch = FetchType.LAZY)
	private Set<Employee> employees;
	
	
	
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
	public Set<RoutePoint> getRoute() {
		return route;
	}
	public void setRoute(Set<RoutePoint> route) {
		this.route = route;
	}
	
	


}
