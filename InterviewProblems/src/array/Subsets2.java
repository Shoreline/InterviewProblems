package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */

public class Subsets2 {
    /*
     * DFS
     * 
     * How to avoid repeatedly adding duplicate groups:
     * 
     * -> When sees duplicated elements (say 2), let 2; 2,2; 2,2,2;... can only
     * show once each, and in the same child branch of '2'
     * 
     * -> So in each branch (one "round" of DFS), if from S[pos] to
     * S[S.length-1] there are duplicates, only allow the fist one (S[pos]) to
     * be added to tmp list
     * 
     * The rest is the same with subset I
     * 
     * if (i > pos && nums[i] == nums[i - 1]) continue;
     * 
     * -> if i==pos, then no matter nums[i] is a repeated element it will be
     * added to tmp
     */
    public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
		return res;
	    }

	    Arrays.sort(nums);
	    dfs(nums, 0, new ArrayList<Integer>(), res);
	    return res;
	}

	private void dfs(int[] nums, int pos, List<Integer> tmp,
		List<List<Integer>> res) {
	    res.add(new ArrayList<Integer>(tmp));

	    for (int i = pos; i < nums.length; i++) {
		if (i > pos && nums[i] == nums[i - 1]) {
		    continue;
		}

		tmp.add(nums[i]);
		dfs(nums, i + 1, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    /*
     * The hard part is, we are not allowed to use Set which can automatically
     * eliminate duplicate cases
     * 
     * Trick: For an element E that is identical with previous element E': find
     * out which ArrayLists got added E' last round (no matter E' is a duplicate
     * one), then only add E to these lists
     */
    class Solution_old {
	int newListNum = 0;

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	    Arrays.sort(num);

	    ArrayList<ArrayList<Integer>> result = subsetsWithDup(num,
		    num.length - 1);

	    return result;
	}

	private ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num,
		int startIndex) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    if (startIndex < 0) {
		ArrayList<Integer> emptyList = new ArrayList<Integer>();
		result.add(emptyList);
		newListNum = 1;
		return result;
	    }

	    ArrayList<ArrayList<Integer>> temp = subsetsWithDup(num,
		    startIndex - 1);
	    result.addAll(temp);

	    if (startIndex > 0 && num[startIndex] == num[startIndex - 1]) {
		// only deal with the new elements just added last time
		for (int i = newListNum - 1; i >= 0; i--) {
		    ArrayList<Integer> newList = new ArrayList<Integer>();
		    newList.addAll(temp.get(temp.size() - 1 - i));
		    newList.add(num[startIndex]);
		    result.add(newList);
		}

	    } else {
		for (ArrayList<Integer> aList : temp) {
		    ArrayList<Integer> newList = new ArrayList<Integer>();
		    newList.addAll(aList);
		    newList.add(num[startIndex]);
		    result.add(newList);
		}
		newListNum = temp.size();
	    }

	    return result;
	}
    }
}
