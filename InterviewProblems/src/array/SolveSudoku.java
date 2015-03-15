package array;


public class SolveSudoku {
    /**
     * Sudoku Solver
     * 
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * 
     * Empty cells are indicated by the character '.'.
     * 
     * You may assume that there will be only one unique solution.
     */

    /*
     * [2015] Solution
     * DFS + backtracking 
     */
    public class Solution {

	private boolean[][] rows = new boolean[9][9];
	private boolean[][] columns = new boolean[9][9];
	private boolean[][] subBoards = new boolean[9][9];

	public void solveSudoku(char[][] board) {
	    if (board == null || board.length != 9 || board[0].length != 9) {
		return;
	    }

	    for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
		    if (board[i][j] == '.') {
			continue;
		    }
		    int c = board[i][j] - '1';
		    rows[i][c] = true;
		    columns[j][c] = true;
		    subBoards[i / 3 * 3 + j / 3][c] = true;
		}
	    }

	    solveSudokuHelper(0, 0, board);
	}

	private boolean solveSudokuHelper(int i, int j, char[][] board) {
	    if (i > 8) {
		return true;
	    }

	    if (board[i][j] != '.') {
		if (j < 8) {
		    return solveSudokuHelper(i, j + 1, board);
		} else {
		    return solveSudokuHelper(i + 1, 0, board);
		}
	    }

	    for (int c = 0; c < 9; c++) {
		if (rows[i][c] || columns[j][c]
			|| subBoards[i / 3 * 3 + j / 3][c]) {
		    continue;
		} else {
		    board[i][j] = (char) ('1' + c);
		    rows[i][c] = true;
		    columns[j][c] = true;
		    subBoards[i / 3 * 3 + j / 3][c] = true;

		    if (solveSudokuHelper(i, j, board)) {
			return true;
		    } else {
			// if did not find a solution, restore board[i][j] status for next try
			board[i][j] = '.';
			rows[i][c] = false;
			columns[j][c] = false;
			subBoards[i / 3 * 3 + j / 3][c] = false;
		    }
		}

	    }

	    return false;
	}

    }
}
