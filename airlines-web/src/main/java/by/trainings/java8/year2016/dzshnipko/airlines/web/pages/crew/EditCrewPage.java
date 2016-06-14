package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.crew;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.extensions.markup.html.form.palette.theme.DefaultTheme;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import com.googlecode.wicket.kendo.ui.form.multiselect.MultiSelect;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.EmloyeeStatus;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.EmployeeService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.Crew;
import by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer.CrewChoiceRender;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.crew.validators.NumberStuardValidator;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights.FlightsPage;
@AuthorizeInstantiation("admin")
public class EditCrewPage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	private Flight flight;
	private AircraftModel aircraftModel;

	@Inject
	private EmployeeService empService;
	@Inject
	private FlightService fltService;
	private Crew crew;

	public EditCrewPage(Flight flight) {
		super();
		this.flight = flight;
		this.aircraftModel = flight.getAircraft().getAircraftModel();
		this.crew=new Crew(flight.getEmployees());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		Form<Crew> form = new CrewForm<Crew>("crew-form", new CompoundPropertyModel<>(crew));

		EmployeeFilter empFilter = new EmployeeFilter();
		empFilter.setEmployeeStatus(EmloyeeStatus.ok);
		empFilter.setSpecialty(Specialty.firstPilot);

		List<Employee> firstPilotsList = empService.find(empFilter);

		final DropDownChoice<Employee> firstPilotChoice = new DropDownChoice<Employee>("firstPilot", firstPilotsList,
				CrewChoiceRender.getInstance());
		firstPilotChoice.setRequired(true);
		form.add(firstPilotChoice);

		empFilter.setSpecialty(Specialty.secondPilot);
		List<Employee> secondPilotsList = empService.find(empFilter);

		final DropDownChoice<Employee> secondPilotChoice = new DropDownChoice<Employee>("secondPilot", secondPilotsList,
				CrewChoiceRender.getInstance());
		secondPilotChoice.setVisible(aircraftModel.getSecondPilot());
		secondPilotChoice.setRequired(true);
		form.add(secondPilotChoice);

		empFilter.setSpecialty(Specialty.flightEngineer);
		List<Employee> engineerPilotsList = empService.find(empFilter);

		final DropDownChoice<Employee> engineerChoice = new DropDownChoice<Employee>("flightEngineer",
				engineerPilotsList, CrewChoiceRender.getInstance());
		engineerChoice.setVisible(aircraftModel.getFlightEngineer());
		engineerChoice.setRequired(true);
		form.add(engineerChoice);

		empFilter.setSpecialty(Specialty.navigator);
		List<Employee> navigatorsList = empService.find(empFilter);

		final DropDownChoice<Employee> navigatorChoice = new DropDownChoice<Employee>("navigator", navigatorsList,
				CrewChoiceRender.getInstance());
		navigatorChoice.setVisible(aircraftModel.getNavigator());
		navigatorChoice.setRequired(true);
		form.add(navigatorChoice);

		empFilter.setSpecialty(Specialty.radioman);
		List<Employee> radiomansList = empService.find(empFilter);

		final DropDownChoice<Employee> radiomanChoice = new DropDownChoice<Employee>("radioman", radiomansList,
				CrewChoiceRender.getInstance());
		radiomanChoice.setVisible(aircraftModel.getRadioman());
		radiomanChoice.setRequired(true);
		form.add(radiomanChoice);
		

		empFilter.setSpecialty(Specialty.steward);
		List<Employee> stewrdsList = empService.find(empFilter);
			 
		final Palette<Employee> palette = new Palette<Employee>("stewardsList", new ListModel<Employee>(crew.getStewardsList()),
				new CollectionModel<Employee>(stewrdsList), CrewChoiceRender.getInstance(), 15, false, true);
		palette.add(new DefaultTheme());
		palette.setVisible(aircraftModel.getStewards() > 0);
		palette.setRequired(true);
		palette.add(new NumberStuardValidator(aircraftModel));
		form.add(palette);
	

		form.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				flight.setEmployees(crew.getCrewAsSet());
				fltService.update(flight);
				setResponsePage(new FlightsPage());
			}
		});

		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(FlightsPage.class);
			}
		});
		add(form);
	}
	
	private class CrewForm<T> extends Form<T> {

		public CrewForm(String id, IModel<T> model) {
			super(id, model);

		}

	}

}
