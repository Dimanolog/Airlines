package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.EmloyeeStatus;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Gender;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.EmployeeService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;

public class EmployeeEditPage extends AbstractPage {

	private Employee employee;
	@Inject
	private EmployeeService employeeService;

	public EmployeeEditPage(PageParameters parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	public EmployeeEditPage(Employee employee) {
		super();
		this.employee = employee;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		CompoundPropertyModel<Employee> compoundModel = new CompoundPropertyModel<Employee>(employee);
		Form<Employee> form = new Form<Employee>("employee-form", compoundModel);
		final FileUploadField photoUpload = new FileUploadField("photo-upload");

		form.add(photoUpload);
		form.add(new UploadProgressBar("progress", form, photoUpload));
		form.add(new TextField<String>("surname"));
		form.add(new TextField<String>("name"));

		DropDownChoice<Gender> genderChoice = new DropDownChoice<>("gender", Arrays.asList(Gender.values()),
				new EnumChoiceRenderer<Gender>());
		form.add(genderChoice);

		form.add(new DateTextField("dateOfBirth"));
		form.add(new TextField<Integer>("totalFlight"));

		DropDownChoice<EmloyeeStatus> statusChoice = new DropDownChoice<>("employeeStatus",
				Arrays.asList(EmloyeeStatus.values()), new EnumChoiceRenderer<EmloyeeStatus>());
		form.add(statusChoice);

		form.add(new TextArea<String>("description"));
		
		DropDownChoice<Specialty> specilatyChoice= new DropDownChoice<>("specialty", Arrays.asList(Specialty.values()),
				new EnumChoiceRenderer<Specialty>());
		form.add(specilatyChoice);
		
		form.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				employeeService.saveOrUpdate(employee);
				setResponsePage(new EmployeePage());
			}
		});
		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(EmployeePage.class);
			}
		});

	}

	private class EmployeeForm<T> extends Form<T> {

		public EmployeeForm(String id, IModel<T> model) {
			super(id, model);
		}

	}

}
