package google;

/**
 * 
 * 
 * Design a counter that returns the hits of the last 5 minutes
 *
 * 
 */

/*
 * First to confirm the accuracy. Below assume the accuracy is hits/second.
 */
public class DesignAHitCounter {
    class Method_LinkedList {
	class CountingNode {
	    long second; // second period
	    long hits;
	    CountingNode next;

	    public CountingNode(long second, long hits) {
		this.second = second;
		this.hits = hits;
	    }

	}

	class HitCounter {
	    private long hits;
	    private CountingNode head;
	    private CountingNode tail;
	    long duration;

	    public HitCounter(long duration) {
		this.duration = duration;
		head = tail = new CountingNode(0, 0);
		hits = 0;
	    }

	    public void hit() {
		long current = System.nanoTime() / (long) 10e9;
		if (current - tail.second > duration) {
		    head = tail = new CountingNode(current, 1);
		    hits = 0;
		} else if (tail.second == current) {
		    tail.hits++;
		} else {
		    tail.next = new CountingNode(current, 1L);
		    tail = tail.next;
		}

		hits++;
	    }

	    public long getHits() {
		long current = System.nanoTime() / (long) 10e9;

		if (current - tail.second > duration) {
		    head = tail = new CountingNode(0, 0);
		    hits = 0;
		} else {
		    while (current - head.second > duration) {
			hits -= head.hits;
			head = head.next;
		    }
		}

		return hits;
	    }
	}
    }
}
