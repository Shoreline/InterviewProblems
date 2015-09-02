package array;

import java.util.*;

/**
 * 
 * Meeting Rooms II
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 *
 */
public class MeetingRoomesII {
    public class Solution {
	/*
	 * My thought. Time: O(2Nlog2N); Sapce: O(2N) Put all start and (-1)*end
	 * time in an array, and sort it as:
	 * 
	 * [0, 5, -10, 15, -20, -30]
	 * 
	 * then scan this array, curNeededRooms++ if sees an >=0 number,
	 * otherwise --. Then record the maximal needed room number
	 */
	public int minMeetingRooms(Interval[] intervals) {
	    if (intervals == null || intervals.length == 0) {
		return 0;
	    }

	    Integer[] times = new Integer[intervals.length * 2];
	    int i = 0;
	    for (Interval interval : intervals) {
		times[i++] = interval.start;
		times[i++] = -1 * interval.end;
	    }

	    Arrays.sort(times, new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
		    if (Math.abs(i1) != Math.abs(i2)) {
			return Math.abs(i1) - Math.abs(i2);
		    } else {
			return i1 - i2;
		    }
		}
	    });

	    int needed = 0;
	    int max = 0;
	    for (int k = 0; k < times.length; k++) {
		needed = times[k] >= 0 ? needed + 1 : needed - 1;
		max = Math.max(max, needed);
	    }

	    return max;
	}
    }

}
