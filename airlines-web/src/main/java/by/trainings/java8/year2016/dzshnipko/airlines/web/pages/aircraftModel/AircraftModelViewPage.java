package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircraftModel;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;

public class AircraftModelViewPage extends AbstractPage {
	
	private static final long serialVersionUID = 1L;
	private AircraftModel aircraftModel;
	public AircraftModelViewPage(AircraftModel aircraftModel) {
		super();
		this.aircraftModel=aircraftModel;
	}

	public AircraftModelViewPage(PageParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

}
