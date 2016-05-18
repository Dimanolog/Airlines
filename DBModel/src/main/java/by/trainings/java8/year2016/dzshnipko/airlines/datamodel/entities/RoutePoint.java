package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.util.Date;

public class RoutePoint {
	
	private Integer pointNumder;
	private Flight flight;
	private Double latitude;
	private Double longitude;
	private Integer altitude;
	private Date time;
	private String pointName;
	private Boolean refuelLanding;
	
	public Integer getPointNumder() {
		return pointNumder;
	}
	public void setPointNumder(Integer pointNumder) {
		this.pointNumder = pointNumder;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getAltitude() {
		return altitude;
	}
	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public Boolean getRefuelLanding() {
		return refuelLanding;
	}
	public void setRefuelLanding(Boolean refuelLanding) {
		this.refuelLanding = refuelLanding;
	}
	
	

}
