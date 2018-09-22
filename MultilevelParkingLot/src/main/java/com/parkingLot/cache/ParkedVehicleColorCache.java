package com.parkingLot.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parkingLot.Vehicle.Color;
import com.parkingLot.Vehicle.Vehicle;

/**
 * This class is to mimick the caching layer.This cache will contain the color
 * to parked vehicle mappings.
 * 
 * @author srawat1
 *
 */
public class ParkedVehicleColorCache {

	final Map<Color, List<Vehicle>> colorToVehicleCache = new HashMap<Color, List<Vehicle>>();

	public Map<Color, List<Vehicle>> getColorToVehicleCache() {
		return colorToVehicleCache;
	}

}
