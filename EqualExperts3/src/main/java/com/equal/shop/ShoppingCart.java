package com.equal.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.equal.shop.model.Product;
import com.equal.shop.model.Tax;
import com.equal.util.Utilities;
import com.main.config.TaxEnum;

/*
 * This class represents a shopping cart to which we can add products.Each product is wrapped as Cart Item,
 * that will give the product details and it's price.By that we can calculate the total value of the cart.
 */
public class ShoppingCart {
	Map<Product, Integer> items;
	double totalCartValue;
	Tax taxObj;

	// Default constructor will add basic tax to the overall cart bill
	// calculation .
	public ShoppingCart() {
		this.items = new HashMap<>();
		List<TaxEnum> defaultTaxList = new ArrayList<>();
		defaultTaxList.add(TaxEnum.NORMAL_TAX);
		this.taxObj = new Tax(defaultTaxList);
	}

	// Parametrized constructor to allow user to provide what all taxes to add
	// in the final bill.
	public ShoppingCart(List<TaxEnum> taxList) {
		this.items = new HashMap<>();
		this.taxObj = new Tax(taxList);
	}

	/**
	 * Adds a product to the cart with the specified quantity.If the item is
	 * already present then simply increase it's quantity.
	 *
	 * @param newProduct
	 * @param quantity
	 */
	public void addItem(Product product, int quantity) {
		if (items.containsKey(product)) {
			updateCart(product, quantity);
		} else
			items.put(product, quantity);
		totalCartValue = totalCartValue + product.getPrice() * quantity;
	}

	/**
	 * Updates an existing product count in the cart with the specified
	 * quantity.
	 *
	 * @param product
	 * @param quantity
	 */
	private void updateCart(Product product, int quantity) {
		items.put(product, items.get(product) + quantity);
	}

	public double getTotalCartValueWithoutTax() {
		return Utilities.roundOff(totalCartValue);
	}

	public double getTotalCartValueWithTax() {
		return Utilities.roundOff(totalTaxOnCart() + totalCartValue);
	}

	public boolean isEmpty() {
		return items.size() == 0;
	}

	/**
	 * Returns the total addition of the quantity of all product types present
	 * in the cart.
	 */
	public int getTotalCartQuantity() {
		return items.values().stream().mapToInt(Integer::intValue).sum();
	}

	/**
	 * Calls the utility method that will do calculation of overall tax
	 * applicable on the cart value.
	 *
	 * @return total tax on cart value.
	 */
	public double totalTaxOnCart() {
		return Utilities.calculateTaxAmount(totalCartValue, taxObj);
	}

}
