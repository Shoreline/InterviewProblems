package airbnb;

import java.util.*;
import java.lang.reflect.ParameterizedType;

/**
 * ArrayList／锯齿数组的iterator 删除－O 给一个2d array，要求写一个顺序访问这个2d
 * array的Iterator，包括hasNext()与next()。注意2d
 * array的每行中元素的个数可能不一样，也可能为空。followup是写一个remove()，注意是remove当前item，不是下一个item。
 * remove是需要同时删除原来数组里的元素，也能在Iterator调用时体现 出来。
 */
public class TwoDArrayListIterator {

    class My2DArr<T> {
	List<List<T>> data;

	public Iterator iterator() {
	    return null;
	    // return new My2DArrItr(data,
	    // (Class<T>) ((ParameterizedType)
	    // getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
    }

    class My2DArrItr<T> implements Iterator<T> {
	T cur;
	T next;
	Stack<Iterator<T>> itrStack;

	public My2DArrItr(Iterable<T> iterable) {
	    itrStack.push(iterable.iterator());
	}

	@Override
	public boolean hasNext() {
	    if (next != null) {
		return true;
	    }

	    while (!itrStack.isEmpty()) {
		Iterator<T> curItr = itrStack.peek();
		if (curItr.hasNext()) {
		    Object item = curItr.next();
		    if (item instanceof Iterable) {
			itrStack.push(((Iterable<T>) item).iterator());
		    } else {
			try {
			    next = (T) item;
			} catch (Exception e) {
			    throw e;
			}
		    }
		} else {
		    itrStack.pop();
		}
	    }

	    return false;
	}

	@Override
	public T next() {
	    if (hasNext()) {
		T res = next;
		next = null;
		return res;
	    }

	    throw new NoSuchElementException();
	}

	@Override
	public void remove() {
	    itrStack.peek().remove();
	}

    }

    public class Array2D<T> {
	ArrayList<ArrayList<T>> array;

	public Array2D() {
	    array = new ArrayList<ArrayList<T>>();
	}

	public void addLine(ArrayList<T> nums) {
	    array.add(new ArrayList(nums));
	}

	public T get(int x, int y) {
	    if (x >= array.size())
		return null;
	    ArrayList<T> l = array.get(x);
	    if (l == null || y >= l.size())
		return null;
	    return l.get(y);
	}

	public Iterator iterator() {
	    return new a2Iterator();
	}

	private class a2Iterator implements Iterator<T> {
	    int r;
	    int c;
	    ArrayList<T> curArray;

	    public a2Iterator() {
		r = 0;
		c = 0;
	    }

	    @Override
	    public boolean hasNext() {
		if (curArray == null && array.size() == 0) {
		    return false;
		} else if (r >= array.size())
		    return false;
		return true;
	    }

	    @Override
	    public T next() {
		if (c == 0)
		    curArray = array.get(r);
		T ret = curArray.get(c);
		if (curArray.size() - 1 == c) {
		    r++;
		    c = 0;
		} else
		    c++;
		return ret;
	    }

	    @Override
	    public void remove() {
		ArrayList pre = curArray;
		int x = c;
		int y = r;
		if (x == 0) {
		    y--;
		    pre = array.get(y);
		    x = pre.size();
		}
		x--;
		pre.remove(x);
		if (pre.size() == 0) {
		    array.remove(y);
		    r--;
		}
		if (c != 0)
		    c--;
	    }
	}
    }

    public static void main(String[] args) {
	// test t = new test();
	// Array2D<Integer> ad = t.new Array2D<Integer>();
	// for(int i = 1 ; i < 3; i++){
	// ArrayList<Integer> a = new ArrayList<Integer>();
	// for(int j = 2; j < 4; j++){
	// a.add(i*j);
	// System.out.println(i* j);
	// }
	// ad.addLine(a);
	// }
	// for(Iterator<Integer> i = ad.iterator(); i.hasNext();){
	// Integer num = i.next();
	// System.out.print(num + " ");
	// if (num == 3)
	// i.remove();
	// }
	// System.out.println();
	// for(Iterator i = ad.iterator(); i.hasNext();){
	// System.out.print(i.next() + " ");
	// }
    }

}
