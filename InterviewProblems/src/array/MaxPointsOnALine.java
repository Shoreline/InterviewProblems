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
 * *Note: 
 * 1) handle vertical lines (slope is infinite) 
 * 2) duplicated points
 */
public class MaxPointsOnALine {
    public class Solution {
	public int maxPoints(Point[] points) {
	    if (points == null || points.length == 0) {
		return 0;
	    }

	    int max = 0;
	    for (int i = 0; i < points.length; i++) {
		Point p = points[i];
		Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
		int duplicates = 0;

		for (int j = 0; j < points.length; j++) {
		    Point cur = points[j];
		    Double slope = 0.0;

		    if (cur.x == p.x && cur.y == p.y) {
			duplicates++;
			continue;
		    } else if (cur.x - p.x == 0) {
			slope = Double.MAX_VALUE;
		    } else {
			slope = (1.0 * cur.y - p.y) / (cur.x - p.x);
		    }

		    if (!slopeMap.containsKey(slope)) {
			slopeMap.put(slope, 0);
		    }

		    slopeMap.put(slope, slopeMap.get(slope) + 1);
		}

		max = Math.max(max, duplicates); // easy to forget! slopeMap may be empty
		for (int num : slopeMap.values()) {
		    max = Math.max(max, num + duplicates);
		}

		slopeMap.clear();
	    }

	    return max;
	}
    }
}
