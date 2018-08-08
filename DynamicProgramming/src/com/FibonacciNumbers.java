package com;

public class FibonacciNumbers {

	public static void main(String[] args) {
		System.out.println(fib(10));

	}

	static int fib(int n) {
		int a = 0, b = 1, c, i;
		if (n == 0)
			return a;
		for (i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	static int fib2(int n) {
		/* Declare an array to store Fibonacci numbers. */
		int f[] = new int[n + 1];
		int i;

		/* 0th and 1st number of the series are 0 and 1 */
		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			/*
			 * Add the previous 2 numbers in the series and store it
			 */
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}
}
