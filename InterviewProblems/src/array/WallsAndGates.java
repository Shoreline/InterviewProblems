package array;

import java.util.*;

/**
 * Walls and Gates
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 
 * 0 - A gate.
 * 
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 * represent INF as you may assume that the distance to a gate is less than
 * 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid:
 * 
 * INF -1 0 INF
 * 
 * INF INF INF -1
 * 
 * INF -1 INF -1
 * 
 * 0 -1 INF INF
 * 
 * After running your function, the 2D grid should be:
 * 
 * 3 -1 0 1
 * 
 * 2 2 1 -1
 * 
 * 1 -1 2 -1
 * 
 * 0 -1 3 4
 * 
 */

/*
 * use rooms[i + 1][j] > step as an additional stopping condition: can avoid
 * using a "visited" set
 */
public class WallsAndGates {
    public class Solution {
	public void wallsAndGates(int[][] rooms) {
	    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
		return;
	    }
	    int m = rooms.length;
	    int n = rooms[0].length;
	    List<Integer> gates = new ArrayList<>();
	    for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
		    if (rooms[i][j] == 0) {
			gates.add(i * n + j);
		    }
		}
	    }

	    for (int gate : gates) {
		Queue<Integer> q = new LinkedList<>();
		q.add(gate);
		int step = 1;
		while (!q.isEmpty()) {
		    int count = q.size();
		    for (int c = 0; c < count; c++) {
			int pos = q.poll();
			int i = pos / n;
			int j = pos % n;

			if (i + 1 < m && rooms[i + 1][j] > step) {
			    rooms[i + 1][j] = step;
			    q.add((i + 1) * n + j);
			}
			if (i - 1 >= 0 && rooms[i - 1][j] > step) {
			    rooms[i - 1][j] = step;
			    q.add((i - 1) * n + j);
			}
			if (j + 1 < n && rooms[i][j + 1] > step) {
			    rooms[i][j + 1] = step;
			    q.add(i * n + j + 1);
			}
			if (j - 1 >= 0 && rooms[i][j - 1] > step) {
			    rooms[i][j - 1] = step;
			    q.add(i * n + j - 1);
			}
		    }
		    step++;
		}
	    }
	}
    }
}
