package com.parkingLot.Vehicle;

import java.util.ArrayList;

import com.parkingLot.ParkingSpot;

/**
 * Vehicle class that is the parent of all vehicle types.It defines the basic
 * features of vehicles like color, license plate, number of spots needed.
 * 
 * @author srawat1
 *
 */
public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	public int spotsNeeded;
	protected VehicleSize size;
	protected Color color;

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getSize() {
		return size;
	}

	public ArrayList<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public Color getColor() {
		return color;
	}

	/* Park vehicle in this spot (among others, potentially) */
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}

	/* Remove car from spot, and notify spot that it's gone */
	public void clearSpots() {
		for (int i = 0; i < parkingSpots.size(); i++) {
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);

	public abstract void print();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((parkingSpots == null) ? 0 : parkingSpots.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + spotsNeeded;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (color != other.color)
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (parkingSpots == null) {
			if (other.parkingSpots != null)
				return false;
		} else if (!parkingSpots.equals(other.parkingSpots))
			return false;
		if (size != other.size)
			return false;
		if (spotsNeeded != other.spotsNeeded)
			return false;
		return true;
	}

}