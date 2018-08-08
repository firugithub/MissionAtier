
public class PassByTest {
public static void main(String args[])
{
	A a = new A();
	A B = new A();
	a.m=10;
	B.m=20;
	switcha(a, B);
	System.out.println(a.m+" "+B.m);
	}

public static void switcha(A a ,A b)
{
	a.m=30;
	b=null;
	}
}
