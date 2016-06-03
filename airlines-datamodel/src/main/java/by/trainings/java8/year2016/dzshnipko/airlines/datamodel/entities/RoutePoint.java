package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class RoutePoint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5982538076955983693L;
	@Id
	private Integer pointNumder;
	@Column
	private Double latitude;
	@Column
	private Double longitude;
	@Column
	private Integer altitude;
	@Column
	private Date time;
	@Column
	private String pointName;
	@Column
	private Boolean refuelLanding;
	
	public Integer getPointNumder() {
		return pointNumder;
	}
	public void setPointNumder(Integer pointNumder) {
		this.pointNumder = pointNumder;
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
