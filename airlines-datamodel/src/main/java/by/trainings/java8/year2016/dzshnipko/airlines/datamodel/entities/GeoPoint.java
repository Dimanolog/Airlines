package by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities;

public class GeoPoint extends AbstractModel {
	
	private static final long serialVersionUID = 1L;
	private String country;
	private String city;
	private String airport;

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAirport() {
		return airport;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

}
