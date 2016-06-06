package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.googlecode.wicket.kendo.ui.form.datetime.DateTimePicker;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer.AircraftChoiceRenderer;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;

public class FlightEditPage extends AbstractPage {

	@Inject
	private FlightService flightService;
	@Inject
	private AircraftService aircraftService;

	private Flight flight;

	public FlightEditPage(PageParameters parameters) {
		super(parameters);
	}

	public FlightEditPage(Flight flight) {
		super();
		this.flight = flight;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Flight> form = new FlightForm<Flight>("form", new CompoundPropertyModel<Flight>(flight));
		add(form);

		List<Aircraft> aircraftsList = aircraftService.find(new AircraftFilter());
		DropDownChoice<Aircraft> aircraftChoice = new DropDownChoice<>("aircraft", aircraftsList,
				AircraftChoiceRenderer.getInstance());
		form.add(aircraftChoice);

		TextField<String> departurePoint = new TextField<>("departurePointName");
		departurePoint.setRequired(true);
		form.add(departurePoint);

		TextField<String> departureAirport = new TextField<>("departureAirport");
		departureAirport.setRequired(true);
		form.add(departureAirport);

		// basePriceField.add(RangeValidator.<Double> range(0d, 1_000_000d));
		// basePriceField.setLabel(new ResourceModel("products.price"));
		// basePriceField.setRequired(true);

		// FeedbackPanel //
		final KendoFeedbackPanel feedback = new KendoFeedbackPanel("feedback");
		form.add(feedback);

		// DateTimePicker //
		final DateTimePicker departureTimePicker = new DateTimePicker("departureTime");
		departureTimePicker.setRequired(true);
		form.add(departureTimePicker);

		TextField<String> destinanationPoint = new TextField<>("destinationPointName");
		destinanationPoint.setRequired(true);
		form.add(departurePoint);

		TextField<String> destinationAirport = new TextField<>("destinationAirport");
		destinationAirport.setRequired(true);
		form.add(destinationAirport);

		final DateTimePicker destinationTimePicker = new DateTimePicker("arrivalTime");
		destinationTimePicker.setRequired(true);
		form.add(destinationTimePicker);

		form.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();

				flightService.saveOrUpdate(flight);

				// String localizedMessage = getString("product.saved");
				// page.info(localizedMessage);

				setResponsePage(new FlightsPage());
			}
		});

		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(FlightEditPage.class);
			}
		});

		add(new FeedbackPanel("feedback"));

	}

	private class FlightForm<T> extends Form<T> {

		public FlightForm(String id, IModel<T> model) {
			super(id, model);
		}
	}
}
