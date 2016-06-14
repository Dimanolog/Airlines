package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.FlightFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Flight_;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.FlightService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.app.AuthorizedSession;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.crew.EditCrewPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights.FlightEditPage;

public class FlightListPanel extends Panel {
	@Inject
	FlightService flightService;

	public FlightListPanel(String id) {
		super(id);

		FlightsDataProvider provider = new FlightsDataProvider();
		DataView<Flight> dataView = new DataView<Flight>("rows", provider, 20) {
			@Override
			protected void populateItem(Item<Flight> item) {
				Flight flight = item.getModelObject();

				item.add(new Label("aircraft", Model.of(flight.getAircraft().getFullName())));
				item.add(new Label("destination-point", Model.of(flight.getFullDestinationPoint())));
				item.add(DateLabel.forDatePattern("destination-time", Model.of(flight.getArrivalTime()),
						AuthorizedSession.get().getLocaleDateTimePattern()));
				item.add(new Label("departure-point", Model.of(flight.getFullDeparturePoint())));
				item.add(DateLabel.forDatePattern("departure-time", Model.of(flight.getDepartureTime()),
						AuthorizedSession.get().getLocaleDateTimePattern()));
				

				item.add(new Link<Void>("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new FlightEditPage(flight));
					}
				});
				
			/*	item.add(new Link<Void>("delete-link") {
					@Override
					public void onClick() {
						flightService.delete(flight);
					}
				});*/

				Link<Void> editCrewLink = new Link("edit-crew") {

					@Override
					public void onClick() {
						setResponsePage(new EditCrewPage(flight));

					}

				};
				String addCrewLabel;
				if(flight.getEmployees().isEmpty()){
					addCrewLabel=getString("flights.add.crew");
				}else{
					addCrewLabel=getString("flights.edit.crew");
				}
				
				editCrewLink.add(new Label("edit-crew-label",addCrewLabel));

				item.add(editCrewLink);
			}
		};

		add(dataView);
		add(new PagingNavigator("paging", dataView));
		add(new OrderByBorder("sort-destination-point", Flight_.destinationPointName, provider));
		add(new OrderByBorder("sort-destination-time", Flight_.arrivalTime, provider));
		add(new OrderByBorder("sort-departure-point", Flight_.departurePointName, provider));
		add(new OrderByBorder("sort-departure-time", Flight_.departureTime, provider));
	}

	private class FlightsDataProvider extends SortableDataProvider<Flight, Serializable> {

		private FlightFilter filter;

		public FlightsDataProvider() {
			super();
			filter = new FlightFilter();
			filter.setFetchEmployees(true);
			setSort((Serializable) Flight_.departureTime, SortOrder.ASCENDING);
		}

		@Override
		public Iterator<Flight> iterator(long first, long count) {
			Serializable property = getSort().getProperty();
			SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

			filter.setSortProperty((SingularAttribute) property);
			filter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

			filter.setLimit((int) count);
			filter.setOffset((int) first);
			return flightService.find(filter).iterator();
		}

		@Override
		public long size() {
			return flightService.count(filter);
		}

		@Override
		public IModel<Flight> model(Flight flight) {
			return new Model(flight);
		}

	}
}
