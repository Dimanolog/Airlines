package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.googlecode.wicket.kendo.ui.form.datetime.DatePicker;

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

	//FileUploadField photoUpload;

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

		/*photoUpload = new FileUploadField("photo-upload");

		form.add(photoUpload);
		form.add(new UploadProgressBar("progress", form, photoUpload));*/
		
		TextField<String> surname = new TextField<String>("surname");
		StringValidator lenthValidator = StringValidator.lengthBetween(1, 50);
		surname.setRequired(true);
		surname.add(lenthValidator);
		form.add(surname);

		TextField<String> name = new TextField<String>("name");
		name.setRequired(true);
		name.add(lenthValidator);
		form.add(name);

		DropDownChoice<Gender> genderChoice = new DropDownChoice<>("gender", Arrays.asList(Gender.values()),
				new EnumChoiceRenderer<Gender>());
		genderChoice.setRequired(true);
		form.add(genderChoice);

		final DatePicker birthdayDatepicker = new DatePicker("dateOfBirth", getLocaleDatePattern());
		birthdayDatepicker.setRequired(true);
		form.add(birthdayDatepicker);

		final DatePicker employmentDatepicker = new DatePicker("employmentDate", getLocaleDatePattern());
		employmentDatepicker.setRequired(true);
		form.add(employmentDatepicker);

		NumberTextField<Integer> flightNumberField = new NumberTextField<Integer>("totalFlight");
		flightNumberField.setRequired(true);
		flightNumberField.add(new RangeValidator<Integer>(0, 1000_000));
		form.add(flightNumberField);

		DropDownChoice<EmloyeeStatus> statusChoice = new DropDownChoice<>("employeeStatus",
				Arrays.asList(EmloyeeStatus.values()), new EnumChoiceRenderer<EmloyeeStatus>());
		statusChoice.setRequired(true);
		form.add(statusChoice);
		
		form.add(new TextArea<String>("description"));

		DropDownChoice<Specialty> specilatyChoice = new DropDownChoice<>("specialty", Arrays.asList(Specialty.values()),
				new EnumChoiceRenderer<Specialty>());
		specilatyChoice.setRequired(true);
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

		add(form);
	}

	private class EmployeeForm<T> extends Form<T> {

		public EmployeeForm(String id, IModel<T> model) {
			super(id, model);

		}

	}

}
