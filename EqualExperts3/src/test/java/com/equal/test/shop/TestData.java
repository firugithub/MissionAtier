package com.equal.test.shop;

import java.util.ArrayList;
import java.util.List;

import com.equal.shop.model.Product;

public class TestData {
	public static final Product PRODUCT1 = new Product(1, "Dove Soap", 39.99);
	public static final Product PRODUCT2 = new Product(2, "Axe perfume", 99.99);
	public static final Product PRODUCT3 = new Product(3, "Uncle Chips", 319.998140);

	public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

	static {
		PRODUCT_LIST.add(PRODUCT1);
		PRODUCT_LIST.add(PRODUCT2);
		PRODUCT_LIST.add(PRODUCT3);
	}

}
