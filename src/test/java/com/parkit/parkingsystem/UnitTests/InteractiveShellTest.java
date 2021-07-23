package com.parkit.parkingsystem.UnitTests;

import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * The type Interactive shell test.
 */
@ExtendWith(MockitoExtension.class)
class InteractiveShellTest {

	/**
	 * The constant inputReaderUtil.
	 */
	@Mock
	private static InputReaderUtil inputReaderUtil;

	/**
	 * The Parking service.
	 */
	@Mock
	private ParkingService parkingService;

	/**
	 * The Interactive shell under test.
	 */
	private InteractiveShell interactiveShellUnderTest;

	/**
	 * Sets interactive shell under test.
	 */
	@BeforeEach
	void setInteractiveShellUnderTest() {
		interactiveShellUnderTest = new InteractiveShell(inputReaderUtil, parkingService);
	}

	/**
	 * Process incoming vehicle.
	 */
	@Test
	void processIncomingVehicle() {

		// GIVEN

		when(inputReaderUtil.readSelection()).thenReturn(1).thenReturn(3);

		// WHEN
		interactiveShellUnderTest.loadInterface();

		// THEN
		verify(parkingService, times(1)).processIncomingVehicle();
		verify(parkingService, times(0)).processExitingVehicle();
	}

	/**
	 * Process exiting vehicle.
	 */
	@Test
	void processExitingVehicle() {
		// GIVEN
		when(inputReaderUtil.readSelection()).thenReturn(2).thenReturn(3);

		// WHEN
		interactiveShellUnderTest.loadInterface();

		// THEN

		verify(parkingService, times(0)).processIncomingVehicle();
		verify(parkingService, times(1)).processExitingVehicle();

	}

	/**
	 * Unsupported option.
	 */
	@Test
	void unsupportedOption() {
		// GIVEN
		when(inputReaderUtil.readSelection()).thenReturn(4).thenReturn(3);

		// WHEN
		interactiveShellUnderTest.loadInterface();

		// THEN
		verify(parkingService, times(0)).processExitingVehicle();
		verify(parkingService, times(0)).processIncomingVehicle();

	}


}
