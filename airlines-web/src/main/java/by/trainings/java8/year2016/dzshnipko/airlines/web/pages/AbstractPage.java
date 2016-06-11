package by.trainings.java8.year2016.dzshnipko.airlines.web.pages;

import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.googlecode.wicket.kendo.ui.KendoCultureHeaderItem;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

import by.trainings.java8.year2016.dzshnipko.airlines.web.component.localization.LanguageSelectionComponent;
import by.trainings.java8.year2016.dzshnipko.airlines.web.component.panel.MenuPanel;

public abstract class AbstractPage extends WebPage {

	
	private String localeTimePattern;
	private String localeDatePattern;

	public AbstractPage() {
		super();
	}

	public AbstractPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		Locale locale =this.getSession().getLocale();
		localeTimePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(null, FormatStyle.SHORT,
				IsoChronology.INSTANCE, locale);
		localeDatePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.MEDIUM, null,
				IsoChronology.INSTANCE, locale);

		add(new MenuPanel("menu-panel"));
		add(new LanguageSelectionComponent("language-select"));

		AbstractReadOnlyModel<Integer> yearModel = new AbstractReadOnlyModel<Integer>() {
			@Override
			public Integer getObject() {
				return Calendar.getInstance().get(Calendar.YEAR);
			}
		};

		WebMarkupContainer footer = new WebMarkupContainer("footer");
		add(footer);
		add(new KendoFeedbackPanel("absFeedback"));
		footer.add(new Label("current-year", yearModel));
		footer.add(AttributeModifier.append("onclick", "alert('Im clicked')"));

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(new KendoCultureHeaderItem(getSession().getLocale()));
		

	}

	public String getLocaleTimePattern() {
		return localeTimePattern;
	}

	public String getLocaleDatePattern() {
		return localeDatePattern;
	}
}
