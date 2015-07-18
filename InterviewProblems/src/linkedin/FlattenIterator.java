package linkedin;

import java.util.Iterator;
import java.util.Vector;

public class FlattenIterator {
    class flat implements Iterator<Integer> {
	Iterator<Vector<Integer>> it1 = null;
	Iterator<Integer> it2 = null;

	void Getit2() {
	    it2 = null;

	    if (it1 != null) {
		while (it1.hasNext()) {
		    Vector<Integer> v = it1.next();
		    if (v != null && v.size() != 0) {
			it2 = v.iterator();
			return;
		    }
		}
	    }
	}

	public flat(Vector<Vector<Integer>> a) {
	    if (a != null) {
		it1 = a.iterator();
		Getit2();
	    }
	}

	@Override
	public boolean hasNext() {
	    return it2 != null;
	}

	@Override
	public Integer next() {
	    if (it2 == null)
		return null;

	    int m = it2.next();

	    if (!it2.hasNext())
		Getit2();

	    return m;
	}
	// @Override
	// public void remove() {
	// // TODO Auto-generated method stub
	//
	// }

    }

    public static Iterator<String> flatten(final Iterator<Iterator<String>> iters) {
	return new Iterator<String>() {
	    private Iterator<String> curIter = null;
	    private String nextItem = advanceItem();

	    private String advanceItem() {
		if (iters == null && curIter == null)
		    throw new NullPointerException();

		while ((iters != null && iters.hasNext()) || (curIter != null && curIter.hasNext())) {
		    if ((curIter == null || !curIter.hasNext()))
			if (iters != null && iters.hasNext())
			    curIter = iters.next();

		    if (curIter == null)
			continue;

		    while (curIter.hasNext()) {
			String result = curIter.next();
			if (result != null)
			    return result;
		    }
		}

		return null;
	    }

	    public boolean hasNext() {
		return nextItem != null;
	    }

	    public String next() {
		if (!hasNext())
		    throw new NullPointerException();

		String oldItem = nextItem;
		nextItem = advanceItem();
		return oldItem;
	    }

	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	};
    }

}
