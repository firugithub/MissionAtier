package com.equal.shop;

import java.util.HashMap;
import java.util.Map;

import com.equal.shop.model.Product;
import com.equal.util.Utilities;

/*
 * This class represents a shopping cart to which we can add products.Each product is wrapped as Cart Item,
 * that will give the product details and it's price.By that we can calculate the total value of the cart.
 */
public class ShoppingCart {
	Map<Product, Integer> items;
	double totalCartValue;

	public ShoppingCart() {
		this.items = new HashMap<>();
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
			items.put(product, items.get(product) + quantity);
		} else
			items.put(product, quantity);
		totalCartValue = Utilities.roundOff(totalCartValue + product.getPrice() * quantity);
	}

	public double getTotalCartValue() {
		return totalCartValue;
	}

	public boolean isEmpty() {
		return items.size() > 0;
	}

}
