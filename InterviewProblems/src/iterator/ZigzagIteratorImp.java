package iterator;

import java.util.*;

/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2] v2 = [3, 4, 5, 6]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * Clarification for the follow up question - Update (2015-09-18):
 * 
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
 * example, given the following input:
 * 
 * [1,2,3]
 * 
 * [4,5,6,7]
 * 
 * [8,9]
 * 
 * It should return [1,4,8,2,5,9,3,6,7].
 *
 */
/*
 * Note: ZigzagIterator class does not implements Iterator<Integer> so no need
 * to add @Override annotations.
 */
public class ZigzagIteratorImp {
    public class ZigzagIterator {
	List<Iterator<Integer>> itrs;
	int ptr;
	Integer next;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    itrs = new ArrayList<>();
	    itrs.add(v1.iterator());
	    itrs.add(v2.iterator());
	    ptr = 0;
	}

	public int next() {
	    if (next != null || hasNext()) {
		Integer res = next;
		ptr = (ptr + 1) % itrs.size();
		next = null;
		return res;
	    } else {
		throw new RuntimeException();
	    }
	}

	public boolean hasNext() {
	    if (next != null) {
		return true;
	    }

	    if (itrs.get(ptr).hasNext()) {
		next = itrs.get(ptr).next();
		return true;
	    }

	    int count = 0;
	    while (!itrs.get(ptr).hasNext() && count < itrs.size()) {
		ptr = (ptr + 1) % itrs.size();
		count++;
	    }
	    return itrs.get(ptr).hasNext();
	}
    }

}
