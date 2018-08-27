
public class MyThread implements Runnable {

	public static void main(String[] args) {
		MyThread obj = new MyThread();
		Thread t = new Thread(obj);
		t.start();

	}

	@Override
	public void run() {
		System.out.println("Inside Thread");
	}
}
