package com.parkit.parkingsystem.constants;

/**
 * éa
 * The enum Fare.
 */
public enum Fare {

	/**
	 * Free parking time in minute fare.
	 */
	FREE_PARKING_TIME_IN_MINUTE(30),
	/**
	 * Recurring user discount fare.
	 */
	RECURRING_USER_DISCOUNT(0.05),
	/**
	 * Car rate per hour fare.
	 */
	CAR_RATE_PER_HOUR(1.5),
	/**
	 * Bike rate per hour fare.
	 */
	BIKE_RATE_PER_HOUR(1.0);

	/**
	 * The constant DAYS_PER_MONTH.
	 */
	private final static double DAYS_PER_MONTH = 30.41666666;

	/**
	 * The constant HOURS_PER_DAYS.
	 */
	private final static double HOURS_PER_DAYS = 24;
	/**
	 * The constant CAR_RATE_PER_DAY.
	 */
	public static final double CAR_RATE_PER_DAY = HOURS_PER_DAYS * CAR_RATE_PER_HOUR.value;
	/**
	 * The constant CAR_RATE_PER_MONTH.
	 */
	public static final double CAR_RATE_PER_MONTH = DAYS_PER_MONTH * HOURS_PER_DAYS * CAR_RATE_PER_HOUR.value;
	/**
	 * The constant BIKE_RATE_PER_DAY.
	 */
	public static final double BIKE_RATE_PER_DAY = HOURS_PER_DAYS * BIKE_RATE_PER_HOUR.value;
	/**
	 * The constant BIKE_RATE_PER_MONTH.
	 */
	public static final double BIKE_RATE_PER_MONTH = DAYS_PER_MONTH * HOURS_PER_DAYS * BIKE_RATE_PER_HOUR.value;
	/**
	 * The constant SECONDS_PER_MINUTES.
	 */
	private final static double SECONDS_PER_MINUTES = 60;
	/**
	 * The constant CAR_RATE_PER_MINUTE.
	 */
	public static final double CAR_RATE_PER_MINUTE = CAR_RATE_PER_HOUR.value / SECONDS_PER_MINUTES;
	/**
	 * The constant BIKE_RATE_PER_MINUTE.
	 */
	public static final double BIKE_RATE_PER_MINUTE = BIKE_RATE_PER_HOUR.value / SECONDS_PER_MINUTES;
	/**
	 * The Value.
	 */
	private final double value;


	/**
	 * Instantiates a new Fare.
	 *
	 * @param value the value
	 */
	Fare(double value) {
		this.value = value;
	}

	/**
	 * Gets value.
	 *
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

}
