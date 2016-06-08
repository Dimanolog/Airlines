package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts;

import org.apache.wicket.markup.html.link.Link;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts.panel.AircraftListPanel;

public class AircraftPage extends AbstractPage {

	public AircraftPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AircraftListPanel("list-panel"));
		add(new Link("create") {
			@Override
			public void onClick() {
				setResponsePage(new AircraftEditPage(new Aircraft(), false));
			}
		});
	}

}