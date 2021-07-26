package com.parkit.parkingsystem.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * The type Input reader util.
 */
public class InputReaderUtil {

	/**
	 * The constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger("InputReaderUtil");
	/**
	 * The constant scan.
	 */
	private final Scanner scan = new Scanner(System.in);

	/**
	 * Read selection int.
	 *
	 * @return the int
	 */
	public int readSelection() {
		try {
			return Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			LOGGER.error("Error while reading user input from Shell", e);
			System.out.println("Error reading input. Please enter valid number for proceeding further");
			return -1;
		}
	}

	/**
	 * Read vehicle registration number string.
	 *
	 * @return the string
	 */
	public String readVehicleRegistrationNumber() {
		try {
			String vehicleRegNumber = scan.nextLine();
			if (vehicleRegNumber == null || vehicleRegNumber.trim().length() == 0) {
				throw new IllegalArgumentException("Invalid input provided");
			}
			return vehicleRegNumber;
		} catch (Exception e) {
			LOGGER.error("Error while reading user input from Shell", e);
			System.out.println("Error reading input. Please enter a valid string for vehicle registration number");
			throw e;
		}
	}


}
