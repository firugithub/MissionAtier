package com.equal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.equal.shop.model.Tax;
import com.main.config.TaxEnum;

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

	/**
	 * Utility function to calculate final cart tax after computation of all the
	 * taxes.
	 *
	 * @param totalCartValue
	 * @param taxObj
	 * @return
	 */
	public static double calculateTaxAmount(double totalCartValue, Tax taxObj) {
		// We can add some error handling here.
		if (null == taxObj)
			return 0;
		double totalTax = 0;
		for (TaxEnum tax : taxObj.getTaxList()) {
			totalTax = totalTax + ((totalCartValue * tax.getTaxPercentage()) / 100);
		}
		return totalTax;
	}
}
