package com.parkingLot;

import com.parkingLot.Vehicle.Vehicle;

/**
 * Class representing parking lot.A parking lot consists of multiple levels and
 * each level has multiple parking spots divided in rows.
 */
public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS;

	public ParkingLot(int noOfLevels, int totalParkingSpots) {
		this.NUM_LEVELS = noOfLevels;
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, totalParkingSpots);
		}

		System.out.println("Created a parking lot with " + totalParkingSpots + " slots");
	}

	/*
	 * Park the vehicle in a spot (or multiple spots). Return false if failed.
	 */
	public ParkingTicket parkVehicle(Vehicle vehicle) {
		ParkingTicket ticket;
		for (int i = 0; i < levels.length; i++) {
			ticket = levels[i].parkVehicle(vehicle);
			return ticket;
		}
		return null;
	}

	public void print() {
		for (int i = 0; i < levels.length; i++) {
			// System.out.println("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		// System.out.println("");
	}

	public Vehicle removeVehicle(int spotNumber) {
		Vehicle removedVehicle = levels[0].getSpots()[spotNumber].getVehicle();
		levels[0].getSpots()[spotNumber].removeVehicle();
		return removedVehicle;
	}
}