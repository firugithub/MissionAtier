public class ab implements interface1, interface2 {

	@Override
	public void run() {
		System.out.println("check");
	}

	public int methodOne() {
		System.out.println("we are in first methodOne");
		return 1;
	}

	public static void main(String args[]) {
		ab obj = new ab();
		obj.run();
	}

}
