
public class WaitAndNotify {

	public static void main(String[] args) {

		MyWaitNotify obj = new MyWaitNotify();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				obj.doWait();
				obj.doNotify();

			}
		};
		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				obj.doNotify();
				obj.doWait();

			}
		};
		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable2, "t2");
		t1.start();
		t2.start();
	}

}

class MonitorObject {
}

class MyWaitNotify {

	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait() {
		synchronized (myMonitorObject) {
			try {
				System.out.println("Execute wait" + Thread.currentThread().getName());
				myMonitorObject.wait();
			} catch (InterruptedException e) {
			}
		}
	}

	public void doNotify() {
		synchronized (myMonitorObject) {
			System.out.println("Execute notify" + Thread.currentThread().getName());
			myMonitorObject.notify();
		}
	}
}
