package iterator;

import java.util.*;

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
