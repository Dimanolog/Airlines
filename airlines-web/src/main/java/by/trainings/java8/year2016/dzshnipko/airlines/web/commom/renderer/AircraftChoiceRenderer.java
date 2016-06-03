package by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;

public class AircraftChoiceRenderer extends ChoiceRenderer<Aircraft> {

	private static final AircraftChoiceRenderer INSTANCE= new AircraftChoiceRenderer();

	public static AircraftChoiceRenderer getInstance() {
		return INSTANCE;
	}

	private AircraftChoiceRenderer() {
		super();

	}

	@Override
	public Object getDisplayValue(Aircraft object) {
		String name = object.getAircraftModel().getName();
		String number = object.getAircraftsNumber();

		return String.format("%s (%s)", name, number);
	}

	@Override
	public String getIdValue(Aircraft object, int index) {

		return object.getAircraftsNumber();
	}

}
