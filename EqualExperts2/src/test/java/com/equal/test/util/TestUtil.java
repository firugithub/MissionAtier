package com.equal.test.util;

import org.junit.Assert;
import org.junit.Test;

import com.equal.util.Utilities;

public class TestUtil {

	// Test to check the rounding off
	@Test
	public void test() {
		Assert.assertEquals(Utilities.roundOff(0.567), 0.57, 0);
		Assert.assertEquals(Utilities.roundOff(0.564), 0.56, 0);
	}

}
