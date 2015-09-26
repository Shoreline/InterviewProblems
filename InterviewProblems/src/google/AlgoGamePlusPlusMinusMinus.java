package google;

import java.util.*;

import google.LongestIncreasingContinuousSubSequence.Solution;

/**
 * input string：“+++--++-+”
 * 
 * 游戏规则：每人每次可以 flip "++" to "--"（必须是相邻的）
 * 
 * 
 * 第一问：generate all possible moves
 * 
 * 第二问：determine if this player can will
 * 
 * Extra：这两个问题的implementation的Big-O
 *
 */

/*
 * 
 */
public class AlgoGamePlusPlusMinusMinus {
    class Method_DFS {
	boolean canWin(String input) {
	    List<Integer> list = new ArrayList<>();

	    String[] plusArr = input.split("-");
	    for (String str : plusArr) {
		if (!str.isEmpty()) {
		    list.add(str.length());
		}
	    }
	    System.out.print(list);
	    return canWin(list);
	}

	/*
	 * elements in the list are length, so they are 1-based
	 */
	private boolean canWin(List<Integer> list) {

	    boolean canMove = false;

	    for (int i = 0; i < list.size(); i++) {
		int len = list.get(i);
		for (int j = 2; j <= len; j++) {
		    canMove = true;

		    int len1 = j - 2;
		    int len2 = len - j;

		    if (len1 >= 2 && len2 >= 2) {
			list.set(i, len1);
			list.add(len2);
		    } else {
			list.set(i, len1 >= 2 ? len1 : len2);
		    }

		    /*
		     * In any case, if next round the opponent cannot win then
		     * you will win
		     */
		    if (!canWin(list)) {
			return true;
		    }
		    list.set(i, len);

		    if (len1 >= 2 && len2 >= 2) {
			list.remove(list.size() - 1);
		    }
		}
	    }

	    return canMove;
	}
    }

    public static void main(String[] args) {

	System.out.println(new AlgoGamePlusPlusMinusMinus().new Method_DFS()
		.canWin("-++--+++-++"));

    }
}
