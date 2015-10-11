package array;

import java.util.Arrays;

/**
 * H-Index
 * 
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 * 
 * Hint:
 * 
 * An easy approach is to sort the array first. What are the possible values of
 * h-index? A faster approach is to use extra space.
 *
 */
public class H_Index {
    /*
     * Time: O(N); Space: O(N)
     * 
     * The h-index can only from [0,...,n].
     * 
     * stats[i] saves: how many papers were cited i times; or at least N times
     */
    public class Solution {
	public int hIndex(int[] citations) {
	    if (citations == null || citations.length == 0) {
		return 0;
	    }

	    int len = citations.length;

	    int[] stats = new int[len + 1];
	    for (int i = 0; i < len; i++) {
		int count = citations[i] > len ? len : citations[i];
		stats[count]++;
	    }

	    /*
	     * the earlier return, the higher h-index
	     * 
	     * i: at_least_cititons_a_paper_get
	     */
	    int sum = 0;
	    for (int i = len; i >= 0; i--) {
		sum += stats[i];
		if (sum >= i) {
		    return i;
		}
	    }
	    return 0;
	}
    }

    /*
     * Time: O(NlogN); Space: O(1)
     */
    public class Solution2 {
	public int hIndex(int[] citations) {
	    if (citations == null || citations.length == 0) {
		return 0;
	    }

	    Arrays.sort(citations);

	    int i = citations.length - 1;
	    while (i >= 0 && citations[i] >= (citations.length - i)) {
		i--;
	    }

	    return citations.length - i - 1;
	}
    }
}
