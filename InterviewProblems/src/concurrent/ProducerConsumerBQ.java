package concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {

    private final BlockingQueue<Integer> bq;

    // private final Random random = new Random();

    public Producer(BlockingQueue<Integer> producerQueue) {
	this.bq = producerQueue;
    }

    public void run() {
	while (true) {
	    try {
		bq.put(new Random().nextInt(100));
		Thread.sleep(20);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Integer> producerQueue;

    public Consumer(BlockingQueue<Integer> producerQueue) {
	this.producerQueue = producerQueue;
    }

    public void run() {
	while (true) {
	    try {
		Integer i = producerQueue.take();
		System.out.println(i);
		Thread.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}

public class ProducerConsumerBQ {
    public static void main(String[] args) {
	BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
	for (int i = 0; i < 3; i++) {
	    new Thread(new Producer(queue)).start();
	}

	for (int i = 0; i < 5; i++) {
	    new Thread(new Consumer(queue)).start();
	}

    }
}
