package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.io.Serializable;
import java.util.Date;

public class Incidents implements Serializable {
	private Flight flight;
	private Date time;
	private String descriptions;
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	} 
	
	
}
