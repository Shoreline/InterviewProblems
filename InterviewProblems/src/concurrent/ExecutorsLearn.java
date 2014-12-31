package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsLearn {

    public static final class StringTask implements Callable<String> {
	int taskNum;

	public StringTask(int _taskNum) {
	    taskNum = _taskNum;
	}

	@Override
	public String call() throws Exception {
	    System.out.println(Thread.currentThread().getName() + ": "
		    + taskNum + " is running");
	    return Thread.currentThread().getName() + ": " + taskNum
		    + " has finished running.";
	}

    }

    public static void main(String[] args) throws Exception {
	ExecutorService threadPool = Executors.newFixedThreadPool(4);

	/*
	 * catch callable results through Future drawback: future.get() will not
	 * return anything until the callable finished
	 */
	List<Future<String>> futures = new ArrayList<Future<String>>();

	for (int i = 0; i < 10; i++) {
	    Future<String> future = threadPool.submit(new StringTask(i));
	    futures.add(future);
	}

	for (Future<String> future : futures) {
	    System.out.println(future.get());
	}
	// ============== end of using Future ============

	System.out.println("\n\n");
	
	/*
	 * catch callable results through CompletionService
	 */
	CompletionService<String> pool = new ExecutorCompletionService<String>(
		threadPool);
	for (int i = 0; i < 10; i++) {
	    pool.submit(new StringTask(i + 10));
	}
	for (int i = 0; i < 10; i++) {
	    System.out.println(pool.take().get());
	}
	// ================ end of using CompletionService ==============
	threadPool.shutdown();
    }

}
