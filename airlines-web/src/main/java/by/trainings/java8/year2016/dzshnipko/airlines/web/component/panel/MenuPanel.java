package by.trainings.java8.year2016.dzshnipko.airlines.web.component.panel;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import by.trainings.java8.year2016.dzshnipko.airlines.web.app.AuthorizedSession;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts.AircraftPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.employee.EmployeePage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.flights.FlightsPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.home.HomePage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.login.LoginPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.UserPage;

public class MenuPanel extends Panel {

	private static final long serialVersionUID = -3525368962450580809L;

	public MenuPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("link-home") {
			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}
		});

		add(new Link("link-flights") {
			@Override
			public void onClick() {
				setResponsePage(new FlightsPage());
			}
		});

		add(new Link("link-employee") {
			@Override
			public void onClick() {
				setResponsePage(new EmployeePage());
			}
		});

		add(new Link("link-aircrafts") {
			@Override
			public void onClick() {
				setResponsePage(new AircraftPage());
			}
		});
		
		Link usersLink= new Link("link-users") {
			@Override
			public void onClick() {
				setResponsePage(new UserPage());
			}
		};
		
		add(usersLink);
		
		Link loginLink= new Link("link-login") {
			@Override
			public void onClick() {
				setResponsePage(new LoginPage());
			}
		};
	
		
		Link logoutLink= new Link("link-logout") {
			@Override
			public void onClick() {
				Session.get().invalidate();
				setResponsePage(new HomePage());
			}
		};
				
		if (AuthorizedSession.get().isSignedIn()) {
			loginLink.setVisible(false);
			logoutLink.setVisible(true);
		
		} else {
			loginLink.setVisible(true);
			logoutLink.setVisible(false);
		}
		add(loginLink);
		add(logoutLink);
	}

}
