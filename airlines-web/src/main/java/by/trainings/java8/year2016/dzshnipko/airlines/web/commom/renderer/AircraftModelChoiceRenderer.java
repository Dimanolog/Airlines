package by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;

public class AircraftModelChoiceRenderer extends ChoiceRenderer<AircraftModel> {

	private static final AircraftModelChoiceRenderer INSTANCE = new AircraftModelChoiceRenderer();

	public static AircraftModelChoiceRenderer getInstance() {
		return INSTANCE;
	}

	private AircraftModelChoiceRenderer() {
		super();

	}

	@Override
	public Object getDisplayValue(AircraftModel object) {

		return object.getName();
	}

	@Override
	public String getIdValue(AircraftModel object, int index) {

		return String.valueOf(object.getId());
	}

}
