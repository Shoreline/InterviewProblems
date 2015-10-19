package algogame;

import java.util.*;

/**
 * Flip Game
 * 
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to compute all possible states of the string after one valid
 * move.
 * 
 * For example, given s = "++++", after one move, it may become one of the
 * following states:
 * 
 * [ "--++",
 * 
 * "+--+",
 * 
 * "++--" ]
 * 
 * If there is no valid move, return an empty list [].
 *
 */
public class FlipGame {
    public class Solution {
	public List<String> generatePossibleNextMoves(String s) {
	    List<String> res = new ArrayList<>();
	    char[] arr = s.toCharArray();
	    for (int i = 1; i < arr.length; i++) {
		if (arr[i] == '+' && arr[i - 1] == '+') {
		    arr[i] = '-';
		    arr[i - 1] = '-';
		    res.add(new String(arr));
		    arr[i] = '+';
		    arr[i - 1] = '+';
		}
	    }
	    return res;
	}
    }

    public class Solution2 {
	public List<String> generatePossibleNextMoves(String s) {
	    List<String> res = new ArrayList<>();
	    for (int i = 1; i < s.length(); i++) {
		if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
		    StringBuilder sb = new StringBuilder();
		    sb.append(s.substring(0, i - 1));
		    sb.append("--");
		    // if(i<s.length()-1){
		    sb.append(s.substring(i + 1));
		    // }
		    res.add(sb.toString());
		}
	    }
	    return res;
	}
    }
}
