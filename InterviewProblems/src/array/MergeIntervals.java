package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import array.InsertInterval.Interval;

public class MergeIntervals {
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
     * Sort intervals by their start
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	ArrayList<Interval> result = new ArrayList<Interval>();
	if (intervals == null || intervals.isEmpty())
	    return result;

	/*
	 * *Important* how to write a correct comparator!
	 * 
	 * The new comparator is directly implemented within the argument
	 * parenthesis of Collections.sort()
	 */
	Collections.sort(intervals, new Comparator<Interval>() {
	    @Override
	    public int compare(Interval o1, Interval o2) {
		return (o1.start - o2.start);
	    }
	});

	Interval pre = intervals.get(0);
	for (int i = 1; i < intervals.size(); i++) {
	    Interval cur = intervals.get(i);

	    /*
	     * the if block can be replaced by a while loop
	     */
	    if (pre.end >= cur.start) {
		pre.end = Math.max(pre.end, cur.end);
		continue;
	    }

	    result.add(pre);
	    pre = cur;
	}
	result.add(pre);

	return result;

    }
}
