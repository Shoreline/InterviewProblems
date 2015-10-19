package algogame;

/**
 * Flip Game II
 * 
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 * 
 * Follow up: Derive your algorithm's runtime complexity.
 */
public class FlipGameII {
    public class Solution {
	public boolean canWin(String s) {
	    return canWin2(s.toCharArray());
	}

	private boolean canWin2(char[] s) {
	    for (int i = 1; i < s.length; i++) {
		if (s[i - 1] == '+' && s[i] == '+') {
		    s[i] = '-';
		    s[i - 1] = '-';

		    if (!canWin2(s)) {
			s[i] = '+';
			s[i - 1] = '+';
			return true;
		    }
		    s[i] = '+';
		    s[i - 1] = '+';
		}
	    }

	    return false;
	}
    }
}
