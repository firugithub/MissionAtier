package com.equal.test.shop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.equal.shop.ShoppingCart;
import com.equal.shop.ShoppingCartService;
import com.equal.shop.ShoppingCartServiceImpl;

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
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 200, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 649.99, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 2);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1289.99, 0);
	}

	// Test to check that null product is not added to cart
	@Test
	public void testInvalidProductAddToCart() {
		shoppingCart = shoppingCartService.addToCart(null, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 0, 0);
		Assert.assertTrue(shoppingCart.isEmpty());
	}

	// Test to check that 0 quantity does not change to the shopping cart.
	@Test
	public void testInvalidNumberBeingAdded() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, Integer.MIN_VALUE);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 0, 0);
		Assert.assertTrue(shoppingCart.isEmpty());
	}

	// Test to check that null product is not added and state of the cart
	// remains same.
	@Test
	public void testCartStateWithInvalidAdditions() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 200, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 2);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 599.99, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1049.98, 0);
		shoppingCart = shoppingCartService.addToCart(null, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1049.98, 0);
		Assert.assertFalse(shoppingCart.isEmpty());
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 2);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1689.98, 0);
		shoppingCart = shoppingCartService.addToCart(null, 0);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1689.98, 0);
		Assert.assertFalse(shoppingCart.isEmpty());
	}

	// Test to check that multiple additions of different quantity of same
	// product is reflected properly in cart total value.
	@Test
	public void testCartForMultipleAddSameProd() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 200, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 2);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 599.99, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1049.98, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 2);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 1689.98, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 6);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 3609.97, 0);
		Assert.assertEquals(12, shoppingCart.getTotalCartQuantity());
	}

	// Test to check that multiple additions of different quantity of same
	// product is reflected properly in cart total size.
	@Test
	public void testCartSizeForMultipleAddSameProd() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 1);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 2);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 1);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 2);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT3, 6);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 12);
		Assert.assertEquals(24, shoppingCart.getTotalCartQuantity());
	}

}
