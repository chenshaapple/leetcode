package yxc.exp;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SleepWithLock {
	private int num;
	@Test(timeout=1000)
	public void sleepWithLock() throws InterruptedException {
		Thread t2 = new Thread(() -> {
			synchronized (this) {
				try {
					System.out.println("thread 2 is running");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t1 = new Thread(() -> {
			synchronized (this) {
				try {
					t2.start();
					for(int i = 0; i< 10; i++) {
						System.out.println(num++);
						TimeUnit.SECONDS.sleep(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t1.join();
		t2.join();
	}
}
