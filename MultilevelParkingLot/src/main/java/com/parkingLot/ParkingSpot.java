package com.parkingLot;

import com.parkingLot.Vehicle.Vehicle;
import com.parkingLot.Vehicle.VehicleSize;

/**
 * Class that represents a parking spot.
 * 
 * @author srawat1
 *
 */
public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
		level = lvl;
		row = r;
		spotNumber = n + 1;
		spotSize = sz;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	/*
	 * Checks if the spot is big enough for the vehicle (and is available). This
	 * compares the SIZE only. It does not check if it has enough spots.
	 */
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}

	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public VehicleSize getSize() {
		return spotSize;
	}

	public Level getLevel() {
		return level;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/*
	 * Remove vehicle from spot, and notify level that a new spot is available
	 */
	public void removeVehicle() {
		/**
		 * For the case with multiple levels of car park
		 */
		// System.out.println("Slot number:" + getLevel() + "-" + getRow() + "-"
		// + getSpotNumber() + " is free.");

		/**
		 * For the test case mentioned in problem stmt.
		 */
		System.out.println("Slot number " + getSpotNumber() + " is free.");
		level.spotFreed();
		vehicle = null;
	}

	public void print() {
		if (vehicle == null) {
			System.out.print("Empty Slot");
		} else {
			System.out.print(spotNumber + "                ");
			vehicle.print();
		}
	}

	@Override
	public String toString() {
		return "ParkingSpot [row=" + row + ", spotNumber=" + spotNumber + ", level=" + level + "]";
	}

}