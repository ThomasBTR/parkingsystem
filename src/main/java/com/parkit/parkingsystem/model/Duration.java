package com.parkit.parkingsystem.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The type Duration.
 */
public class Duration {

	/**
	 * The Difference in time.
	 */
	private long differenceInTime;
	/**
	 * The Year.
	 */
	private long year;
	/**
	 * The Month.
	 */
	private long month;
	/**
	 * The Day.
	 */
	private long day;
	/**
	 * The Hour.
	 */
	private long hour;
	/**
	 * The Minute.
	 */
	private long minute;

	/**
	 * The Free.
	 */
	private boolean free;

	/**
	 * Is free boolean.
	 *
	 * @return the boolean
	 */
	public boolean isFree() {
		return free;
	}

	/**
	 * Sets free.
	 *
	 * @param free the free
	 */
	public void setFree(final boolean free) {
		this.free = free;
	}

	/**
	 * Gets difference in time.
	 *
	 * @return the difference in time
	 */
	public long getDifferenceInTime() {
		return differenceInTime;
	}

	/**
	 * Gets year.
	 *
	 * @return the year
	 */
	public long getYear() {
		return year;
	}

	/**
	 * Sets year.
	 *
	 * @param year the year
	 */
	public void setYear(final long year) {
		this.year = year;
	}

	/**
	 * Gets month.
	 *
	 * @return the month
	 */
	public long getMonth() {
		return month;
	}

	/**
	 * Sets month.
	 *
	 * @param month the month
	 */
	public void setMonth(final long month) {
		this.month = month;
	}

	/**
	 * Gets day.
	 *
	 * @return the day
	 */
	public long getDay() {
		return day;
	}

	/**
	 * Sets day.
	 *
	 * @param day the day
	 */
	public void setDay(final long day) {
		this.day = day;
	}

	/**
	 * Gets hour.
	 *
	 * @return the hour
	 */
	public long getHour() {
		return hour;
	}

	/**
	 * Sets hour.
	 *
	 * @param hour the hour
	 */
	public void setHour(final long hour) {
		this.hour = hour;
	}

	/**
	 * Gets minute.
	 *
	 * @return the minute
	 */
	public long getMinute() {
		return minute;
	}

	/**
	 * Sets minute.
	 *
	 * @param minute the minute
	 */
	public void setMinute(final long minute) {
		this.minute = minute;
	}

	/**
	 * Difference with free time.
	 *
	 * @param inTime  the in time
	 * @param outTime the out time
	 */
	public void differenceWithFreeTime(final LocalDateTime inTime, final LocalDateTime outTime) {
		this.differenceInTime = outTime.toInstant(ZoneOffset.UTC).toEpochMilli()
				- inTime.toInstant(ZoneOffset.UTC).toEpochMilli();
	}
}
