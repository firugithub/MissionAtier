package com.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Given_an_array_of_numbers_arrange_the_numbers_to_form_the_biggest_number {
	// o(mnlogn) - m is the min no digits in a number and n are total no
	public static void main(String[] args) {
		Integer arr[] = { 54, 546, 548, 60 };

		// output should be 777776
		/*
		 * arr.add("7"); arr.push_back("776"); arr.push_back("7");
		 * arr.push_back("7");
		 */

		// output should be 998764543431
		/*
		 * arr.push_back("1"); arr.push_back("34"); arr.push_back("3");
		 * arr.push_back("98"); arr.push_back("9"); arr.push_back("76");
		 * arr.push_back("45"); arr.push_back("4");
		 */

		Arrays.sort(arr, new Comparator<Integer>() {

			public int compare(Integer X, Integer Y) {
				return (Y + "" + X).compareTo(X + "" + Y);
			}
		});
		String result = "";

		for (int i : arr) {

			result += i;

		}

		System.out.println(result);
	}
}
