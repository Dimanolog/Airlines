package by.trainings.java8.year2016.dzshnipko.airlines.web.app;

import javax.inject.Inject;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AnnotationsRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.home.HomePage;
import by.trainings.java8.year2016.dzshnipko.airlines.web.pages.login.LoginPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see by.trainings.java8.year2016.dzshnipko.airlines.Start#main(String[])
 */
@Component("wicketWebApplicationBean")
public class WicketApplication extends AuthenticatedWebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Inject
	private ApplicationContext applicationContext;
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		 super.init();
	        getMarkupSettings().setStripWicketTags(true);
	       
	        getComponentInstantiationListeners().add(new SpringComponentInjector(this, getApplicationContext()));

	        getSecuritySettings().setAuthorizationStrategy(new AnnotationsRoleAuthorizationStrategy(this));
	}
	
	 public ApplicationContext getApplicationContext() {
	        return applicationContext;
	    }
	
	 @Override
	    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
	        return AuthorizedSession.class;
	    }

	    @Override
	    protected Class<? extends WebPage> getSignInPageClass() {
	        return LoginPage.class;
	    }
}
