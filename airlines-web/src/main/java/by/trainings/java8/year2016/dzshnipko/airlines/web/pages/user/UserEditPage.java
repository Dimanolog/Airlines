package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
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

@AuthorizeInstantiation(value = {"superUser"})
public class UserEditPage extends AbstractPage {
	private UserProfile userProfile;
	@Inject
	private UserService userService;

	public UserEditPage(UserProfile userProfile) {
		super();
		this.userProfile=userProfile;
	}
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		CompoundPropertyModel<UserProfile> compoundModel = new CompoundPropertyModel<UserProfile>(userProfile);
		Form<UserProfile> userForm = new UserEditForm<>("user-form", compoundModel);

		DropDownChoice<UserRole> roleChoice = new DropDownChoice<>("userRole", Arrays.asList(UserRole.values()),
				new EnumChoiceRenderer<UserRole>());
		userForm.add(roleChoice);

		PasswordTextField passField = new PasswordTextField("password");
		passField.add(new PatternValidator(UserService.PASSWORD_PATTERN));
		userForm.add(passField);

		PasswordTextField confirmPassField = new PasswordTextField("repeat-password", new Model<String>());
		userForm.add(confirmPassField);

		userForm.add(new EqualPasswordInputValidator(passField, confirmPassField));

		userForm.add(new SubmitLink("save") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				userService.update(userProfile);
				setResponsePage(new UserPage());
			}
		});
		userForm.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(UserPage.class);
			}
		});
		add(userForm);
		
	}

	private class UserEditForm<T> extends Form<T> {
		public UserEditForm(String id, IModel<T> model) {
			super(id, model);
		}
	}
}

