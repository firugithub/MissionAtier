package com.parkingLot;

import java.util.Date;

import com.parkingLot.Vehicle.Vehicle;

/**
 * Class to represent a parking ticket.
 * 
 * @author srawat1
 *
 */
public class ParkingTicket {

	private static int ticketId = 0;
	Vehicle vehicle;
	Date parkingTimestamp;

	public ParkingTicket(Vehicle vehicle, Date parkingTimestamp) {
		super();
		this.vehicle = vehicle;
		this.parkingTimestamp = parkingTimestamp;
		setTicketId(++ticketId);
	}

	private void setTicketId(int id) {
		this.ticketId = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getParkingTimestamp() {
		return parkingTimestamp;
	}

	/*
	 * can be used in case when we have more than one level with multiple rows
	 * in each level.And also when vehicle can occupy multiple parking spots.
	 * 
	 */
	// @Override
	// public String toString() {
	// String spotNumStr = "";
	// for (ParkingSpot spot : vehicle.getParkingSpots()) {
	// spotNumStr = spotNumStr + "Level:" + spot.getLevel() + "Row:" +
	// spot.getRow() + "Number:"
	// + spot.getSpotNumber();
	// }
	// return "Allocated slot number:" + spotNumStr;
	// }
	/*
	 * For depicting the simple flow with one level and one row i am using this
	 * method.Here assumption is vehicle will occupy only one parking spot.
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return "Allocated slot number:" + vehicle.getParkingSpots().get(0).getSpotNumber();
	}

}
