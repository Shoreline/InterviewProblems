package array;

import java.util.*;

/**
 * Best Meeting Point
 * 
 * A group of two or more people wants to meet and minimize the total travel
 * distance. You are given a 2D grid of values 0 or 1, where each 1 marks the
 * home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 
 * 1 - 0 - 0 - 0 - 1
 * 
 * |   |   |   |   |
 * 
 * 0 - 0 - 0 - 0 - 0
 * 
 * |   |   |   |   |
 * 
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (0,2) is an ideal meeting point, as the total travel distance of
 * 2+2+2=6 is minimal. So return 6.
 * 
 * Hint:
 * 
 * Try to solve it in one dimension first. How can this solution apply to the
 * two dimension case?
 *
 */
/*
 * Either 1) find the median number of all Xs and Ys; If use quick select to
 * find the median, worst case O(N^2), but avg O(N)
 * 
 * or 2) use below trick:
 * 
 * a . . . b . . . c . d
 * 
 * no matter where this meeting point is, it must be between a and d. So the
 * total distances from a, b to this point is always (d - a). Same for b and c.
 * So we just need to sort the coordinates on an axis then use two pointers to
 * do subtraction
 *
 */
public class BestMeetingPoint {
    public class Solution {
	public int minTotalDistance(int[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0) {
		return 0;
	    }

	    List<Integer> x = new ArrayList<>();
	    List<Integer> y = new ArrayList<>();

	    for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
		    if (grid[i][j] == 1) {
			x.add(i);
			y.add(j);
		    }
		}
	    }

	    return getDist(x) + getDist(y);
	}

	private int getDist(List<Integer> nums) {
	    int res = 0;
	    Collections.sort(nums);
	    int i = 0;
	    int j = nums.size() - 1;
	    while (i < j) {
		res += (nums.get(j) - nums.get(i));
		i++;
		j--;
	    }
	    return res;
	}
    }
}
