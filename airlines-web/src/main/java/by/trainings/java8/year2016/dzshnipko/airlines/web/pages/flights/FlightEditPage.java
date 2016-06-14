package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.StringValidator;

import com.googlecode.wicket.kendo.ui.form.datetime.DateTimePicker;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.app.AuthorizedSession;
import by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer.AircraftChoiceRenderer;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
@AuthorizeInstantiation("dispatcher")
public class FlightEditPage extends AbstractPage {

	private static final long serialVersionUID = 1L;
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

		Form<Flight> form = new FlightForm<Flight>("flight-form", new CompoundPropertyModel<Flight>(flight));
		add(form);

		List<Aircraft> aircraftsList = aircraftService.find(new AircraftFilter());
		DropDownChoice<Aircraft> aircraftChoice = new DropDownChoice<>("aircraft", aircraftsList,
				AircraftChoiceRenderer.getInstance());
				
		aircraftChoice.setRequired(true);
		form.add(aircraftChoice);

		StringValidator lenthValidator = StringValidator.lengthBetween(1, 50);

		TextField<String> departurePoint = new TextField<>("departurePointName");
		departurePoint.setRequired(true);
		departurePoint.add(lenthValidator);
		form.add(departurePoint);

		TextField<String> departureAirport = new TextField<>("departureAirport");
		departureAirport.setRequired(true);
		departureAirport.add(lenthValidator);
		form.add(departureAirport);

		// DateTimePicker //
		String localeTimePattern = AuthorizedSession.get().getLocaleTimePattern();
		String localeDatePattern = AuthorizedSession.get().getLocaleDatePattern();
		final DateTimePicker departureTimePicker = new DateTimePicker("departureTime", localeDatePattern,
				localeTimePattern);
		departureTimePicker.setRequired(true);
		form.add(departureTimePicker);

		TextField<String> destinanationPoint = new TextField<>("destinationPointName");
		destinanationPoint.setRequired(true);
		destinanationPoint.add(lenthValidator);
		form.add(destinanationPoint);

		TextField<String> destinationAirport = new TextField<>("destinationAirport");
		destinationAirport.setRequired(true);
		destinanationPoint.add(lenthValidator);
		form.add(destinationAirport);

		final DateTimePicker destinationTimePicker = new DateTimePicker("arrivalTime", localeDatePattern,
				localeTimePattern);
		destinationTimePicker.setRequired(true);
		form.add(destinationTimePicker);
		
		form.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				flightService.saveOrUpdate(flight);
				setResponsePage(new FlightsPage());
			}
		});

		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(FlightEditPage.class);
			}
		});
		add(form);
	}

	private class FlightForm<T> extends Form<T> {

		public FlightForm(String id, IModel<T> model) {
			super(id, model);
		}
	}
}
