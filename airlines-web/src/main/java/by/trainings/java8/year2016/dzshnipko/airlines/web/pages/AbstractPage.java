package by.trainings.java8.year2016.dzshnipko.airlines.web.pages;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.googlecode.wicket.kendo.ui.KendoCultureHeaderItem;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

import by.trainings.java8.year2016.dzshnipko.airlines.web.component.localization.LanguageSelectionComponent;
import by.trainings.java8.year2016.dzshnipko.airlines.web.component.panel.MenuPanel;

public abstract class AbstractPage extends WebPage {
	
	private static final long serialVersionUID = 1L;

	public AbstractPage() {
		super();
	}

	public AbstractPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new MenuPanel("menu-panel"));
		add(new LanguageSelectionComponent("language-select"));
		add(new KendoFeedbackPanel("absFeedback"));
		

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(new KendoCultureHeaderItem(getSession().getLocale()));
		

	}

	
}
