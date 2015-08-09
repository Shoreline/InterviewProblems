package linkedin;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Write a deep iterator to iterate through a list of objects or integer which
 * could be another list or integer. This is frequently asked by LinkedIn,
 * Twitter and Hulu.
 * 
 * For example, this collection contains Integer or another collection. L means
 * it is a collection that contains either integer or another L.
 * 
 * We would expect an iterator to loop through it will print out 1, 2, 3, 4, 5,
 * 6, 7, 8
 *
 */

/*
 * Two main fields in deep iterator:
 * 
 * 1. a Stack of Iterator
 * 
 * 2. an Integer pointing to the next available item
 */
@SuppressWarnings("unchecked")
public class DeepIterator {
    public class DeepIterator_Integer implements Iterator<Integer> {
	private Stack<Iterator<Integer>> iteratorStack = new Stack<Iterator<Integer>>();
	private Integer top = null;

	public DeepIterator_Integer(Iterable<Integer> iterable) {
	    this.iteratorStack.push(iterable.iterator());
	}

	/*
	 * If top !=null just return true. At the beginning, right after
	 * construction, top is null. In this case try looking for the next
	 * Integer. If after the while loop still not found one, return false
	 */
	@Override
	public boolean hasNext() {
	    if (this.top != null)
		return true;

	    while (!this.iteratorStack.isEmpty()) {
		Iterator<Integer> tmpIterator = this.iteratorStack.peek();

		if (tmpIterator.hasNext()) {
		    Object tmp = tmpIterator.next();
		    if (tmp instanceof Integer) {
			this.top = (Integer) tmp;
			return true;
		    } else if (tmp instanceof Iterable) {
			this.iteratorStack.push(((Iterable<Integer>) tmp).iterator());
		    } else {
			throw new RuntimeException("Unsupported data type. ");
		    }
		} else {
		    this.iteratorStack.pop();
		}
	    }
	    return false;
	}

	@Override
	public Integer next() throws NoSuchElementException {
	    if (hasNext()) {
		Integer tmp = this.top;
		this.top = null;
		return tmp;
	    }

	    throw new NoSuchElementException();
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException("This is not supported right now.");
	}
    }

    /*
     * Second Implementation. Generic class for more general types.
     * 
     * The name of the class must have a <T> in the end:
     * 
     * Wrong: DeepIterator_Generic implements Iterator<T> {...}
     * 
     * In Java there is no way to find out the runtime type of generic type
     * parameters. So need an additional "type" field in to help identify.
     */
    public class DeepIterator_Generic<T> implements Iterator<T> {
	final Class<T> type;
	private Stack<Iterator<T>> iteratorStack = new Stack<Iterator<T>>();
	private T top = null;

	public DeepIterator_Generic(Iterable<T> iterable, Class<T> _type) {
	    this.iteratorStack.push(iterable.iterator());
	    type = _type;
	}

	@Override
	public boolean hasNext() {
	    if (this.top != null)
		return true;

	    while (!this.iteratorStack.isEmpty()) {
		Iterator<T> tmpIterator = this.iteratorStack.peek();

		if (tmpIterator.hasNext()) {
		    Object tmp = tmpIterator.next();
		    // if (tmp instanceof T) // wrong. Cannot apply instanceof
		    // for generic type T.
		    if (type.isInstance(tmp)) {
			this.top = (T) tmp;
			return true;
		    } else if (tmp instanceof Iterable) {
			this.iteratorStack.push(((Iterable<T>) tmp).iterator());
		    } else {
			throw new RuntimeException("Unsupported data type. ");
		    }
		} else {
		    this.iteratorStack.pop();
		}
	    }
	    return false;
	}

	@Override
	public T next() throws NoSuchElementException {
	    if (hasNext()) {
		T tmp = this.top;
		this.top = null;
		return tmp;
	    }

	    throw new NoSuchElementException();
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException("This is not supported right now.");
	}
    }

    /*
     * Not a good solution. Cannot support more then two level nested collectors
     */
    public class ListsIterator<T> implements Iterator<T> {
	private Iterator<List<T>> listsItr;
	private Iterator<T> curListItr;

	/*
	 * Advance to the next List Iterator: let curListItr to be the iterator
	 * of the next list in the list of lists
	 */
	private void advance() {
	    curListItr = null;

	    /*
	     * find the next non-null list, and assign its iterator to
	     * curListItr. So, if in this case curListItr is still null, then
	     * indeed there ListsIterator has no more item available
	     */
	    while (listsItr != null && listsItr.hasNext()) {
		List<T> list = listsItr.next();
		if (list != null && !list.isEmpty()) {
		    curListItr = list.iterator();
		    return;
		}
	    }
	}

	public ListsIterator(List<List<T>> lists) {
	    if (lists != null) {
		listsItr = lists.iterator();
		advance();
	    }
	}

	@Override
	public boolean hasNext() {
	    return curListItr != null;
	}

	@Override
	public T next() {
	    if (curListItr == null) {
		return null;
	    }
	    T res = curListItr.next();

	    if (!curListItr.hasNext()) {
		advance();
	    }

	    return res;
	}

	@Override
	public void remove() {
	    if (curListItr == null) {
		throw new IllegalStateException();
	    }
	    curListItr.remove();
	    if (!curListItr.hasNext()) {
		advance();
	    }
	}
    }
}
