package com.ParkingLot.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.parkingLot.App.ParkingLotApp;
import com.parkingLot.service.ParkingLotService;
import com.parkingLot.service.ParkingLotServiceImpl;

import junit.framework.TestCase;

/**
 * This is the test class that has individual test cases testing all the
 * functionalities of the parking lot individually.
 */
public class ParkingLotTest extends TestCase {

	protected ParkingLotService parkingLotService;
	ParkingLotApp app;
	OutputStream os;
	PrintStream ps;

	@Before
	public void setUp() throws Exception {
		parkingLotService = new ParkingLotServiceImpl();
		app = new ParkingLotApp();
		os = new ByteArrayOutputStream();
		ps = System.out;
		System.setOut(new PrintStream(os));
	}

	@After
	public void tearDown() throws Exception {
		parkingLotService = null;
		System.setOut(ps);
	}

	@Test
	public void testCanCreateAParkingLot() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		assertEquals("Created a parking lot with 3 slots" + System.getProperty("line.separator"), os.toString());
	}

	@Test
	public void testCanParkACar() throws IOException {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		assertEquals("Created a parking lot with 3 slots" + System.getProperty("line.separator")
				+ "Allocated slot number:1" + System.getProperty("line.separator"), os.toString());
	}

	@Test
	public void testCanUnParkACar() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("leave 1", parkingLotService);
		assertEquals("Created a parking lot with 3 slots" + System.getProperty("line.separator")
				+ "Allocated slot number:1" + System.getProperty("line.separator") + "Slot number 1 is free."
				+ System.getProperty("line.separator"), os.toString());
	}

	@Test
	public void testCanReportStatus() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-1234 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-9999 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("status", parkingLotService);
		assertEquals("Created a parking lot with 3 slots" + System.getProperty("line.separator")
				+ "Allocated slot number:1" + System.getProperty("line.separator") + "Allocated slot number:2"
				+ System.getProperty("line.separator") + "Allocated slot number:3"
				+ System.getProperty("line.separator") + "Slot No.         Registration No           Colour"
				+ System.getProperty("line.separator") + "1                KA-01-HH-1234              White"
				+ System.getProperty("line.separator") + "2                KA-01-HH-3141              Black"
				+ System.getProperty("line.separator") + "3                KA-01-HH-9999              White"
				+ System.getProperty("line.separator") + System.getProperty("line.separator"), os.toString());
	}

	@Test
	public void testRegNumOfCarsWithColor() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("registration_numbers_for_cars_with_colour Black",
				parkingLotService);
		assertEquals("Created a parking lot with 3 slots" + System.getProperty("line.separator")
				+ "Allocated slot number:1" + System.getProperty("line.separator") + "KA-01-HH-3141 "
				+ System.getProperty("line.separator"), os.toString());
	}

	@Test
	public void testSlotNumForRegNum() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("slot_number_for_registration_number KA-01-HH-3141",
				parkingLotService);
		assertEquals(
				"Created a parking lot with 3 slots" + System.getProperty("line.separator") + "Allocated slot number:1"
						+ System.getProperty("line.separator") + "1" + System.getProperty("line.separator"),
				os.toString());
	}

	@Test
	public void testSlotNumOfCarsWithColor() {
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 3", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("slot_numbers_for_cars_with_colour Black", parkingLotService);
		assertEquals(
				"Created a parking lot with 3 slots" + System.getProperty("line.separator") + "Allocated slot number:1"
						+ System.getProperty("line.separator") + "1 " + System.getProperty("line.separator"),
				os.toString());
	}
}