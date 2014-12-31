package array;

import java.util.ArrayList;

public class NQueens {
    /**
     * N-Queens
     * 
     * The n-queens puzzle is the problem of placing n queens on an n x n
     * chessboard such that no two queens attack each other.
     * 
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * 
     * Each solution contains a distinct board configuration of the n-queens'
     * placement, where 'Q' and '.' both indicate a queen and an empty space
     * respectively.
     * 
     * For example, There exist two distinct solutions to the 4-queens puzzle:
     * 
     * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
     * 
     * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
     */

    /*
     * two time pass!
     * 
     * Algorithm:
     * http://zhedahht.blog.163.com/blog/static/2541117420114331616329/
     * 
     * get all permutation of 0,1,2,...n; for each permutation check if this it
     * is a solution; if it is a solution, construct the corresponding String[]
     * array and add it to result list
     * 
     * I think we can check a permutation earlier, before it is fully
     * constructed. This shall save some time
     */

    public static ArrayList<String[]> solveNQueens(int n) {

	ArrayList<String[]> result = new ArrayList<String[]>();

	if (n < 1)
	    return result;

	ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();

	// return all solutions
	getSolutions(solutions, n, new boolean[n], new int[n], 0);

	char[] aLine = new char[n];
	for (int i = 0; i < n; i++) {
	    aLine[i] = '.';
	}

	for (ArrayList<Integer> solution : solutions) {
	    String[] aResult = new String[n];

	    int i = 0;
	    for (Integer anInt : solution) {
		aLine[anInt] = 'Q';
		aResult[i] = new String(aLine);
		aLine[anInt] = '.';
		i++;
	    }
	    result.add(aResult);
	}

	return result;
    }

    private static void getSolutions(ArrayList<ArrayList<Integer>> s, int n,
	    boolean[] used, int[] temp, int amount) {
	if (amount == n) {
	    // check if this is a solution
	    for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
		    /*
		     * KEY! Check if the column difference is identical to the
		     * row difference
		     */
		    if (Math.abs(i - j) == Math.abs((temp[i] - temp[j])))
			return;
		}
	    }

	    // if reach here we have a solution
	    ArrayList<Integer> solution = new ArrayList<Integer>();
	    for (int i = 0; i < n; i++) {
		solution.add(temp[i]);
	    }
	    s.add(solution);
	    return;
	}

	for (int i = 0; i < n; i++) {
	    if (used[i] == true)
		continue;

	    temp[amount] = i;
	    used[i] = true;
	    getSolutions(s, n, used, temp, amount + 1);
	    used[i] = false;
	}

    }
}
