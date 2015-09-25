package array;

import java.util.*;

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
