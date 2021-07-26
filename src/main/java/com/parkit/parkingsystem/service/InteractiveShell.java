package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.util.InputReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.System.out;

/**
 * Interface client de l'API.
 */
public class InteractiveShell {

	/**
	 * The constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger("InteractiveShell");

	/**
	 * The Input reader util.
	 */
	private final InputReaderUtil inputReaderUtil;

	/**
	 * The Parking service.
	 */
	private final ParkingService parkingService;

	/**
	 * Instantiates a new Interactive shell.
	 *
	 * @param inputReaderUtil the input reader util
	 * @param parkingService  the parking service
	 */
	public InteractiveShell(final InputReaderUtil inputReaderUtil, final ParkingService parkingService) {
		this.inputReaderUtil = inputReaderUtil;
		this.parkingService = parkingService;
	}

	/**
	 * Load menu.
	 */
	private static void loadMenu() {
		out.println("Please select an option. Simply enter the number to choose an action");
		out.println("1 New Vehicle Entering - Allocate Parking Space");
		out.println("2 Vehicle Exiting - Generate Ticket Price");
		out.println("3 Shutdown System");
	}

	/**
	 * Load interface.
	 */
	public void loadInterface() {
		LOGGER.info("App initialized!!!");
		out.println("Welcome to Parking System!");

		boolean continueApp = true;
		while (continueApp) {
			loadMenu();
			int option = inputReaderUtil.readSelection();
			switch (option) {
				case 1: {
					parkingService.processIncomingVehicle();
					break;
				}
				case 2: {
					parkingService.processExitingVehicle();
					break;
				}
				case 3: {
					out.println("Exiting from the system!");
					continueApp = false;
					break;
				}
				default:
					out.println("Unsupported option. Please enter a number corresponding to the provided menu");
			}
		}
	}

}
