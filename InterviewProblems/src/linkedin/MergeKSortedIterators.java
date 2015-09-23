package linkedin;

import java.util.*;

/**
 * 
 *
 */

/*
 * iterator直接比的话，比较一次之后next的值就丢失了。 可以创建一个新的数据结构 ， 包含iterator和当前的值。
 * 
 * public class IterWrapper{ int currentVal; Iterator<Integer> iter; }
 * 
 * Comparator比较currentVal的大小。初始化的时候对每个iterator取next，然后放进 priorityQueue或者heap。
 * 每次IterWrapper被poll之后，更新currentVal的值再放回去就好了。
 */
public class MergeKSortedIterators {
    class Method {
	class ItrWrapper {
	    Integer curVal;
	    Iterator<Integer> itr;

	    public ItrWrapper(Iterator<Integer> _itr) {
		itr = _itr;
		curVal = itr.next();
	    }

	    public Integer getVal() {
		Integer res = curVal;
		curVal = itr.next();
		return res;
	    }
	}

	public Iterable<Integer> mergeKSortedIterators(Iterator<Integer>[] iters) {
	    List<Integer> res = new ArrayList<>();
	    PriorityQueue<ItrWrapper> minHeap = new PriorityQueue<>(iters.length, new Comparator<ItrWrapper>() {
		@Override
		public int compare(ItrWrapper w1, ItrWrapper w2) {
		    return w1.curVal - w2.curVal;
		}
	    });

	    for (Iterator<Integer> itr : iters) {
		ItrWrapper w = new ItrWrapper(itr);
		if (w.curVal != null) {
		    minHeap.add(w);
		}
	    }

	    while (!minHeap.isEmpty()) {
		ItrWrapper w = minHeap.poll();
		res.add(w.getVal());
		if (w.curVal != null) {
		    minHeap.add(w);
		}
	    }

	    return res;
	}
    }

    class Method_Generic {
	class ItrWrapper<T> {
	    T curVal;
	    Iterator<T> itr;

	    public ItrWrapper(Iterator<T> _itr) {
		itr = _itr;
		curVal = itr.next();
	    }

	    public T getVal() {
		T res = curVal;
		curVal = itr.next();
		return res;
	    }
	}

	public Iterable<Integer> mergeKSortedIterators(Iterator[] iters) {
	    List<Integer> res = new ArrayList<>();
	    PriorityQueue<ItrWrapper<Integer>> minHeap = new PriorityQueue<>(iters.length,
		    new Comparator<ItrWrapper<Integer>>() {
			@Override
			public int compare(ItrWrapper<Integer> w1, ItrWrapper<Integer> w2) {
			    return w1.curVal - w2.curVal;
			}
		    });

	    for (Iterator itr : iters) {
		itr = (Iterator<Integer>) itr;
		ItrWrapper<Integer> w = new ItrWrapper<Integer>(itr);
		if (w.curVal != null) {
		    minHeap.add(w);
		}
	    }

	    while (!minHeap.isEmpty()) {
		ItrWrapper<Integer> w = minHeap.poll();
		res.add(w.getVal());
		if (w.curVal != null) {
		    minHeap.add(w);
		}
	    }

	    return res;
	}
    }

    class Method2 {
	public Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> Iters) {

	    Queue<NewIter> minHeap = new PriorityQueue<NewIter>();
	    List<Integer> result = new ArrayList<Integer>();
	    for (Iterator<Integer> iter : Iters) {
		if (iter.hasNext()) {
		    minHeap.add(new NewIter(iter.next(), iter));
		}
	    }

	    while (!minHeap.isEmpty()) {
		NewIter newiter = minHeap.poll();
		result.add(newiter.getValue());
		if (newiter.hasNext()) {
		    minHeap.add(newiter);
		}
	    }
	    return result;
	}

	private class NewIter implements Comparable<NewIter> {
	    private Integer value;
	    private Iterator<Integer> iter;

	    public NewIter(Integer val, Iterator<Integer> it) {
		this.value = val;
		this.iter = it;
	    }

	    public Integer getValue() {
		return this.value;
	    }

	    public boolean hasNext() {
		if (iter.hasNext()) {
		    value = iter.next();
		    return true;
		}
		return false;
	    }

	    public int compareTo(NewIter a) {
		return this.value - a.value;
	    }
	}
    }
}
