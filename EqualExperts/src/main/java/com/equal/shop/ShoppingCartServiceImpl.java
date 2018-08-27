package com.equal.shop;

import com.equal.shop.model.Product;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	ShoppingCart shoppingCart = new ShoppingCart();

	@Override
	public ShoppingCart addToCart(Product product, int quantity) {
		if (null == product) {
			System.out.println("Invalid Product being added.");
		}
		if (quantity > 0)
			shoppingCart.addItem(product, quantity);

		return shoppingCart;
	}

}
