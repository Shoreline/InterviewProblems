package linkedin;

import java.util.Iterator;
import java.util.List;

/*
 * my solution after reviewing others' code
 *  
 */
public class DeepIteratorII {
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
