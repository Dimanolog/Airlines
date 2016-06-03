package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1754747029755323991L;
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
	private Date arrivalTime;
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

	public String getDeparturePointName() {
		return departurePointName;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public String getDestinationPointName() {
		return destinationPointName;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public Date getАrrivalTime() {
		return arrivalTime;
	}

	public Set<RoutePoint> getRoute() {
		return route;
	}

	public FlightResult getFlightResult() {
		return flightResult;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setDeparturePointName(String departurePointName) {
		this.departurePointName = departurePointName;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public void setDestinationPointName(String destinationPointName) {
		this.destinationPointName = destinationPointName;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public void setАrrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setRoute(Set<RoutePoint> route) {
		this.route = route;
	}

	public void setFlightResult(FlightResult flightResult) {
		this.flightResult = flightResult;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getDeparturePoint(){
			
		return String.format("%s (%s)", departurePointName, departureAirport);
		
	}
	
	public String getDestinationPoint(){
		
		return String.format("%s (%s)", destinationPointName, destinationAirport);
		
	}

	
}
