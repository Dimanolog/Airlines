package by.trainings.java8.year2016.dzshnipko.airlines.web.pages.aircrafts;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AircraftModelFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Aircraft;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftModelService;
import by.trainings.java8.year2016.dzshnipko.airlines.services.interfaces.AircraftService;
import by.trainings.java8.year2016.dzshnipko.airlines.web.commom.renderer.AircraftModelChoiceRenderer;

public class AircraftEditPage extends WebPage {

	private static final long serialVersionUID = 1L;
	private Aircraft aircraft;
	@Inject
	private AircraftService aircraftService;
	@Inject
	private AircraftModelService modelService;

	private boolean update;

	public AircraftEditPage(Aircraft aircraft, boolean update) {
		super();
		this.update = update;
		this.aircraft = aircraft;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		CompoundPropertyModel<Aircraft> compoundModel = new CompoundPropertyModel<Aircraft>(aircraft);
		Form<Aircraft> form = new AircraftForm<>("aircraft-form", compoundModel);

		final FileUploadField photoUpload = new FileUploadField("photo-upload");

		form.add(photoUpload);
		form.add(new UploadProgressBar("progress", form, photoUpload));

		TextField<String> part2Number = new TextField<>("2-part-number", new Model<String>());
		part2Number.add(StringValidator.lengthBetween(3, 5));
		form.add(part2Number);

		TextField<String> part1Number = new TextField<>("1-part-number", new Model<String>());
		part1Number.add(StringValidator.lengthBetween(1, 2));
		part1Number.setVisible(update == false);
		form.add(part1Number);

		form.add(new DateTextField("dateOfPurchase"));
		form.add(new DateTextField("manufactureDate"));
		form.add(new NumberTextField<Integer>("totalFlight"));

		List<AircraftModel> aircraftModelList = modelService.find(new AircraftModelFilter());
		DropDownChoice<AircraftModel> aircraftChoice = new DropDownChoice<>("aircraftModel", aircraftModelList,
				AircraftModelChoiceRenderer.getInstance());
		form.add(aircraftChoice);

		form.add(new SubmitLink("save") {

			@Override
			public void onSubmit() {
				super.onSubmit();
				if (update == false) {
					String part1 = part1Number.getModelObject();
					String part2 = part2Number.getModelObject();
					String aircraftsNumber = String.format("%s-%s", part1, part2);
					aircraft.setAircraftsNumber(aircraftsNumber);
					if (aircraftService.checkUniqueAircraftNumber(aircraftsNumber)) {
						aircraftService.save(aircraft);
						setResponsePage(AircraftPage.class);
					} else {
						error(getString("error.not.unique.aircrafts.number"));
					}

				} else {
					aircraftService.update(aircraft);
					setResponsePage(AircraftPage.class);
				}

			}
		});
		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(AircraftPage.class);
			}
		});

		add(form);

	}

	private class AircraftForm<T> extends Form<T> {

		public AircraftForm(String id, IModel<T> model) {
			super(id, model);

		}

	}

}
