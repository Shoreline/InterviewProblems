package linkedin;

/**
 * makes the thread to wait if value is lesser than waitCount and notifyCount is
 * empty
 *
 */
public class CountingSemaphore {
    private int value = 0;
    private int waitCount = 0;
    private int notifyCount = 0;

    public CountingSemaphore(int initial) {
	if (initial > 0) {
	    value = initial;
	}
    }

    public synchronized void waitForNotify() {
	if (value <= waitCount) {
	    waitCount++;
	    try {
		do {
		    wait();
		} while (notifyCount == 0);
	    } catch (InterruptedException e) {
		notify();
	    } finally {
		waitCount--;
	    }
	    notifyCount--;
	}
	value--;
    }

    // notify to wake up
    public synchronized void signal() {
	value++;
	if (waitCount > notifyCount) {
	    notifyCount++;
	    notify();
	}
    }
}