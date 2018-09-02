package com.equal.test.shop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.equal.shop.ShoppingCart;
import com.equal.shop.ShoppingCartService;
import com.equal.shop.ShoppingCartServiceImpl;
import com.equal.util.Utilities;

public class TestShoppingCartService {

	protected ShoppingCartService shoppingCartService;
	protected ShoppingCart shoppingCart;

	@Before
	public void setup() {
		shoppingCartService = new ShoppingCartServiceImpl();
	}

	// Test to check whether the required items are added and their cost is
	// reflected in the total cart value.
	@Test
	public void testAddToCart() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 2);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 2);
		Assert.assertEquals(Utilities.roundOff(shoppingCart.totalTaxOnCart()), 34.99, 0);
		Assert.assertEquals(shoppingCart.getTotalCartValueWithTax(), 314.95, 0);
	}
}
