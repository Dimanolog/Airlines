package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.ws.Service.Mode;

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

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.AircraftState;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Gender;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.Specialty;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.DateUtil;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircraftModel.AircraftModelViewPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts.AircraftEditPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee.EmployeeEditPage;

public class AircraftListPanel extends Panel {

	public static final String DEFAULT_IMAGE_PATH = "/images/no-image.png";

	@Inject
	private AircraftService service;
	@Inject
	private DateUtil dateUtil;

	public AircraftListPanel(String id) {
		super(id);

	}

	@Override
	protected void onInitialize() {

		AircraftDataProvider provider = new AircraftDataProvider();
		DataView<Aircraft> dataView = new DataView<Aircraft>("rows", provider, 20) {
			@Override
			protected void populateItem(Item<Aircraft> item) {
				Aircraft aircraft = item.getModelObject();
				String photoPath;
				if (aircraft.getPhoto() != null) {
					photoPath = aircraft.getPhoto();
				} else {
					photoPath = DEFAULT_IMAGE_PATH;
				}
				item.add(new Image("photo", new ContextRelativeResource(photoPath)));

				Link<Void> aircraftModelLink = new Link("aircraft-model-link") {

					@Override
					public void onClick() {
						setResponsePage(new AircraftModelViewPage(aircraft.getAircraftModel()));

					}

				};
				aircraftModelLink
						.add(new Label("aircraft-model-name", Model.of(aircraft.getAircraftModel().getName())));
				item.add(aircraftModelLink);

				item.add(new Label("aircraft-number", Model.of(aircraft.getAircraftsNumber())));

				int aircraftAge = dateUtil.ageFromDate(aircraft.getManufactureDate());
				item.add(new Label("aircraft-age", Model.of(aircraftAge)));

				item.add(new Label("aircraft-totalFlight", Model.of(aircraft.getTotalFlight())));

				EnumChoiceRenderer<AircraftState> stateRenderer = new EnumChoiceRenderer<AircraftState>();
				String state = (String) stateRenderer.getDisplayValue(aircraft.getAircraftState());

				item.add(new Label("aircraft-state", Model.of(state)));

				item.add(new Link<Void>("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new AircraftEditPage(aircraft, true));

					}
				});
				item.add(new Link<Void>("delete-link") {
					@Override
					public void onClick() {
						
						service.delete(aircraft);

					}
				});

			}
		};
		add(dataView);
		add(new PagingNavigator("paging", dataView));

		add(new OrderByBorder("sort-aircraft-model", Aircraft_.aircraftModel, provider));
		add(new OrderByBorder("sort-number", Aircraft_.aircraftsNumber, provider));
		add(new OrderByBorder("sort-aircraft-age", Aircraft_.manufactureDate, provider));
		add(new OrderByBorder("sort-totalFlight", Aircraft_.totalFlight, provider));

	}

	private class AircraftDataProvider extends SortableDataProvider<Aircraft, Serializable> {

		private AircraftFilter filter;

		public AircraftDataProvider() {
			super();
			filter = new AircraftFilter();
			setSort((Serializable) Aircraft_.aircraftsNumber, SortOrder.ASCENDING);
		}

		@Override
		public Iterator<Aircraft> iterator(long first, long count) {
			Serializable property = getSort().getProperty();
			SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

			filter.setSortProperty((SingularAttribute) property);
			filter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

			filter.setLimit((int) count);
			filter.setOffset((int) first);
			return service.find(filter).iterator();
		}

		@Override
		public long size() {
			return service.count(filter);
		}

		@Override
		public IModel<Aircraft> model(Aircraft aircraft) {
			return new Model(aircraft);
		}

	}
}
