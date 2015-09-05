package pinterest;

import java.util.*;

/**
 * You’re given a board game which is a row of squares, each labeled with an
 * integer. This can be represented by a list, e.g. [1, 3, 2, 0, 5, 2, 8, 4, 1]
 * Given a start position on the board, you “win” by landing on a zero, where
 * you move by jumping from square to square either left or right the number of
 * spaces specified on the square you’re currently on. Your task is to implement
 * the function: def can_win(board, pos): returns True if you can win the board
 * from that starting pos, False otherwise
 * 
 * 给一个数组和一个位置，从该位置起左右jump，检测能否jump到值为0的位置, canJump(int a[], int pos)
 * 比如：[1,2,1,0,3] index从0开始，如果你在index=4位置，你可以先left jump到index=1, 然后right
 * jump到index=3，then canJump(a,4) return true.
 *
 */

/*
 * 建n个节点的图，然后BFS、DFS 第i个节点的出边为 和 。以第pos节点开始BFS或DFS搜 索是否能到达值为0的节点 时间O(n)空间O(n)
 * 
 * -> don't think you need to actually create a graph. Just use the original
 * array. Mark visited indices.
 */
public class CanJump {
    /*
     * Time: O(N); Space: O(N) (stack cost)
     */
    class Method {
	public boolean canJump(int[] row, int start) {
	    return dfs(row, start, new HashSet<Integer>());
	}

	private boolean dfs(int[] row, int start, Set<Integer> visited) {
	    if (start < 0 || start >= row.length || visited.contains(start)) {
		return false;
	    }

	    if (row[start] == 0) {
		return true;
	    }
	    visited.add(start);
	    return dfs(row, start - row[start], visited)
		    || dfs(row, start + row[start], visited);
	}
    }

    public static void main(String[] args) {
	int[] row = new int[] { 1, 3, 2, 0, 5, 2, 8, 4, 1 };

	for (int i = 0; i < row.length; i++) {
	    System.out.println(new CanJump().new Method().canJump(row, i));
	}

    }
}
