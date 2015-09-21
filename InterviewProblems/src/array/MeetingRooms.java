package array;

import java.util.*;

/**
 * Meeting Rooms
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

/*
 * sort intervals and check if there is any overlap
 */
public class MeetingRooms {
    public class Solution {
	public boolean canAttendMeetings(Interval[] intervals) {
	    if (intervals == null || intervals.length < 2) {
		return true;
	    }

	    Arrays.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval i1, Interval i2) {
		    if (i1.start != i2.start) {
			return i1.start - i2.start;
		    } else
			return i1.end - i2.start;
		}
	    });

	    for (int i = 1; i < intervals.length; i++) {
		if (intervals[i - 1].end > intervals[i].start) {
		    return false;
		}
	    }

	    return true;
	}
    }

    /*
     * O(N). Assume the smallest time unit is minute
     */
    class Answer2 {
	public boolean isOverlap(Interval[] meetings) {
	    int slots = 24 * 60;
	    BitSet ret = new BitSet(slots);
	    for (Interval meeting : meetings) {
		BitSet bitSet = new BitSet(slots);
		bitSet.set(meeting.start, meeting.end + 1);
		if (ret.intersects(bitSet))
		    return true;
		ret.or(bitSet);
	    }
	    return false;
	}
    }
}
