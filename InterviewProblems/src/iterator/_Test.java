package iterator;

import java.util.*;

import iterator.ZigzagIteratorImp.ZigzagIterator;

public class _Test {

    public static void main(String[] args) {

	List<Integer> l1 = Arrays.asList(new Integer[] { 1, 2 });
	List<Integer> l2 = Arrays.asList(new Integer[] { 3, 4, 5, 6 });

	ZigzagIterator zi = new ZigzagIteratorImp().new ZigzagIterator(l1, l2);

	while (zi.hasNext()) {
	    System.out.println(zi.next());
	}
    }

}
