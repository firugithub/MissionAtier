package com.ParkingLot.test;

import java.io.ByteArrayOutputStream;
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
 * This is the test class that has end to end test cases covering all the
 * functionalities of the parking lot in one go.
 */
public class EndToEndTest extends TestCase {
	protected ParkingLotService parkingLotService;
	OutputStream os;
	PrintStream ps;

	@Before
	public void setUp() throws Exception {
		parkingLotService = new ParkingLotServiceImpl();
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
		ParkingLotApp.analyzeAndProcessInputString("create_parking_lot 6", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-1234 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-9999 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-BB-0001 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-7777 Red", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-2701 Blue", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-HH-3141 Black", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("leave 4", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("status", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park KA-01-P-333 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("park DL-12-AA-9999 White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("registration_numbers_for_cars_with_colour White",
				parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("slot_numbers_for_cars_with_colour White", parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("slot_number_for_registration_number KA-01-HH-3141",
				parkingLotService);
		ParkingLotApp.analyzeAndProcessInputString("slot_number_for_registration_number MH-04-AY-1111",
				parkingLotService);
		assertEquals("Created a parking lot with 6 slots" + System.getProperty("line.separator")
				+ "Allocated slot number:1" + System.getProperty("line.separator") + "Allocated slot number:2"
				+ System.getProperty("line.separator") + "Allocated slot number:3"
				+ System.getProperty("line.separator") + "Allocated slot number:4"
				+ System.getProperty("line.separator") + "Allocated slot number:5"
				+ System.getProperty("line.separator") + "Allocated slot number:6"
				+ System.getProperty("line.separator") + "Slot number 4 is free." + System.getProperty("line.separator")
				+ "Slot No.         Registration No           Colour" + System.getProperty("line.separator")
				+ "1                KA-01-HH-1234              White" + System.getProperty("line.separator")
				+ "2                KA-01-HH-9999              White" + System.getProperty("line.separator")
				+ "3                KA-01-BB-0001              Black" + System.getProperty("line.separator")
				+ "5                KA-01-HH-2701              Blue" + System.getProperty("line.separator")
				+ "6                KA-01-HH-3141              Black" + System.getProperty("line.separator")
				+ System.getProperty("line.separator") + "Allocated slot number:4"
				+ System.getProperty("line.separator") + "Sorry, parking lot is full"
				+ System.getProperty("line.separator") + "KA-01-HH-1234 KA-01-HH-9999 KA-01-P-333 "
				+ System.getProperty("line.separator") + "1 2 4 " + System.getProperty("line.separator") + "6"
				+ System.getProperty("line.separator") + "Not Found" + System.getProperty("line.separator"),
				os.toString());
	}
}
