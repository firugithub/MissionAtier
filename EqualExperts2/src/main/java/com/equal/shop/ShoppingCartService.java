package com.equal.shop;

import com.equal.shop.model.Product;

public interface ShoppingCartService {
	/**
	 * Takes product and quantity to be added and adds to shopping cart .If
	 * invalid argument is provided then no change will happen.
	 * 
	 * @param product
	 * @param quantity
	 * @return
	 */
	ShoppingCart addToCart(Product product, int quantity);
}
