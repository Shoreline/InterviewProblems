package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {
    /*
     * a much simpler O(N) solution
     * 
     * If there is any overlap between newInterval and curInterval, let the
     * newInterval absorb curInterval, until it is safe to insert
     */
    public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

	    List<Interval> res = new ArrayList<>();
	    boolean inserted = false;

	    for (Interval cur : intervals) {
		if (inserted || cur.end < newInterval.start) {
		    res.add(cur);
		} else if (newInterval.end < cur.start) {
		    res.add(newInterval);
		    res.add(cur); // easy to forget!
		    inserted = true;
		} else {
		    newInterval.start = Math.min(cur.start, newInterval.start);
		    newInterval.end = Math.max(cur.end, newInterval.end);
		}
	    }

	    if (!inserted) {
		res.add(newInterval);
	    }

	    return res;
	}
    }

    /*
     * Same algorithm as the 2013 solution
     */
    public class Solution2 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> res = new ArrayList<Interval>();
	    if (intervals == null || intervals.size() == 0 || newInterval == null) {
		res.add(newInterval);
		return res;
	    }

	    if (newInterval.end < intervals.get(0).start) {
		res.add(newInterval);
		res.addAll(intervals);
		return res;
	    } else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
		res.addAll(intervals);
		res.add(newInterval);
		return res;
	    }

	    int i = 0;
	    boolean hasInserted = false;
	    while (i < intervals.size()) {
		Interval cur = intervals.get(i);

		if (!hasInserted && cur.end >= newInterval.start) {
		    newInterval.start = Math.min(newInterval.start, cur.start);

		    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		    }

		    res.add(newInterval);
		    hasInserted = true;
		} else {
		    res.add(cur);
		    i++;
		}
	    }

	    return res;
	}
    }

    class Solution_2013 {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> result = new ArrayList<Interval>();

	    if (intervals == null || intervals.isEmpty()) {
		if (newInterval == null)
		    return result;
		result.add(newInterval);
		return result;
	    }

	    /*
	     * handle two boundary conditions separately:
	     * 
	     * 1. if the new interval is ahead of all intervals in array
	     * 
	     * 2. if the new interval is behind all intervals in array
	     */
	    if (newInterval.end < intervals.get(0).start) {
		result.add(newInterval);
		result.addAll(intervals);
		return result;
	    } else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
		result.addAll(intervals);
		result.add(newInterval);
		return result;
	    }

	    boolean insertStart = false;
	    int i = 0;

	    /*
	     * two nested while loops.
	     * 
	     * Create a newInterval and keep updating its end
	     */
	    while (i < intervals.size()) {
		Interval curInterval = intervals.get(i);
		if (!insertStart && curInterval.end >= newInterval.start) {
		    newInterval.start = Math.min(curInterval.start, newInterval.start);
		    insertStart = true;
		    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		    }
		    result.add(newInterval);
		    continue;
		}
		i++;
		result.add(curInterval);
	    }

	    return result;
	}
    }
}
