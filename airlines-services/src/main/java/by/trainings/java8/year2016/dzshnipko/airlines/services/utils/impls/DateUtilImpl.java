package by.trainings.java8.year2016.dzshnipko.airlines.services.utils.impls;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.stereotype.Service;

import by.trainings.java8.year2016.dzshnipko.airlines.services.utils.interfaces.DateUtil;

@Service
public class DateUtilImpl implements DateUtil {
	@Override
	public int ageFromDate(Date date){
		LocalDate localDate = new LocalDate(date.getTime());
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(localDate, now);
		return age.getYears();
	}
}
