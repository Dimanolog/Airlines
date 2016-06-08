package by.trainings.java8.year2016.dzshnipko.airlines.web.pages;

import java.util.Calendar;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.trainings.java8.year2016.dzshnipko.airlines.web.component.localization.LanguageSelectionComponent;
import by.trainings.java8.year2016.dzshnipko.airlines.web.component.panel.MenuPanel;


public abstract class AbstractPage extends WebPage {

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

        AbstractReadOnlyModel<Integer> yearModel = new AbstractReadOnlyModel<Integer>() {
            @Override
            public Integer getObject() {
                return Calendar.getInstance().get(Calendar.YEAR);
            }
        };

        WebMarkupContainer footer = new WebMarkupContainer("footer");
        add(footer);
        footer.add(new Label("current-year", yearModel));
        footer.add(AttributeModifier.append("onclick", "alert('Im clicked')"));
    }
}
