package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1: 
 * 11110
 * 11010
 * 11000
 * 00000 
 * Answer: 1
 * 
 * Example 2: 
 * 11000
 * 11000 
 * 00100 
 * 00011 
 * Answer: 3
 *
 */
/*
 * DFS can pass ac. But similar to Surrounded regions, better use BFS.
 */
public class NumberOfIslands {
    public class Solution {
	public int numIslands(char[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0) {
		return 0;
	    }

	    int res = 0;
	    for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
		    if (grid[i][j] == '1') {
			res++;
			bfs(grid, i, j);
		    }
		}
	    }

	    return res;
	}

	private void bfs(char[][] grid, int i, int j) {
	    int m = grid.length;
	    int n = grid[0].length;
	    Queue<Integer> q = new LinkedList<>();
	    q.add(i * n + j);
	    grid[i][j] = '0';

	    while (!q.isEmpty()) {
		int pos = q.poll();
		int x = pos / n;
		int y = pos % n;

		if (x + 1 < m && grid[x + 1][y] == '1') {
		    grid[x + 1][y] = '0';
		    q.add(pos + n);
		}
		if (x - 1 >= 0 && grid[x - 1][y] == '1') {
		    grid[x - 1][y] = '0';
		    q.add(pos - n);
		}
		if (y + 1 < n && grid[x][y + 1] == '1') {
		    grid[x][y + 1] = '0';
		    q.add(pos + 1);
		}
		if (y - 1 >= 0 && grid[x][y - 1] == '1') {
		    grid[x][y - 1] = '0';
		    q.add(pos - 1);
		}
	    }

	}
    }
    
    /*
     * DFS
     * 
     * Once see '1', count++ and mark all adjacent blocks to '0' (avoid repeated
     * count of the same island in future)
     */
    public class Solution_DFS {
	public int numIslands(char[][] grid) {
	    if (grid == null || grid.length == 0) {
		return 0;
	    }

	    int res = 0;
	    for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
		    if (grid[i][j] == '1') {
			res++;
			mark(grid, i, j);
		    }
		}
	    }
	    return res;
	}

	// DFS: mark adjacent '1's 
	private void mark(char[][] grid, int i, int j) {
	    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
		return;
	    }

	    if (grid[i][j] != '1') {
		return;
	    }

	    grid[i][j] = '0';
	    mark(grid, i + 1, j);
	    mark(grid, i - 1, j);
	    mark(grid, i, j + 1);
	    mark(grid, i, j - 1);
	}
    }
}
