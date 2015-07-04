package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 */

/*
 * Customize a comparator for Interval class, then sort intervals by their start
 */
public class MergeIntervals {
    /*
     * Using pre is helpful
     */
    public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> res = new ArrayList<>();
	    if (intervals == null || intervals.size() == 0) {
		return res;
	    }

	    Collections.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval i1, Interval i2) {
		    if (i1.start != i2.start) {
			return i1.start - i2.start;
		    } else {
			return i1.end - i2.end;
		    }
		}
	    });

	    Interval pre = intervals.get(0);
	    for (int i = 1; i < intervals.size(); i++) {
		Interval cur = intervals.get(i);
		if (cur.start <= pre.end) {
		    pre.end = Math.max(pre.end, cur.end);
		} else {
		    res.add(pre);
		    pre = cur;
		}
	    }
	    res.add(pre);

	    return res;
	}
    }
    /*
     * Notice the different ways of implementing the Interval comparator
     */
    public class Solution2 {
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> res = new ArrayList<Interval>();

	    if (intervals == null || intervals.size() == 0) {
		return res;
	    }

	    Comparator<Interval> comp = new Comparator<Interval>() {
		// have to add 'public' explicitly
		public int compare(Interval i1, Interval i2) {
		    if (i1.start != i2.start) {
			return i1.start - i2.start;
		    } else {
			return i1.end - i2.end;
		    }
		}
	    };

	    Collections.sort(intervals, comp); // use comp

	    /*
	     * this method is WRONG. Remember a merged interval may be eligible
	     * to merge another interval
	     */
//	    for (int i = 0; i < intervals.size(); i++) {
//		if (i == intervals.size() - 1) {
//		    res.add(intervals.get(i));
//		    break;
//		}
//		Interval i1 = intervals.get(i);
//		Interval i2 = intervals.get(i + 1);
//		if (i1.end >= i2.start) {		   
//		    res.add(new Interval(i1.start, Math.max(i1.end,i2.end)));
//		    i++;
//		} else {
//		    res.add(i1);
//		}
//	    }

	    res.add(intervals.get(0));
	    for (int i = 1; i < intervals.size(); i++) {
		Interval i1 = res.get(res.size() - 1);
		Interval i2 = intervals.get(i);
		if (i1.end >= i2.start) {
		    i1.end = Math.max(i1.end, i2.end);
		} else {
		    res.add(i2);
		}
	    }

	    return res;
	}
    }  
}
