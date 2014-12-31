package array;

import java.util.HashSet;

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
     * Backtracking
     * 
     * unfinished
     */
    public void solveSudoku(char[][] board) {
	// Start typing your Java solution below
	// DO NOT write main() function

	if (board == null || board[0].length == 0)
	    return;

	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] == '.') {
		    for (int k = 0; k < 9; k++) {
			char c = (char) ('1' + k);
			board[i][j] = c;
			if (isValidSudoku(board)) {
			    return;
			} else {
			    solveSudoku(board);
			}
			board[i][j] = '.';
		    }
		}
	    }
	}

    }

    // shall only check affected row/column/block when a new number is added
    private static boolean isValidSudoku(char[][] board) {
	if (board == null || board.length != 9 || board[0].length != 9)
	    return false;

	HashSet<Integer> nums = new HashSet<Integer>(9);

	for (int i = 0; i < 9; i++) {
	    nums.clear();
	    for (int j = 0; j < 9; j++) {
		char c = board[i][j];

		if (c != '.' && nums.contains('0' - c))
		    return false;
		nums.add('0' - c);

	    }

	}

	for (int i = 0; i < 9; i++) {
	    nums.clear();
	    for (int j = 0; j < 9; j++) {
		char c = board[j][i];

		if (c != '.' && nums.contains('0' - c))
		    return false;
		nums.add('0' - c);

	    }
	}

	for (int m = 0; m < 9; m += 3) {
	    for (int n = 0; n < 9; n += 3) {
		nums.clear();
		for (int i = m; i < m + 3; i++) {
		    for (int j = n; j < n + 3; j++) {
			char c = board[j][i];

			if (c != '.' && nums.contains('0' - c))
			    return false;
			nums.add('0' - c);

		    }
		}
	    }
	}

	return true;
    }
}
