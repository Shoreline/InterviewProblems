package array;

import java.util.*;

/**
 * The Skyline Problem
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are given
 * the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings
 * collectively (Figure B).
 * 
 * Buildings Skyline Contour The geometric information of each building is
 * represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
 * coordinates of the left and right edge of the ith building, respectively, and
 * Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤
 * INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000]. The input list is already sorted in ascending order by the left x
 * position Li. The output list must be sorted by the x position. There must be
 * no consecutive horizontal lines of equal height in the output skyline. For
 * instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the
 * three lines of height 5 should be merged into one in the final output as
 * such: [...[2 3], [4 5], [12 7], ...]
 *
 */
/*
 * http://www.cnblogs.com/easonliu/p/4531020.html
 */
public class SkylineProblem {
    
    public class Solution {
	class Point {
	    int x;
	    int y;
	    boolean isLeft;

	    public Point(int _x, int _y, boolean _isLeft) {
		x = _x;
		y = _y;
		isLeft = _isLeft;
	    }
	}

	public List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> res = new ArrayList<>();
	    if (buildings == null || buildings.length == 0) {
		return res;
	    }

	    List<Point> points = new ArrayList<>();

	    for (int[] building : buildings) {
		Point p1 = new Point(building[0], building[2], true);
		Point p2 = new Point(building[1], building[2], false);

		points.add(p2);
		points.add(p1);
	    }

	    Collections.sort(points, new Comparator<Point>() {
		@Override
		public int compare(Point p1, Point p2) {
		    if (p1.x != p2.x) {
			return p1.x - p2.x;
		    } else if (p1.isLeft && p2.isLeft) {
			return -(p1.y - p2.y);
		    } else if (!p1.isLeft && !p2.isLeft) {
			return p1.y - p2.y;
		    } else {
			return p1.isLeft ? -1 : 1;
		    }
		}
	    });

	    TreeMap<Integer, Integer> heightMap = new TreeMap<>();
	    heightMap.put(0, 1);

	    int preH = -1;
	    int curH = -1;

	    for (Point p : points) {
		if (p.isLeft) {
		    if (!heightMap.containsKey(p.y)) {
			heightMap.put(p.y, 0);
		    }
		    heightMap.put(p.y, heightMap.get(p.y) + 1);
		} else {
		    heightMap.put(p.y, heightMap.get(p.y) - 1);
		    if (heightMap.get(p.y) == 0) {
			heightMap.remove(p.y);
		    }
		}

		curH = heightMap.lastKey();
		if (curH != preH) {
		    res.add(new int[] { p.x, curH });
		    preH = curH;
		}
	    }

	    return res;
	}
    }

    public class WrongAttempt {
	public List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> res = new ArrayList<>();
	    if (buildings == null || buildings.length == 0) {
		return res;
	    }

	    HashSet<int[]> points = new HashSet<>(); // need to implement some
						     // custom comparator
	    for (int[] building : buildings) {
		points.add(new int[] { building[0], -building[2] });
		points.add(new int[] { building[1], building[2] });
	    }

	    TreeMap<Integer, Integer> heightMap = new TreeMap<>();
	    heightMap.put(0, 1);

	    int preH = -1;
	    int curH = -1;

	    for (int[] p : points) {
		if (p[1] < 0) {
		    if (!heightMap.containsKey(-p[1])) {
			heightMap.put(-p[1], 0);
		    }
		    heightMap.put(-p[1], heightMap.get(-p[1]) + 1);
		} else {
		    heightMap.put(p[1], heightMap.get(p[1]) - 1);
		    if (heightMap.get(p[1]) == 0) {
			heightMap.remove(p[1]);
		    }
		}

		curH = heightMap.lastKey();
		if (curH != preH) {
		    res.add(new int[] { p[0], curH });
		    preH = curH;
		}
	    }

	    return res;
	}
    }

}
