package concurrent;

import java.util.concurrent.Semaphore;

/*
 * The actual work is done in the class that has semaphore object. Whether a work can be started depends on if semaphore.acquire() is successful.
 * 
 * Remember to do semaphore.release() after work is done.
 * 
 * * Even set the semaphore fairness to false, still seems fifo?
 */
public class SemaphoreLearnII {
    /*
     * Printer is a resource. One printer can always print at most one document
     * at a time
     */
    class Printer {
	private Semaphore semaphore;

	public Printer() {
	    semaphore = new Semaphore(1, false);
	}

	public void print(Object document) {
	    try {
		semaphore.acquire();

		long duration = (long) (Math.random() * 5000);
		System.out.printf(
			"%s: PrintQueue: Printing a Job during %d seconds\n",
			Thread.currentThread().getName(), duration);
		Thread.sleep(duration);

	    } catch (InterruptedException e) {
		e.printStackTrace();
	    } finally {
		semaphore.release();
	    }
	}
    }

    /*
     * PrintingJobs are tasks that can be run concurrently. Each of them will
     * need a resource class, printer, to run
     */
    class PrintingJob implements Runnable {
	private Printer printer;

	public PrintingJob(Printer _printer) {
	    printer = _printer;
	}

	@Override
	public void run() {
	    System.out.printf("%s: Going to print a job\n", Thread
		    .currentThread().getName());
	    printer.print(new Object());
	    System.out.printf("%s: The document has been printed\n", Thread
		    .currentThread().getName());
	}
    }

    public static void main(String[] args) {
	Printer printer = new SemaphoreLearnII().new Printer();
	Thread[] threads = new Thread[10];

	for (int i = 0; i < 10; i++) {
	    threads[i] = new Thread(new SemaphoreLearnII().new PrintingJob(printer), "Job " + i);
	}

	for (int i = 0; i < 10; i++) {
	    threads[i].start();
	}
    }
}
