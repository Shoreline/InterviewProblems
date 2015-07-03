package array;

/**
 * Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 */

public class SudokuSolver {

    /*
     * Backtracking
     */
    public class Solution {
	public void solveSudoku(char[][] board) {
	    dfs(board, 0);
	}

	private boolean dfs(char[][] board, int n) {
	    if (n == 81) {
		return true;
	    }
	    int i = n / 9;
	    int j = n % 9;
	    if (board[i][j] != '.') {
		return dfs(board, n + 1);
	    } else {
		for (int k = 1; k <= 9; k++) {
		    char c = (char) ('0' + k);
		    board[i][j] = c;
		    if (isValid(board, i, j)) {
			if (dfs(board, n + 1)) {
			    return true;
			}
		    }
		    board[i][j] = '.';
		}

	    }
	    return false;
	}

	private boolean isValid(char[][] board, int i, int j) {
	    for (int row = 0; row < 9; row++) {
		if (row != i && board[row][j] == board[i][j]) {
		    return false;
		}
	    }

	    for (int col = 0; col < 9; col++) {
		if (col != j && board[i][col] == board[i][j]) {
		    return false;
		}
	    }

	    for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
		for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
		    if ((row != i || col != j)
			    && board[row][col] == board[i][j]) {
			return false;
		    }
		}
	    }

	    return true;
	}
    }

    public void solveSudoku(char[][] board) {
	if (board == null || board.length != 9 || board[0].length != 9)
	    return;

    }
}
