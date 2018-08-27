package InheritanceTest;

class ChildOfParent extends Parent {
	public void A() {
		System.out.println("Child's A");
	}

	public void B() {
		System.out.println("Child's B");
	}
}

public class Child {
	public static void main(String args[]) {
		Parent p = new ChildOfParent();
		ChildOfParent p2 = new ChildOfParent();
		p.A();
		p2.A();
		p2.B();

	}
}
