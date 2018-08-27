package JavaLearn;

public class PostIncrementandPreIncrement {

	public static void main(String[] args) {
		int count = 5;
		count--;
		System.out.println(count);
		--count;
		System.out.println(count);
		System.out.println(count--);
		System.out.println(count);
		System.out.println(++count);
		System.out.println(count);
		while (count-- > 0) {
			System.out.println(count);
		}
	}

}
