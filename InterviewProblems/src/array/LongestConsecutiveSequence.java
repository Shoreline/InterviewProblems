package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 *
 */
public class LongestConsecutiveSequence {
    
    /*
     * To get O(N) time complexity, have to trade with space
     * 
     * The idea is to save every numbers in a Set and then for each number in
     * array see how many consecutive numbers in the Set
     * 
     * *Need to remove checked elements in Set, otherwise O(N^2)
     */
    public class Solution {
	public int longestConsecutive(int[] num) {
	    if (num == null || num.length == 0) {
		return 0;
	    }

	    Set<Integer> numSet = new HashSet<Integer>();
	    for (int n : num) {
		numSet.add(n);
	    }

	    int maxLen = 0;
	    Set<Integer> conseNums = new HashSet<Integer>();
	    for (int n : num) {
		if (!numSet.contains(n)) {
		    continue;
		}

		conseNums.add(n);
		int tmp = n + 1;
		while (numSet.contains(tmp)) {
		    conseNums.add(tmp);
		    tmp++;
		}

		tmp = n - 1;
		while (numSet.contains(tmp)) {
		    conseNums.add(tmp);
		    tmp--;
		}

		maxLen = Math.max(maxLen, conseNums.size());

		numSet.removeAll(conseNums);
		conseNums.clear();
	    }

	    return maxLen;
	}
    }
}
