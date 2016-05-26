package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Incident extends AbstractModel
{
	@ManyToOne(fetch = FetchType.LAZY)
	private Flight flight;
	@Column
	private Date time;
	@Column
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
