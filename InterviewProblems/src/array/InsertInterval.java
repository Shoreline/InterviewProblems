package array;

import java.util.ArrayList;

public class InsertInterval {
    /**
     * Insert Interval
     * 
     * Given a set of non-overlapping intervals, insert a new interval into the
     * intervals (merge if necessary).
     * 
     * You may assume that the intervals were initially sorted according to
     * their start times.
     * 
     * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
     * [1,5],[6,9].
     * 
     * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
     * in as [1,2],[3,10],[12,16].
     * 
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */

    /*
     * Difficult to write bug free code. Lots of detail.
     * 
     * use high hand's solution
     */

    public static class Interval {
	int start;
	int end;

	public Interval() {
	    start = 0;
	    end = 0;
	}

	public Interval(int s, int e) {
	    start = s;
	    end = e;
	}

	public void print() {
	    System.out.println(this.start + ", " + this.end);
	}
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
	    Interval newInterval) {
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
		newInterval.start = Math.min(curInterval.start,
			newInterval.start);
		insertStart = true;
		while (i < intervals.size()
			&& intervals.get(i).start <= newInterval.end) {
		    newInterval.end = Math.max(newInterval.end,
			    intervals.get(i).end);
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
