package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.ContextRelativeResource;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.EmployeeFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Gender;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.EmployeeService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.DateUtil;

public class EmployeeListPanel extends Panel {
	@Inject
	private EmployeeService employeeService;
	@Inject
	private DateUtil dateUtil;

	public EmployeeListPanel(String id) {
		super(id);
	
	}
	
		@Override
		protected void onInitialize() {
			
			EmployeeDataProvider provider = new EmployeeDataProvider();
			DataView<Employee> dataView = new DataView<Employee>("rows", provider, 20) {
				@Override
				protected void populateItem(Item<Employee> item) {
					Employee employee = item.getModelObject();
				
					item.add(new Image("photo", new ContextRelativeResource(employee.getPhoto())));
					item.add(new Label("fullname", employee.getFullName()));
					
					EnumChoiceRenderer<Specialty> specialtyRenderer=new EnumChoiceRenderer<Specialty>();
					String specialty= (String) specialtyRenderer.getDisplayValue(employee.getSpecialty());
									
					item.add(new Label("specialty", Model.of(specialty)));
					
					EnumChoiceRenderer<Gender> genderRenderer= new EnumChoiceRenderer<>();
					String gender= (String) genderRenderer.getDisplayValue(employee.getGender());
					
					item.add(new Label("gender"), Model.of(gender)));
					
					int age= dateUtil.ageFromDate(employee.getDateOfBirth());
					
					item.add(new Label("destination-time", flight.getArrivalTime()));
					item.add(DateLabel.forDatePattern("created", Model.of(flight.getArrivalTime()), "HH:mm dd-MM-yyyy"));

					item.add(new Link<Void>("edit-link") {
						@Override
						public void onClick() {

						}
					});
					item.add(new Link<Void>("delete-link") {
						@Override
						public void onClick() {

						}
					});

				}
			};
			add(dataView);
			add(new PagingNavigator("paging", dataView));

			add(new OrderByBorder("sort-destination-point", Flight_.destinationPointName, provider));
			add(new OrderByBorder("sort-destination-time", Flight_.arrivalTime, provider));
			add(new OrderByBorder("sort-departure-point", Flight_.departurePointName, provider));
			add(new OrderByBorder("sort-departure-time", Flight_.departureTime, provider));
			
		}
		}
	

	private class EmployeeDataProvider extends SortableDataProvider<Employee, Serializable> {

		private EmployeeFilter filter;

		public EmployeeDataProvider() {
			super();
			filter = new EmployeeFilter();
			setSort((Serializable) Employee_.surname, SortOrder.ASCENDING);
		}

		@Override
		public Iterator<Employee> iterator(long first, long count) {
			Serializable property = getSort().getProperty();
			SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

			filter.setSortProperty((SingularAttribute) property);
			filter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

			filter.setLimit((int) count);
			filter.setOffset((int) first);
			return employeeService.find(filter).iterator();
		}

		@Override
		public long size() {
			return employeeService.count(filter);
		}

		@Override
		public IModel<Employee> model(Employee employee) {
			return new Model(employee);
		}

	}
}
