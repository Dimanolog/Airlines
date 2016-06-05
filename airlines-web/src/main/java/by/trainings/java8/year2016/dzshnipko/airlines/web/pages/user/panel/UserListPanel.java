package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.UserRole;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.UserEditPage;

public class UserListPanel extends Panel {

	@Inject
	UserService userService;
	
	public UserListPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onInitialize() {

		UserDataProvider provider= new UserDataProvider();
		DataView<User> dataView = new DataView<User>("rows", provider, 20) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<User> item) {
				User user=item.getModelObject();

				item.add(new Label("login", user.getLogin()));
				item.add(new Label("email",user.getEmail()));
				
				EnumChoiceRenderer<UserRole> userRoleRenderer = new EnumChoiceRenderer<UserRole>();
				String userRole = (String) userRoleRenderer.getDisplayValue(user.getUserRole());
				item.add(new Label("role", Model.of(userRole)));
			
				item.add(new Link<Void>("edit-link") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new UserEditPage(user));

					}
				});
				
				item.add(new Link<Void>("delete-link") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						userService.delete(user);

					}
				});

			}
		};
		add(dataView);
		add(new PagingNavigator("paging", dataView));

		add(new OrderByBorder("sort-user-login", User_.login, provider));
		add(new OrderByBorder("sort-user-email", User_.email, provider));
		add(new OrderByBorder("sort-user-role", User_.userRole, provider));
		
	}

private class UserDataProvider extends SortableDataProvider<User, Serializable> {

		private UserFilter filter;

		public UserDataProvider() {
			super();
			filter = new UserFilter();
			setSort((Serializable) User_.login, SortOrder.ASCENDING);
		}
	
	@Override
	public Iterator<User> iterator(long first, long count) {
		Serializable property = getSort().getProperty();
		SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

		filter.setSortProperty((SingularAttribute) property);
		filter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

		filter.setLimit((int)count);
		filter.setOffset((int)first);
		return userService.find(filter).iterator();
	}

	@Override
	public long size() {
		return userService.count(filter);
	}

	@Override
	public IModel<User> model(User user) {
		return new Model(user);
	}

}
	
	

	
	

}
