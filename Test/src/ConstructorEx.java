public class ConstructorEx extends Parent {
	int value1;
	int value2;

	ConstructorEx() {
		value1 = 10;
		value2 = 20;
		System.out.println("Inside 1st Constructor");
	}

	ConstructorEx(int a) {
		value1 = a;
		System.out.println("Inside 2nd Constructor");
	}

	ConstructorEx(int a, int b) {
		value1 = a;
		value2 = b;
		System.out.println("Inside 3rd Constructor");
	}

	public void display() {
		System.out.println("Value1 === " + value1);
		System.out.println("Value2 === " + value2);
	}

	public static void main(String args[]) {
		ConstructorEx d1 = new ConstructorEx();
		ConstructorEx d2 = new ConstructorEx(30);
		ConstructorEx d3 = new ConstructorEx(30, 40);
		d1.display();
		d2.display();
		d3.display();
	}
}

class Parent {

	Parent() {
		System.out.println("Inside Parent's constructor");
	}

}