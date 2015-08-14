package array;

import java.util.HashSet;

/**
 * Valid Sudoku
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 */
public class ValidSudoku {
    /*
     * [2015] Simpler to implement, but costs much more space
     * 
     * *NOTE: element board[i][j] belongs to the (i/3*3 + j/3)-th sub-board
     */
    public class Solution {
	public boolean isValidSudoku(char[][] board) {
	    boolean[][] rows = new boolean[9][9];
	    boolean[][] columns = new boolean[9][9];
	    boolean[][] blocks = new boolean[9][9];

	    for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
		    if (board[i][j] == '.') {
			continue;
		    }
		    int num = board[i][j] - '1';// let c belongs to 0 ~ 8
		    if (rows[i][num] || columns[j][num] || blocks[i / 3 * 3 + j / 3][num]) {
			return false;
		    }
		    rows[i][num] = columns[j][num] = blocks[i / 3 * 3 + j / 3][num] = true;
		}
	    }

	    return true;
	}
    }

    /*
     * Simple checks of constraints
     */
    public class Solution_bruteForce {
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

			    char c = board[i][j];
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
}
