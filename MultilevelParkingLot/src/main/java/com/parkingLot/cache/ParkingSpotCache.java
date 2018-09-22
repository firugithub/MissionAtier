package com.parkingLot.cache;

import java.util.HashMap;
import java.util.Map;

import com.parkingLot.ParkingSpot;

/**
 * This class is to mimick the caching layer.This cache will contain the
 * registration number to occupied spots mappings.
 * 
 * @author srawat1
 *
 */
public class ParkingSpotCache {
	final Map<String, ParkingSpot> parkingSpotCache = new HashMap<String, ParkingSpot>();

	public Map<String, ParkingSpot> getParkingSpotCache() {
		return parkingSpotCache;
	}

}
