package by.trainings.java8.year2016.dzshnipko.airlines.web.app;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;

public class AuthorizedSession extends AuthenticatedWebSession {

	private by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService userService;

	private User loggedUser;

	private Roles roles;

	public AuthorizedSession(Request request) {
		super(request);
		Injector.get().inject(this);

	}

	public static AuthorizedSession get() {
		return (AuthorizedSession) Session.get();
	}

	@Override
	public boolean authenticate(final String loginOrEmail, final String password) {
		User user = userService.getUserByLoginOrEmail(loginOrEmail);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Roles getRoles() {
		if (isSignedIn() && (roles == null)) {
			roles = new Roles();
			roles.add(loggedUser.getUserRole().name());

		}

		return roles;

	}

	@Override
	public void signOut() {
		super.signOut();
		loggedUser = null;
		roles = null;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

}
