package com.parkingLot.service;

import java.util.ArrayList;
import java.util.List;

import com.parkingLot.ParkingSpot;
import com.parkingLot.ParkingTicket;
import com.parkingLot.Vehicle.Color;
import com.parkingLot.Vehicle.Vehicle;
import com.parkingLot.cache.ParkedVehicleColorCache;
import com.parkingLot.cache.ParkingSpotCache;

/**
 * Caching Service class that will interact with the cache and provided a loose
 * coupling for the main service layer.As this class will be the only one who
 * will have information about the caching implementation and it will be the
 * only one interacting with the caching layer.
 * 
 * @author srawat1
 *
 */
public class CachingService {
	ParkedVehicleColorCache pvColorCache;
	ParkingSpotCache spotCache;

	public CachingService() {
		pvColorCache = new ParkedVehicleColorCache();
		spotCache = new ParkingSpotCache();
	}

	public void updateParkedVehicleCaches(ParkingTicket ticket) {
		Color color = ticket.getVehicle().getColor();
		addToParkedVehicleColorCache(ticket, color);
		addToSpotCache(ticket);
	}

	/*
	 * This cache is designed keeping in mind that one vehicle is currently
	 * occupying one parking spot. It can be easily extended to have vehicle
	 * with multiple parking spot requirement.
	 */
	private void addToSpotCache(ParkingTicket ticket) {
		spotCache.getParkingSpotCache().put(ticket.getVehicle().getLicensePlate(),
				ticket.getVehicle().getParkingSpots().get(0));
	}

	private void addToParkedVehicleColorCache(ParkingTicket ticket, Color color) {
		List<Vehicle> list;
		if (pvColorCache.getColorToVehicleCache().get(color) != null) {
			pvColorCache.getColorToVehicleCache().get(color).add(ticket.getVehicle());
		} else {
			list = new ArrayList<Vehicle>();
			list.add(ticket.getVehicle());
			pvColorCache.getColorToVehicleCache().put(color, list);
		}

	}

	public void removeFromSpotCache(Vehicle removedVehicle) {
		spotCache.getParkingSpotCache().remove(removedVehicle.getLicensePlate());

	}

	public void removeFromParkedVehicleColorCache(Vehicle removedVehicle) {
		pvColorCache.getColorToVehicleCache().get(removedVehicle.getColor()).remove(removedVehicle);
		if (pvColorCache.getColorToVehicleCache().get(removedVehicle.getColor()).size() == 0)
			pvColorCache.getColorToVehicleCache().remove(removedVehicle.getColor());

	}

	public void printBothCache() {
		System.out.println("-----------");
		System.out.println(pvColorCache.getColorToVehicleCache());
		System.out.println("-----------");
		System.out.println(spotCache.getParkingSpotCache());

	}

	/*
	 * Registration numbers of all cars of a particular colour.
	 */
	public void getRegNumOfAllCarsFromColor(Color color) {
		List<Vehicle> vehicleList = pvColorCache.getColorToVehicleCache().get(color);
		if (vehicleList != null) {
			for (Vehicle vehicle : vehicleList) {
				System.out.print(vehicle.getLicensePlate() + " ");
			}
			System.out.println("");
		} else {
			System.out.println("Not Found");
		}
	}

	/*
	 * Slot number in which a car with a given registration number is parked.
	 */
	public void getSlotNumberFromRegNum(String regNum) {
		ParkingSpot spot = spotCache.getParkingSpotCache().get(regNum);
		if (spot == null) {
			System.out.println("Not Found");
		} else {
			System.out.println(spot.getSpotNumber());
		}

	}

	/*
	 * This method is written kept in mind that right now one vehicle can occupy
	 * only one spot.But it is extendable to multiple spot cases too.
	 * 
	 * Function - Slot numbers of all slots where a car of a particular colour
	 * is parked.
	 */
	public void getAllSlotNumberFromColor(Color color) {
		List<Vehicle> vehicleList = pvColorCache.getColorToVehicleCache().get(color);
		if (vehicleList != null) {
			for (Vehicle vehicle : vehicleList) {
				System.out.print(vehicle.getParkingSpots().get(0).getSpotNumber() + " ");
			}
			System.out.println("");
		} else {
			System.out.println("Not Found");
		}
	}

}
