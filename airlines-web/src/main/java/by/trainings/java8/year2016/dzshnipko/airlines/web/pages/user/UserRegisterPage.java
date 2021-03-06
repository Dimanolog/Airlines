package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.PatternValidator;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.enums.UserRole;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.UserService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.home.HomePage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators.EmailWebValidator;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.validators.LoginValidator;

public class UserRegisterPage extends AbstractPage {
	
	private static final long serialVersionUID = 1L;
	private UserProfile userProfile;
	@Inject
	private UserService userService;

	public UserRegisterPage() {
		super();
		userProfile = new UserProfile();

	}
	@Override
	protected void onInitialize() {
		super.onInitialize();

		CompoundPropertyModel<UserProfile> compoundModel = new CompoundPropertyModel<UserProfile>(userProfile);
		Form<UserProfile> userForm = new UserForm<>("user-form", compoundModel);

		RequiredTextField<String> loginField = new RequiredTextField<>("login");
		loginField.add(LoginValidator.getInstance());
		userForm.add(loginField);

		RequiredTextField<String> emailField = new RequiredTextField<>("email");
		emailField.add(EmailWebValidator.getInstance());
		userForm.add(emailField);

		PasswordTextField passField = new PasswordTextField("password");
		passField.add(new PatternValidator(UserService.PASSWORD_PATTERN));
		userForm.add(passField);

		PasswordTextField repeatPassField = new PasswordTextField("repeat-password", new Model<String>());
		userForm.add(repeatPassField);

		final DropDownChoice<UserRole> userRoleChoice = new DropDownChoice<>("userRole",
				Arrays.asList(UserRole.values()), new EnumChoiceRenderer<UserRole>());
		userRoleChoice.setRequired(true);
		userForm.add(userRoleChoice);

		userForm.add(new EqualPasswordInputValidator(passField, repeatPassField));

		userForm.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				userProfile.setUserRole(UserRole.user);
				userService.save(userProfile);
				setResponsePage(HomePage.class);
			}
		});
		userForm.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		add(userForm);

	}

	private class UserForm<T> extends Form<T> {
		public UserForm(String id, IModel<T> model) {
			super(id, model);
		}
	}
}
