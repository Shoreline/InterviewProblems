package math;

import java.util.*;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure. double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * 
 * add(1)
 * 
 * add(2)
 * 
 * findMedian() -> 1.5
 * 
 * add(3)
 * 
 * findMedian() -> 2
 *
 */

/*
 * Max-heap small has the smaller half of the numbers. Min-heap large has the
 * larger half of the numbers. This gives me direct access to the one or two
 * middle values (they're the tops of the heaps), so getting the median takes
 * O(1) time. And adding a number takes O(log n) time.
 * 
 * Supporting both min- and max-heap is more or less cumbersome, depending on
 * the language, so I simply negate the numbers in the heap in which I want the
 * reverse of the default order. To prevent this from causing a bug with -231
 * (which negated is itself, when using 32-bit ints), I use integer types larger
 * than 32 bits.
 */
public class FindMedianFromDataStream {
    class MedianFinder {
	PriorityQueue<Long> large = new PriorityQueue<>();
	PriorityQueue<Long> small = new PriorityQueue<>();

	// Adds a number into the data structure.
	public void addNum(int num) {
	    large.add((long) num);
	    small.add(-large.poll());
	    if (small.size() > large.size()) {
		large.add(-small.poll());
	    }
	}

	// Returns the median of current data stream
	public double findMedian() {
	    if (large.size() > small.size()) {
		return large.peek();
	    } else {
		return ((double) large.peek() - small.peek()) / 2.0;
	    }
	}
    }
}
