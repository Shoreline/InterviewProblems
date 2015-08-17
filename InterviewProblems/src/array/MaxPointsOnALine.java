package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Points on a Line
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 *
 */

/*
 * The idea is to compute and compare the slopes.
 * 
 * For a straight line that passes Pi, Pj: slope = (yi-yj)/(xi-xj)
 * 
 * For each point Pi, compute all slopes for Pj -> O(N^2) time complexity
 * 
 * There are just N^2 different straight lines.
 * 
 * *Note: 1) handle horizontal lines (slope is infinite) 2) duplicated points;
 * 3) convert int to double while computing slope
 */
public class MaxPointsOnALine {
    public class Solution {
	public int maxPoints(Point[] points) {
	    if (points == null || points.length == 0) {
		return 0;
	    }

	    int res = 0;
	    for (int i = 0; i < points.length; i++) {
		Map<Double, Integer> slopeCount = new HashMap<>();
		int duplicates = 0; // #points have same location as points[i]
		int h = 0; // horizontal lines

		for (int j = 0; j < points.length; j++) {
		    Point p1 = points[i];
		    Point p2 = points[j];
		    if (p1.x == p2.x && p1.y == p2.y) {
			duplicates++;
		    } else if (p1.y == p2.y) {
			h++;
		    } else {
			double slope = ((double) p1.x - p2.x) / (p1.y - p2.y); // double!
			if (!slopeCount.containsKey(slope)) {
			    slopeCount.put(slope, 0);
			}
			slopeCount.put(slope, slopeCount.get(slope) + 1);
		    }
		}

		res = Math.max(res, h + duplicates);
		for (double slope : slopeCount.keySet()) {
		    res = Math.max(res, slopeCount.get(slope) + duplicates);
		}
	    }

	    return res;
	}
    }
}
