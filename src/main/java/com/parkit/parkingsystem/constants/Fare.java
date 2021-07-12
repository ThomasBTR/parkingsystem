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
     * The constant CAR_RATE_PER_DAY.
     */
    public static final double CAR_RATE_PER_DAY = 24 * CAR_RATE_PER_HOUR.value;
    /**
     * The constant CAR_RATE_PER_MONTH.
     */
    public static final double CAR_RATE_PER_MONTH = 30 * 24 * CAR_RATE_PER_HOUR.value;
    /**
     * The constant CAR_RATE_PER_MINUTE.
     */
    public static final double CAR_RATE_PER_MINUTE = CAR_RATE_PER_HOUR.value / 60;
    /**
     * The constant BIKE_RATE_PER_DAY.
     */
    public static final double BIKE_RATE_PER_DAY = 24 * BIKE_RATE_PER_HOUR.value;
    /**
     * The constant BIKE_RATE_PER_MONTH.
     */
    public static final double BIKE_RATE_PER_MONTH = 30.41666666 * 24 * BIKE_RATE_PER_HOUR.value;
	/**
	 * The constant BIKE_RATE_PER_MINUTE.
	 */
	public static final double BIKE_RATE_PER_MINUTE = BIKE_RATE_PER_HOUR.value / 60;
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
