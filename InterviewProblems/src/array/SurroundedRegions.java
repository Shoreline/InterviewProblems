package array;

import java.util.LinkedList;

/**
 * Surrounded Regions
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
	X X X X
	X O O X
	X X O X
	X O X X
 * 
 * After running your function, the board should be:
 * 	X X X X
	X X X X
	X X X X
	X O X X
 * 
 */

/*
 * Important:
 * Different between queue.add() and queue.offer() in Java;
 * When to flag node while doing BFS
 */

public class SurroundedRegions {
    public class Solution_my {
	public void solve(char[][] board) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
		return;
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    bfs(board, i, j);
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

	private void bfs(char[][] board, int i, int j) {
	    if (board[i][j] == 'O'
		    && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {

		LinkedList<Integer> queueX = new LinkedList<Integer>();
		LinkedList<Integer> queueY = new LinkedList<Integer>();
		queueX.offer(i);
		queueY.offer(j);
		board[i][j] = '#';
		while (!queueX.isEmpty()) {
		    int x = queueX.poll();
		    int y = queueY.poll();
		    /*
		     * Do not flag element here, too late.
		     * 
		     * must flag board element at the time they are added to
		     * queue. Otherwise duplicated check!!!
		     */
		    // board[x][y]='#';

		    if (x - 1 >= 0 && board[x - 1][y] == 'O') {
			queueX.offer(x - 1);
			queueY.offer(y);
			board[x - 1][y] = '#';
		    }
		    if (x + 1 < board.length && board[x + 1][y] == 'O') {
			queueX.offer(x + 1);
			queueY.offer(y);
			board[x + 1][y] = '#';
		    }
		    if (y - 1 >= 0 && board[x][y - 1] == 'O') {
			queueX.offer(x);
			queueY.offer(y - 1);
			board[x][y - 1] = '#';
		    }
		    if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
			queueX.offer(x);
			queueY.offer(y + 1);
			board[x][y + 1] = '#';
		    }
		}

	    }
	}
    }

    public class Solution_best {
	public void solve(char[][] board) {
	    if (board == null || board.length <= 1 || board[0].length <= 1)
		return;
	    for (int i = 0; i < board[0].length; i++) {
		fill(board, 0, i);
		fill(board, board.length - 1, i);
	    }
	    for (int i = 0; i < board.length; i++) {
		fill(board, i, 0);
		fill(board, i, board[0].length - 1);
	    }
	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    if (board[i][j] == 'O')
			board[i][j] = 'X';
		    else if (board[i][j] == '#')
			board[i][j] = 'O';
		}
	    }
	}

	private void fill(char[][] board, int i, int j) {
	    if (board[i][j] != 'O')
		return;
	    board[i][j] = '#';
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    int code = i * board[0].length + j;
	    queue.offer(code);
	    while (!queue.isEmpty()) {
		code = queue.poll();
		int row = code / board[0].length;
		int col = code % board[0].length;
		if (row > 0 && board[row - 1][col] == 'O') {
		    queue.offer((row - 1) * board[0].length + col);
		    board[row - 1][col] = '#';
		}
		if (row < board.length - 1 && board[row + 1][col] == 'O') {
		    queue.offer((row + 1) * board[0].length + col);
		    board[row + 1][col] = '#';
		}
		if (col > 0 && board[row][col - 1] == 'O') {
		    queue.offer(row * board[0].length + col - 1);
		    board[row][col - 1] = '#';
		}
		if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
		    queue.offer(row * board[0].length + col + 1);
		    board[row][col + 1] = '#';
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
