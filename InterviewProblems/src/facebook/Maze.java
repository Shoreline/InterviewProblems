package facebook;

import java.util.*;
// 给一个n * n的二维数组，例如：
// [[0, 1, 0]]
// [[0, 2, 0]]
// [[0, 1, 0]]

// 2是一面墙，表示此路不通。
// 0表示小孩儿。
// 1表示警察叔叔。
// 求小孩儿到离他最近的那个警察叔叔的距离。
// 如果最终小孩儿碰不到警察叔叔，则距离为-1。
// 注：墙到警察叔叔的距离无论如何都是-1，警察叔叔到自己的距离是0。

// Running case 1:
// [[0, 1, 0]]
// [[0, 2, 0]]
// [[0, 1, 0]]
// Result:
// [[1, 0, 1]]
// [[2, -1, 2]]
// [[1, 0, 1]]

// Running case 2:
// [[0, 2, 0]]
// [[0, 2, 0]]
// [[0, 2, 1]]
// Result:
// [[-1, -1, 2]]
// [[-1, -1, 1]]
// [[-1, -1, 0]]

// Running case 3:
// [[1, 0, 0]]
// [[0, 0, 0]]
// [[0, 0, 1]]
// Result:
// [[0, 1, 2]]
// [[1, 2, 1]]
// [[2, 1, 0]]

public class Maze {
    class Method_1 {
	public class Position {
	    public int x;
	    public int y;

	    public Position(int x, int y) {
		this.x = x;
		this.y = y;
	    }
	}

	public int[][] minDistance(int[][] input) {
	    // queue of cops
	    Queue<Position> queue = new LinkedList<>();
	    int m = input.length;
	    int n = input[0].length;

	    for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
		    
		}
	    }

	    return null;
	}

	private void updateDistance(int[][] input, int[][] res) {

	}
    }

    class Method_2 {
	public int[][] solution(int[][] maze) {
	    int m = maze.length;
	    if (m < 1)
		return new int[0][0];
	    int n = maze[0].length;
	    boolean[][] visited = new boolean[m][n];
	    int[][] sol = new int[m][n];

	    Queue<Queue<Position>> queue = new LinkedList<>();

	    for (int i = 0; i < m; ++i)
		for (int j = 0; j < n; ++j)
		    if (maze[i][j] == 1) {
			Queue<Position> gate = new LinkedList<>();
			gate.add(new Position(i, j));
			queue.add(gate);
			sol[i][j] = 0;
			visited[i][j] = true;
		    }

	    while (!queue.isEmpty()) {
		Queue<Position> bfs = queue.poll();
		Position p = bfs.poll();
		int i = p.x, j = p.y;
		// bfs : up
		if (isValid(maze, i, j - 1, visited)) {
		    bfs.add(new Position(i, j - 1));
		    sol[i][j - 1] = sol[i][j] + 1;
		    visited[i][j - 1] = true;
		}
		// similarly do: left down and right
		if (isValid(maze, i, j + 1, visited)) {
		    bfs.add(new Position(i, j + 1));
		    sol[i][j + 1] = sol[i][j] + 1;
		    visited[i][j + 1] = true;
		}
		if (isValid(maze, i - 1, j, visited)) {
		    bfs.add(new Position(i - 1, j));
		    sol[i - 1][j] = sol[i][j] + 1;
		    visited[i - 1][j] = true;
		}
		if (isValid(maze, i + 1, j, visited)) {
		    bfs.add(new Position(i + 1, j));
		    sol[i + 1][j] = sol[i][j] + 1;
		    visited[i + 1][j] = true;
		}
		if (!bfs.isEmpty())
		    queue.add(bfs);
	    }
	    return sol;
	}

	private boolean isValid(int[][] maze, int i, int j, boolean[][] visited) {
	    int m = maze.length;
	    if (m < 1)
		return false;
	    int n = maze[0].length;
	    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]
		    || maze[i][j] == -1)
		return false;
	    return true;
	}

	public class Position {
	    public int x;
	    public int y;

	    public Position(int x, int y) {
		this.x = x;
		this.y = y;
	    }
	}

    }

    public void printMaze(int[][] maze) {
	System.out.println(Arrays.deepToString(maze));
    }

    public static void main(String[] args) {
	// For simplicity, assuming W(-1), O(0), G(1)
	Random rdm = new Random();
	int size = 5;
	int[][] test = new int[size][size];
	// Generate Random Gates and initilize rest cells on maze
	for (int i = 0; i < size; i++)
	    for (int j = 0; j < size; j++)
		test[i][j] = rdm.nextInt(2);
	// Generate Random Walls
	int num_walls = 2;
	for (int i = 0; i < num_walls; ++i) {
	    int x = rdm.nextInt(size);
	    int y = rdm.nextInt(size);
	    test[x][y] = -1;
	}
//	printMaze(test);
//	printMaze(solution(test));
    }
}
