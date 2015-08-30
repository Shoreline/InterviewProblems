package iterator;

import java.util.*;

public class Vector2D {
    public class MyVector2D {
	/*
	 * itrStack can save Iterator<Integer> and Iterator<List<Integer>>
	 */
	Stack<Iterator> itrStack;
	Integer next;

	public MyVector2D(List<List<Integer>> vec2d) {
	    itrStack = new Stack<>();
	    itrStack.push(vec2d.iterator());
	}

	public int next() {
	    if (hasNext()) {
		int res = next;
		next = null;
		return res;
	    }

	    return -1;
	}

	public boolean hasNext() {
	    if (next != null) {
		return true;
	    }

	    while (!itrStack.isEmpty()) {
		Iterator itr = itrStack.peek();
		if (!itr.hasNext()) {
		    itrStack.pop();
		} else {
		    Object item = itr.next();
		    if (item instanceof Integer) {
			next = (Integer) item;
			return true;
		    } else {
			itrStack.push(((Iterable) item).iterator());
		    }
		}
	    }

	    return false;
	}
    }
}
