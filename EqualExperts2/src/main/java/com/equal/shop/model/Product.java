package com.equal.shop.model;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private int pId;
	private String pName;
	private double pPrice;

	public Product(int pId, String pName, double pPrice) {
		setId(pId);
		setName(pName);
		setPrice(pPrice);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Product))
			return false;

		return (this.pId == ((Product) o).getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public int getId() {
		return pId;
	}

	public void setId(int id) {
		this.pId = id;
	}

	public String getName() {
		return pName;
	}

	public void setName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return pPrice;
	}

	public void setPrice(double pPrice) {
		this.pPrice = pPrice;
	}

}
