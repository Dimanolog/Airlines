package by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;

public class CrewChoiceRender extends ChoiceRenderer<Employee> {
	
	private static final long serialVersionUID = 1L;
	private static final CrewChoiceRender INSTANCE = new CrewChoiceRender();

	public static CrewChoiceRender getInstance() {
		return INSTANCE;
	}
	

	private CrewChoiceRender() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Object getDisplayValue(Employee object) {

		return object.getFullName();
	}

	@Override
	public String getIdValue(Employee object, int index) {

		return String.valueOf(object.getId());
	}


}
