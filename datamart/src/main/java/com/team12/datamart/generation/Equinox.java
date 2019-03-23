package com.team12.datamart.generation;

import java.time.LocalDate;

/**
 * Dates and times for the solstices and equinoxes.
 */
public class Equinox {

	private static final String WINTER = "Winter";
	private static final String SPRING = "Spring";
	private static final String SUMMER = "Summer";
	private static final String FALL = "Fall";

	private final LocalDate vernalEquinox;
	private final LocalDate summerSolstice;
	private final LocalDate autumnalEquinox;
	private final LocalDate winterSolstice;

	/**
	 * Calculate the dates and times for the solstices and equinoxes.
	 * 
	 * @param year The year to calculate for,
	 */
	public Equinox(final int year) {
		final double m, ve, ss, ae, ws;
		m = ((double) year - 2000) / 1000;
		final double m2 = m * m;
		final double m3 = m2 * m;
		final double m4 = m3 * m;
		ve = 2451623.80984 + 365242.37404 * m + 0.05169 * m2 - 0.00411 * m3 - 0.00057 * m4;
		vernalEquinox = toLocalDate(ve);
		ss = 2451716.56767 + 365241.62603 * m + 0.00325 * m2 + 0.00888 * m3 - 0.00030 * m4;
		summerSolstice = toLocalDate(ss);
		ae = 2451810.21715 + 365242.01767 * m - 0.11575 * m2 + 0.00337 * m3 + 0.00078 * m4;
		autumnalEquinox = toLocalDate(ae);
		ws = 2451900.05952 + 365242.74049 * m - 0.06223 * m2 - 0.00823 * m3 + 0.00032 * m4;
		winterSolstice = toLocalDate(ws);
	}

	private LocalDate toLocalDate(final double jdn) {
		final double p = Math.floor(jdn + 0.5);
		final double s1 = p + 68569;
		final double n = Math.floor(4 * s1 / 146097);
		final double s2 = s1 - Math.floor((146097 * n + 3) / 4);
		final double i = Math.floor(4000 * (s2 + 1) / 1461001);
		final double s3 = s2 - Math.floor(1461 * i / 4) + 31;
		final double q = Math.floor(80 * s3 / 2447);
		final double e = s3 - Math.floor(2447 * q / 80);
		final double s4 = Math.floor(q / 11);

		final double mm = q + 2 - 12 * s4;
		final double yy = 100 * (n - 49) + i + s4;
		final double dd = e + jdn - p + 0.5;

		double hrs, min, sec, tm;

		tm = 24 * (dd - Math.floor(dd));
		hrs = Math.floor(tm);
		tm = 60 * (tm - hrs);
		min = Math.floor(tm);
		tm = 60 * (tm - min);
		sec = Math.round(tm);

		return LocalDate.of((int) yy, (int) mm, (int) dd);
	}

	/**
	 * @return the autumnalEquinox
	 */
	public LocalDate getSeptemberEquinox() {
		return autumnalEquinox;
	}

	/**
	 * @return the summerSolstice
	 */
	public LocalDate getJuneSolstice() {
		return summerSolstice;
	}

	/**
	 * @return the vernalEquinox
	 */
	public LocalDate getMarchEquinox() {
		return vernalEquinox;
	}

	/**
	 * @return the winterSolstice
	 */
	public LocalDate getDecemberSolstice() {
		return winterSolstice;
	}

	public String getSeason(LocalDate date) {

		if (date.isBefore(getMarchEquinox())) {
			// Since we start in January, if we are before March, we are in winter
			return WINTER;
		} else if (date.isBefore(getJuneSolstice())) {
			// After March but before June
			return SPRING;
		} else if (date.isBefore(getSeptemberEquinox())) {
			// After June but before September
			return SUMMER;
		} else if (date.isBefore(getDecemberSolstice())) {
			// After September but before December
			return FALL;
		} else {
			// Last few days of the year
			return WINTER;
		}
	}

}