package com.equal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilities {
	/**
	 * Utility function to round off the price to 2 decimal places
	 *
	 * @param price
	 * @return
	 */
	public static double roundOff(double price) {
		BigDecimal bd = new BigDecimal(price);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
