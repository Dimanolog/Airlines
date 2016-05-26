package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.util.Date;

public class IncidentFilter {

	private Date timeMax;

	private Date timeMin;

	public Date getTimeMax() {
		return timeMax;
	}

	public Date getTimeMin() {
		return timeMin;
	}

	public void setTimeMax(Date timeMax) {
		this.timeMax = timeMax;
	}

	public void setTimeMin(Date timeMin) {
		this.timeMin = timeMin;
	}

}
