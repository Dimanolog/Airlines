package by.trainings.java8.year2016.dzshnipko.airlines.web.app;

import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;

public class AuthorizedSession extends AuthenticatedWebSession {

	private  UserService userService;

	private User loggedUser;

	private Roles roles;
	
	private String localeTimePattern;
	private String localeDatePattern;
	private String localeDateTimePattern;

	public AuthorizedSession(Request request) {
		super(request);
		Injector.get().inject(this);
		localeChanged();

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
	public Session setLocale(Locale locale) {
		super.setLocale(locale);
		localeChanged();
		return this;
	};

	@Override
	public void signOut() {
		super.signOut();
		loggedUser = null;
		roles = null;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public String getLocaleTimePattern() {
		return localeTimePattern;
	}

	public String getLocaleDatePattern() {
		return localeDatePattern;
	}

	public String getLocaleDateTimePattern() {
		return localeDateTimePattern;
	}
	
	private void localeChanged(){
		
		localeTimePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(null, FormatStyle.SHORT,
				IsoChronology.INSTANCE, getLocale());
		localeDatePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.MEDIUM, null,
				IsoChronology.INSTANCE, getLocale());
		localeDateTimePattern=DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.MEDIUM, FormatStyle.SHORT,
				IsoChronology.INSTANCE, getLocale());
	}

}
