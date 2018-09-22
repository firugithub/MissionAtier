package com.parkingLot.Vehicle;

import com.parkingLot.ParkingSpot;

/**
 * Car that is of type vehicle.A car is right now requires only one parking
 * spot.This class defines features of a vehicle called as car.
 * 
 * @author srawat1
 *
 */
public class Car extends Vehicle {
	public Car(String licensePlate, Color color) {
		this.licensePlate = licensePlate;
		this.color = color;
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	/* Checks if the spot is a Compact or a Large. */
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}

	public void print() {
		System.out.print(licensePlate + "              " + color);
	}

	public String toString() {
		return "Car [parkingSpots=" + parkingSpots + ", licensePlate=" + licensePlate + ", spotsNeeded=" + spotsNeeded
				+ ", size=" + size + ", color=" + color + "]";
	}

}