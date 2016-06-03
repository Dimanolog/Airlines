package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights.panel.FlightListPanel;

public class FlightsPage extends WebPage {

	public FlightsPage() {
		super();
		add(new FlightListPanel("list-panel"));

		add(new Link("create") {
			@Override
			public void onClick() {
				setResponsePage(new FlightEditPage(new Flight()));
			}
		});

	}

}
