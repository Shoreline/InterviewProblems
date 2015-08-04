package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Take advantage of Java's build-in Semaphore class
 *
 * semaphore here controls the amount of concurrent threads. How is that
 * different from Executors.newFixedThreadPool()?
 */
public class SemaphoreLearn {

    public static void main(String[] args) {
	ExecutorService executorService = Executors.newCachedThreadPool();
	final Semaphore semaphore = new Semaphore(3); // 信号灯，有3个许可，只能有3个并发线程

	for (int i = 0; i < 10; i++) {
	    executorService.submit(new Runnable() {
		public void run() {
		    try {
			semaphore.acquire();// 获取许可，没有许可的，只能等待

			System.out.println("线程"
				+ Thread.currentThread().getName() + "进入，当前已有"
				+ (3 - semaphore.availablePermits()) + "线程并发.");

			Thread.sleep((long) (Math.random() * 5000));

		    } catch (InterruptedException e) {
			e.printStackTrace();
		    } finally {
			semaphore.release();

			System.out.println("线程"
				+ Thread.currentThread().getName() + "已离开，当前还有"
				+ (3 - semaphore.availablePermits()) + "线程并发.");
		    }
		}
	    });
	}
	executorService.shutdown();
    }
}