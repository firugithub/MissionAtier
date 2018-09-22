package com.parkingLot.service;

import com.parkingLot.ParkingLot;
import com.parkingLot.ParkingTicket;
import com.parkingLot.Util.Constants;
import com.parkingLot.Vehicle.Color;
import com.parkingLot.Vehicle.Vehicle;

/**
 * Parking lot service concrete class.
 * 
 * @author srawat1
 *
 */
public class ParkingLotServiceImpl implements ParkingLotService {
	ParkingLot lot;
	CachingService cachingService = new CachingService();

	public void initParkingLot(int totalParkingSpots) {
		lot = new ParkingLot(Constants.DEFAULT_NUM_OF_PARKING_LEVEL, totalParkingSpots);
	}

	public void initParkingLot(int noOfLevels, int totalParkingSpots) {
		lot = new ParkingLot(noOfLevels, totalParkingSpots);
	}

	public ParkingTicket parkVehicle(Vehicle v) {
		ParkingTicket ticket = lot.parkVehicle(v);
		if (null != ticket) {
			cachingService.updateParkedVehicleCaches(ticket);
		}
		return ticket;
	}

	/*
	 * This method is just to display the simple flow of the problem statment
	 * where we use only spotNumber to free it up otherwise we will use ticketId
	 * to free the spots.
	 */
	public void removeVehicle(int spotNumber) {
		spotNumber = spotNumber - 1;
		Vehicle removedVehicle = lot.removeVehicle(spotNumber);
		cachingService.removeFromSpotCache(removedVehicle);
		cachingService.removeFromParkedVehicleColorCache(removedVehicle);
	}

	public void printStatus() {
		lot.print();

	}

	public void printCaches() {
		cachingService.printBothCache();
	}

	public void getRegNumOfAllCarsFromColor(Color color) {
		cachingService.getRegNumOfAllCarsFromColor(color);
	}

	public void getSlotNumberFromRegNum(String regNum) {
		cachingService.getSlotNumberFromRegNum(regNum);
	}

	public void getAllSlotNumberFromColor(Color color) {
		cachingService.getAllSlotNumberFromColor(color);
	}
}
