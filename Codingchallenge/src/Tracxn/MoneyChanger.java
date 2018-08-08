package Tracxn;

public class MoneyChanger {

	public static void main(String[] args) {
		System.out.println(maxChange(24));

	}
	
	private static int maxChange(int value)
	{
		if(value<=1)
		{
			return value;
		}
		int a = maxChange(value/2);
		int b = maxChange(value/3);
		int c = maxChange(value/4);
		
		return Math.max(a+b+c,value);
	}

}
