package com.team12.datamart.generation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.TextStyle;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.team12.datamart.domain.DateDimension;

@Service
public class DateDimensionGeneration {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<DateDimension> getDataForYear(int year) {

		// Setup variables required for this generation of dates for the passed in year
		List<DateDimension> dates = new ArrayList<DateDimension>();
		Equinox equinoxCalc = new Equinox(year);
		LocalDate fiscalYearCutoff = LocalDate.of(year, 7, 31); // July 31st
		Locale locale = Locale.getDefault();
		WeekFields weekFields = WeekFields.of(locale);
		HolidayCalendar holidayCalendar = new HolidayCalendar(year);

		// The starting date object
		LocalDate currentDate = LocalDate.of(year, 1, 1);

		// Loop until we reach the next year
		while (currentDate.getYear() == year) {
			logger.info("Generating date number: " + currentDate.getDayOfYear());
			DateDimension dim = new DateDimension();
			dim.setDateKey(currentDate.getDayOfYear());
			dim.setDayNumberInMonth(currentDate.getDayOfMonth());
			dim.setDayNumberInYear(currentDate.getDayOfYear());
			dim.setWeekNumberInYear(currentDate.get(weekFields.weekOfWeekBasedYear()));
			dim.setMonthNum(currentDate.getMonthValue());
			dim.setMonthText(currentDate.getMonth().getDisplayName(TextStyle.FULL, locale));
			dim.setTimestamp(currentDate);
			dim.setYear(year);
			dim.setFiscalYear(getFiscalYear(currentDate, fiscalYearCutoff));
			dim.setHoliday(holidayCalendar.getIsHoliday(currentDate));
			dim.setQuarter(getQuarter(currentDate));
			dim.setSeason(equinoxCalc.getSeason(currentDate));
			dim.setWeekend(isWeekend(currentDate));

			// Add to the list
			dates.add(dim);

			// Go to next day
			currentDate = currentDate.plusDays(1);
		}

		return dates;
	}

	private String getTimestampString(LocalDate date) {
		return new StringBuilder().append(date.getYear()).append(date.getMonthValue()).append(date.getDayOfMonth())
				.toString();
	}

	private int getFiscalYear(LocalDate date, LocalDate fiscalYearCutoff) {
		return date.isAfter(fiscalYearCutoff) ? date.getYear() : date.getYear() - 1;
	}

	private int getQuarter(LocalDate date) {
		return date.get(IsoFields.QUARTER_OF_YEAR);
	}

	private boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
}
