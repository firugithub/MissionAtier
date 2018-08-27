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

	@Test
	public void testAddToCart() {
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT1, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 200, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 1);
		Assert.assertEquals(shoppingCart.getTotalCartValue(), 649.99, 0);
		shoppingCart = shoppingCartService.addToCart(TestData.PRODUCT2, 2);
	}

}
