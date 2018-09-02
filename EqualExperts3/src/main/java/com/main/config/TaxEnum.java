package com.main.config;

/**
 * Enum that will hold different tax slabs. Acc to the current applicable taxes
 * we can pick the tax head and it's specified percentage.
 */
public enum TaxEnum {
	NORMAL_TAX(12.5);
	private double taxPercentage;

	private TaxEnum(double percentage) {
		setTaxPercentage(percentage);
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
}
