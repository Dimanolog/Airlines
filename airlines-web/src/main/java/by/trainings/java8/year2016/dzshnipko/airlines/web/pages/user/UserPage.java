package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user;

import org.apache.wicket.markup.html.link.Link;

import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.panel.UserListPanel;

public class UserPage extends AbstractPage {

	public UserPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new UserListPanel("list-panel"));
		add(new Link("create") {
			@Override
			public void onClick() {
				setResponsePage(new UserRegisterPage());
			}
		});
	}

}
