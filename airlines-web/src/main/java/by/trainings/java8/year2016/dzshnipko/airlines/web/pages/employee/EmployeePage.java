package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee;

import org.apache.wicket.markup.html.link.Link;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee.panel.EmployeeListPanel;

public class EmployeePage extends AbstractPage {

	public EmployeePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new EmployeeListPanel("list-panel"));
		add(new Link("create") {
			@Override
			public void onClick() {
				setResponsePage(new EmployeeEditPage(new Employee()));
			}
		});
	}
}
