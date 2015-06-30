package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Surrounded Regions
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example, X X X X X O O X X X O X X O X X
 * 
 * After running your function, the board should be: X X X X X X X X X X X X X O
 * X X
 * 
 */

/*
 * Idea: do not looking for surrounded regions directly. Mark 'O' regions that
 * connected to an edge with another color. Except these regions, all other 'O'
 * regions shall be flipped to 'X'
 * 
 * Important: Different between queue.add() and queue.offer() in Java; When to
 * flag node while doing BFS
 */

public class SurroundedRegions {
    public class Solution {
	public void solve(char[][] board) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
		return;
	    }

	    for (int i = 0; i < board.length; i++) {
		fill(board, i, 0, 'O', '#');
		fill(board, i, board[0].length - 1, 'O', '#');
	    }

	    for (int j = 0; j < board[0].length; j++) {
		fill(board, 0, j, 'O', '#');
		fill(board, board.length - 1, j, 'O', '#');
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    board[i][j] = (board[i][j] == '#' ? 'O' : 'X');
		}
	    }
	}

	private void fill(char[][] board, int i, int j, char oldColor,
		char newColor) {
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
		    || board[i][j] != oldColor) {
		return;
	    }

	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(i * board[0].length + j);
	    board[i][j] = newColor;

	    while (!queue.isEmpty()) {
		int pos = queue.poll();
		int m = pos / board[0].length;
		int n = pos % board[0].length;
		/*
		 * Do not flag element here, too late. May add duplicated nodes
		 * to queue
		 * 
		 * must flag board element at the time they are added to queue.
		 * Otherwise duplicated check!!!
		 */
		// board[x][y]='#';

		if (m + 1 < board.length && board[m + 1][n] == oldColor) {
		    queue.add((m + 1) * board[0].length + n);
		    board[m + 1][n] = newColor;
		}
		if (m - 1 >= 0 && board[m - 1][n] == oldColor) {
		    queue.add((m - 1) * board[0].length + n);
		    board[m - 1][n] = newColor;
		}
		if (n + 1 < board[0].length && board[m][n + 1] == oldColor) {
		    queue.add(m * board[0].length + n + 1);
		    board[m][n + 1] = newColor;
		}
		if (n - 1 >= 0 && board[m][n - 1] == oldColor) {
		    queue.add(m * board[0].length + n - 1);
		    board[m][n - 1] = newColor;
		}
	    }
	}
    }

    /*
     * Even scan twice is not enough. May need to scan four times, each time
     * from a corner. Not a good way.
     */
    public class Wrong_attempt {
	public void solve(char[][] board) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
		return;
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    filler(board, i, j);
		}
	    }

	    for (int i = board.length - 1; i >= 0; i--) {
		for (int j = board[0].length - 1; j >= 0; j--) {
		    filler(board, i, j);
		}
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    if (board[i][j] == 'O') {
			board[i][j] = 'X';
		    } else if (board[i][j] == '#') {
			board[i][j] = 'O';
		    }
		}
	    }
	}

	private void filler(char[][] board, int i, int j) {
	    if (board[i][j] == 'O'
		    && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {
		board[i][j] = '#';
	    }

	    if (board[i][j] != '#') {
		return;
	    }

	    int k = i;
	    while (k - 1 >= 0 && board[k - 1][j] == 'O') {
		board[k - 1][j] = '#';
		k--;
	    }

	    k = i;
	    while (k + 1 < board.length && board[k + 1][j] == 'O') {
		board[k + 1][j] = '#';
		k++;
	    }

	    k = j;
	    while (k - 1 >= 0 && board[i][k - 1] == 'O') {
		board[i][k - 1] = '#';
		k--;
	    }

	    k = j;
	    while (k + 1 < board[0].length && board[i][k + 1] == 'O') {
		board[i][k + 1] = '#';
		k++;
	    }
	}
    }

    /*
     * DFS cannot pass all leetcode tests. Stack over flow.
     * 
     * The given board is too large.
     */
    public class Method_DFS {
	public void solve(char[][] board) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
		return;
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    dfs(board, i, j);
		}
	    }
	}

	private boolean dfs(char[][] board, int i, int j) {
	    if (i < 0 || i > board.length - 1 || j < 0
		    || j > board[0].length - 1 || board[i][j] == 'X') {
		return true;
	    } else if (i == 0 || i == board.length - 1 || j == 0
		    || j == board[0].length - 1) {
		return false;
	    }

	    board[i][j] = 'X';
	    if (dfs(board, i - 1, j) && dfs(board, i + 1, j)
		    && dfs(board, i, j - 1) && dfs(board, i, j + 1)) {
		return true;
	    } else {
		board[i][j] = 'O';
		return false;
	    }
	}
    }
}
