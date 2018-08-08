package test;

import org.junit.Test;

import com.StackImpl;

public class StackImplTest {

	@Test
	public void test() {
		StackImpl stackImpl = new StackImpl(10);
		for (int i = 0; i < 10; i++) {
			stackImpl.push(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(stackImpl.pop());
		}
	}
}
