package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaWithAndWithoutFunctions {

	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream().filter(LambdaWithAndWithoutFunctions::isOdd) // Predicate
																				// is
				// functional
				// interface and
				.filter(LambdaWithAndWithoutFunctions::isGreaterThan3) // we are
																		// using
																		// lambdas
																		// to
				// initialize it
				.filter(LambdaWithAndWithoutFunctions::isLessThan11) // rather
																		// than
																		// anonymous
																		// inner
				// classes
				.max(Comparator.naturalOrder()).map(i -> i * i).get();
	}

	public static long findSquareOfMaxOdd2(List<Integer> numbers) {
		return numbers.stream().filter(i -> i % 2 != 0).filter(i -> i > 3).filter(i -> i < 11)
				.max(Comparator.naturalOrder()).map(i -> i * i).get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i) {
		return i > 3;
	}

	public static boolean isLessThan11(int i) {
		return i < 11;
	}

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(9);
		System.out.println(findSquareOfMaxOdd(list));
		System.out.println(findSquareOfMaxOdd2(list));
	}

}
