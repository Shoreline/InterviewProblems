package array;

/**
 * Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [
 * 
 * ["ABCE"],
 * 
 * ["SFCS"],
 * 
 * ["ADEE"]
 * 
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * 
 * word = "SEE", -> returns true,
 * 
 * word = "ABCB", -> returns false.
 */

/*
 * DFS
 */
public class WordSearch {
    public class Solution {
	public boolean exist(char[][] board, String word) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
		return false;
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    if (dfs(board, i, j, word, 0)) {
			return true;
		    }
		}
	    }

	    return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word,
		int ptr) {
	    if (ptr == word.length()) {
		return true;
	    }
	    char c = word.charAt(ptr);
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
		    || board[i][j] != c) {
		return false;
	    }

	    board[i][j] = '.';
	    if (dfs(board, i + 1, j, word, ptr + 1)
		    || dfs(board, i - 1, j, word, ptr + 1)
		    || dfs(board, i, j + 1, word, ptr + 1)
		    || dfs(board, i, j - 1, word, ptr + 1)) {
		return true;
	    }
	    board[i][j] = c;

	    return false;
	}

    }
    
    /*
     * Idea comes from a high hand.
     * 
     * Avoid using any boolean[][] array to record whether an element in board
     * has been visited. Instead, use a special character to represent true in
     * the input 2D array
     */
    class Solution_HighHand {
	public boolean exist(char[][] board, String word) {

	    if (board == null || board.length == 0) {
		return false;
	    }
	    if (word.length() == 0) {
		return true;
	    }

	    char c = word.charAt(0);
	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    if (board[i][j] == c) {
			board[i][j] = '*'; // mark as visited
			boolean result = dfs(board, word, i, j, 1);
			if (result) {
			    return true;
			}
			board[i][j] = c;// change it back, so no need to use
					// other
					// boolean array(s)
		    }
		}
	    }

	    return false;
	}

	private boolean dfs(char[][] board, String word, int row, int column,
		int index) {
	    if (index == word.length()) {
		return true;
	    }

	    /*
	     * trick: use a 2D array to store possible movements in a matrix
	     * 
	     * Actually, at least one of the four possible moves surely does not
	     * work (the previously move lead us to current position). But we
	     * just do not care avoiding that
	     */

	    char c = word.charAt(index);
	    int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 },
		    { -1, 0 } };

	    for (int m = 0; m < moves.length; m++) {
		int i = row + moves[m][0];
		int j = column + moves[m][1];

		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
			&& board[i][j] == c) {
		    board[i][j] = '*';
		    if (dfs(board, word, i, j, index + 1)) {
			return true;
		    }
		    board[i][j] = c;
		}

	    }

	    return false;
	}
    }
}
