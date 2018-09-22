package com.parkingLot.service;

import com.parkingLot.ParkingTicket;
import com.parkingLot.Vehicle.Color;
import com.parkingLot.Vehicle.Vehicle;

/**
 * Interface to hold common parking lot services .
 * 
 * @author srawat1
 *
 */
public interface ParkingLotService {

	public void initParkingLot(int totalParkingSpots);

	public void initParkingLot(int noOfLevels, int totalParkingSpots);

	public ParkingTicket parkVehicle(Vehicle v);

	public void removeVehicle(int spotNumber);

	public void printStatus();

	public void printCaches();

	public void getRegNumOfAllCarsFromColor(Color color);

	public void getSlotNumberFromRegNum(String regNum);

	public void getAllSlotNumberFromColor(Color color);
}
