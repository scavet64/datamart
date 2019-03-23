package com.team12.datamart.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date_dimension")
public class DateDimension {

	@Id
	@Column(name = "date_id")
	private int dateKey;

	@Column(name = "date")
	private LocalDate timestamp;

	@Column(name = "day_number_in_month")
	private int dayNumberInMonth;

	@Column(name = "day_number_in_year")
	private int dayNumberInYear;

	@Column(name = "week_number_in_year")
	private int weekNumberInYear;

	@Column(name = "month_num")
	private int monthNum;

	@Column(name = "month_txt")
	private String monthText;

	@Column(name = "quarter")
	private int quarter;

	@Column(name = "year")
	private int year;

	@Column(name = "fiscal_year")
	private int fiscalYear;

	@Column(name = "is_holiday")
	private boolean isHoliday;

	@Column(name = "is_weekend")
	private boolean isWeekend;

	@Column(name = "season")
	private String season;

	public DateDimension() {

	}

	/**
	 * @param dateKey
	 * @param timestamp
	 * @param dayNumberInMonth
	 * @param dayNumberInYear
	 * @param weekNumberInYear
	 * @param monthNum
	 * @param monthText
	 * @param quarter
	 * @param year
	 * @param fiscalYear
	 * @param isHoliday
	 * @param isWeekend
	 * @param season
	 */
	public DateDimension(int dateKey, LocalDate timestamp, int dayNumberInMonth, int dayNumberInYear,
			int weekNumberInYear, int monthNum, String monthText, int quarter, int year, int fiscalYear,
			boolean isHoliday, boolean isWeekend, String season) {
		super();
		this.dateKey = dateKey;
		this.timestamp = timestamp;
		this.dayNumberInMonth = dayNumberInMonth;
		this.dayNumberInYear = dayNumberInYear;
		this.weekNumberInYear = weekNumberInYear;
		this.monthNum = monthNum;
		this.monthText = monthText;
		this.quarter = quarter;
		this.year = year;
		this.fiscalYear = fiscalYear;
		this.isHoliday = isHoliday;
		this.isWeekend = isWeekend;
		this.season = season;
	}

	/**
	 * @return the dateKey
	 */
	public int getDateKey() {
		return dateKey;
	}

	/**
	 * @param dateKey the dateKey to set
	 */
	public void setDateKey(int dateKey) {
		this.dateKey = dateKey;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDate getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the dayNumberInMonth
	 */
	public int getDayNumberInMonth() {
		return dayNumberInMonth;
	}

	/**
	 * @param dayNumberInMonth the dayNumberInMonth to set
	 */
	public void setDayNumberInMonth(int dayNumberInMonth) {
		this.dayNumberInMonth = dayNumberInMonth;
	}

	/**
	 * @return the dayNumberInYear
	 */
	public int getDayNumberInYear() {
		return dayNumberInYear;
	}

	/**
	 * @param dayNumberInYear the dayNumberInYear to set
	 */
	public void setDayNumberInYear(int dayNumberInYear) {
		this.dayNumberInYear = dayNumberInYear;
	}

	/**
	 * @return the weekNumberInYear
	 */
	public int getWeekNumberInYear() {
		return weekNumberInYear;
	}

	/**
	 * @param weekNumberInYear the weekNumberInYear to set
	 */
	public void setWeekNumberInYear(int weekNumberInYear) {
		this.weekNumberInYear = weekNumberInYear;
	}

	/**
	 * @return the monthNum
	 */
	public int getMonthNum() {
		return monthNum;
	}

	/**
	 * @param monthNum the monthNum to set
	 */
	public void setMonthNum(int monthNum) {
		this.monthNum = monthNum;
	}

	/**
	 * @return the monthText
	 */
	public String getMonthText() {
		return monthText;
	}

	/**
	 * @param monthText the monthText to set
	 */
	public void setMonthText(String monthText) {
		this.monthText = monthText;
	}

	/**
	 * @return the quarter
	 */
	public int getQuarter() {
		return quarter;
	}

	/**
	 * @param quarter the quarter to set
	 */
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the fiscalYear
	 */
	public int getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * @param fiscalYear the fiscalYear to set
	 */
	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	/**
	 * @return the isHoliday
	 */
	public boolean isHoliday() {
		return isHoliday;
	}

	/**
	 * @param isHoliday the isHoliday to set
	 */
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	/**
	 * @return the isWeekend
	 */
	public boolean isWeekend() {
		return isWeekend;
	}

	/**
	 * @param isWeekend the isWeekend to set
	 */
	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	/**
	 * @return the season
	 */
	public String getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(String season) {
		this.season = season;
	}

}
