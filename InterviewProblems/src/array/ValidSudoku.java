package array;

import java.util.HashSet;

public class ValidSudoku {
    /**
     * Valid Sudoku
     * 
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * 
     * The Sudoku board could be partially filled, where empty cells are filled
     * with the character '.'.
     */

    /*
     * Simple checks of constraints?
     */
    public boolean isValidSudoku(char[][] board) {
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
