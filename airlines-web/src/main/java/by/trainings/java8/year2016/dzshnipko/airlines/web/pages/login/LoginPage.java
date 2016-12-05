package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.login;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;

import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.AbstractPage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.home.HomePage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.user.UserRegisterPage;

public class LoginPage extends AbstractPage {

    public static final String ID_FORM = "form";

    private String username;
    private String password;

    @Override
    protected void onInitialize() {
        super.onInitialize();
     
        if (AuthenticatedWebSession.get().isSignedIn()) {
            setResponsePage(Application.get().getHomePage());
        }

        final Form<Void> form = new Form<Void>(ID_FORM);
        form.setDefaultModel(new CompoundPropertyModel<LoginPage>(this));
        form.add(new RequiredTextField<String>("username"));
        form.add(new PasswordTextField("password"));
        
        form.add(new SubmitLink("submit-btn") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                if (Strings.isEmpty(username) || Strings.isEmpty(password)) {
                    return;
                }
                final boolean authResult = AuthenticatedWebSession.get().signIn(username, password);
                if (authResult) {
                   
                	//setResponsePage(getApplication().getHomePage());
                	 continueToOriginalDestination();
                } else {
                    error(getString("error.worng.password.or.login"));
                }
            }
        });
        add(form);
        add(new Link("link-register"){
        		
			@Override
			public void onClick() {
				setResponsePage(new UserRegisterPage());
				
			}
        	
        });
    }

}
