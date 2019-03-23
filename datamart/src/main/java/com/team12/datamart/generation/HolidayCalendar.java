package com.team12.datamart.generation;

import java.time.LocalDate;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

import java.util.ArrayList;

/**
 * Yoinked from:
 * <a>https://www.programcreek.com/java-api-examples/index.php?source_dir=OG-Commons-master/modules/basics/src/main/java/com/opengamma/basics/date/HolidayCalendars.java#</a>
 * 
 * @author Vincent
 *
 */
public class HolidayCalendar {

	List<LocalDate> holidays;

	public HolidayCalendar(int year) {
		holidays = usCommon(year);
	}

	public boolean getIsHoliday(LocalDate date) {
		return holidays.contains(date);
	}

	private static List<LocalDate> usCommon(int year) {
		ArrayList<LocalDate> holidays = new ArrayList<>();

		// new year, adjusted if Sunday
		holidays.add(date(year, 1, 1));
		// martin luther king
		if (year >= 1986) {
			holidays.add(date(year, 1, 1).with(dayOfWeekInMonth(3, MONDAY)));
		}
		// washington
		if (year < 1971) {
			holidays.add(date(year, 2, 22));
		} else {
			holidays.add(date(year, 2, 1).with(dayOfWeekInMonth(3, MONDAY)));
		}

		// july 4th
		holidays.add(date(year, 7, 4));

		// memorial
		if (year < 1971) {
			holidays.add(date(year, 5, 30));
		} else {
			holidays.add(date(year, 5, 1).with(lastInMonth(MONDAY)));
		}
		// labor day
		holidays.add(date(year, 9, 1).with(firstInMonth(MONDAY)));

		// columbus day
		if (year < 1971) {
			holidays.add(bumpSunToMon(date(year, 10, 12)));
		} else {
			holidays.add(date(year, 10, 1).with(dayOfWeekInMonth(2, MONDAY)));
		}

		// veterans day

		if (year >= 1971 && year < 1978) {
			holidays.add(date(year, 10, 1).with(dayOfWeekInMonth(4, MONDAY)));
		} else {
			holidays.add(bumpSunToMon(date(year, 11, 11)));
		}

		// thanksgiving
		holidays.add(date(year, 11, 1).with(dayOfWeekInMonth(4, THURSDAY)));
		// independence day & christmas day
		holidays.add(date(year, 12, 25));

		return holidays;
	}

	// -------------------------------------------------------------------------
	// date
	private static LocalDate date(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}

	// bump to following Monday
	private static LocalDate bumpToMon(LocalDate date) {
		if (date.getDayOfWeek() == SATURDAY) {
			return date.plusDays(2);
		} else if (date.getDayOfWeek() == SUNDAY) {
			return date.plusDays(1);
		}
		return date;
	}

	// bump Sunday to following Monday
	private static LocalDate bumpSunToMon(LocalDate date) {
		if (date.getDayOfWeek() == SUNDAY) {
			return date.plusDays(1);
		}
		return date;
	}

	// bump to Saturday to Friday and Sunday to Monday
	private static LocalDate bumpToFriOrMon(LocalDate date) {
		if (date.getDayOfWeek() == SATURDAY) {
			return date.minusDays(1);
		} else if (date.getDayOfWeek() == SUNDAY) {
			return date.plusDays(1);
		}
		return date;
	}

	// christmas
	private static LocalDate christmas(int year) {
		LocalDate base = LocalDate.of(year, 12, 25);
		if (base.getDayOfWeek() == SATURDAY || base.getDayOfWeek() == SUNDAY) {
			return LocalDate.of(year, 12, 27);
		}
		return base;
	}

	// boxing day
	private static LocalDate boxingDay(int year) {
		LocalDate base = LocalDate.of(year, 12, 26);
		if (base.getDayOfWeek() == SATURDAY || base.getDayOfWeek() == SUNDAY) {
			return LocalDate.of(year, 12, 28);
		}
		return base;
	}

	// first of a month
	private static LocalDate first(int year, int month) {
		return LocalDate.of(year, month, 1);
	}

	// remove any holidays covered by Sat/Sun
	private static void removeSatSun(List<LocalDate> holidays) {
		holidays.removeIf(date -> date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY);
	}

}
