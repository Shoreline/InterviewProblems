package concurrent;

/* 
 * java.lang.Object.notify(): Wakes up a single thread that is waiting on this object's monitor
 * 
 */
public class ImplementSemaphore {
    // This is a counting semaphore
    class Semaphore {
	private int permits = 0;

	public Semaphore(int _permits) {
	    permits = _permits;
	}

	/**
	 * Acquires a permit if one is available and decrements the number of
	 * available permits by 1. If no permit is available then the current
	 * thread waits until one of the following things happen > >some other
	 * thread calls release() method on this semaphore or, >some other
	 * thread interrupts the current thread.
	 */
	public synchronized void acquire() throws InterruptedException {
	    // Acquires a permit, if permits is greater than 0 decrements
	    // the number of available permits by 1.
	    if (permits > 0) {
		permits--;
	    }
	    // permit is not available wait, when thread
	    // is notified it decrements the permits by 1
	    else {
		this.wait();
		permits--;
	    }
	}

	/**
	 * Releases a permit and increases the number of available permits by 1.
	 * For releasing lock by calling release() method it’s not mandatory
	 * that thread must have acquired permit by calling acquire() method.
	 */
	public synchronized void release() {
	    // increases the number of available permits by 1.
	    permits++;

	    // If permits are greater than 0, notify waiting threads.
	    if (permits > 0)
		this.notifyAll(); // this.notify()? - It may cause issues. If
				  // not sure, use notifyAll()
	}
    }

}

/**
 * makes the thread to wait if value is lesser than waitCount and notifyCount is
 * empty
 *
 */
//public class CountingSemaphore {
//    private int value = 0;
//    private int waitCount = 0;
//    private int notifyCount = 0;
//
//    public CountingSemaphore(int initial) {
//	if (initial > 0) {
//	    value = initial;
//	}
//    }
//
//    public synchronized void waitForNotify() {
//	if (value <= waitCount) {
//	    waitCount++;
//	    try {
//		do {
//		    wait();
//		} while (notifyCount == 0);
//	    } catch (InterruptedException e) {
//		notify();
//	    } finally {
//		waitCount--;
//	    }
//	    notifyCount--;
//	}
//	value--;
//    }
//
//    // notify to wake up
//    public synchronized void signal() {
//	value++;
//	if (waitCount > notifyCount) {
//	    notifyCount++;
//	    notify();
//	}
//    }
//}
