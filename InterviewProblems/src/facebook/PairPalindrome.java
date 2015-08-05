package facebook;

import java.util.*;

/**
 * Given a string list，find all pairs of strings which can be combined to be a
 * palindrome. eg: cigar + tragic -> cigartragic, none + xenon -> nonexenon
 */

/*
 * http://www.careercup.com/question?id=4879869638868992
 */
public class PairPalindrome {
    public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("cigar");
	list.add("tragic");
	list.add("none");
	list.add("xenon");
	list.add("abc");
	list.add("ba");
	Solution_Baseline sol = new PairPalindrome().new Solution_Baseline();
	System.out.println(sol.pairPalindrome(list));
	
	Method_Hash sol2 = new PairPalindrome().new Method_Hash();
	System.out.println(sol2.pairPalindrome(list));

    }

    public class Method_Hash {
	public List<List<String>> pairPalindrome(List<String> words) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    if (words == null || words.size() < 2) {
		return res;
	    }

	    

	    return res;
	}
    }

    public class Solution_Baseline {
	public List<List<String>> pairPalindrome(List<String> words) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    if (words == null || words.size() < 2) {
		return res;
	    }

	    HashSet<String> hashset = new HashSet<String>();
	    for (String word : words) {
		hashset.add(word);
	    }

	    for (String word : words) {
		for (String word2 : words) {
		    if (!word.equals(word2) && isPalindrome(word + word2)) {
			List<String> ans = new ArrayList<>();
			ans.add(word);
			ans.add(word2);
			res.add(ans);
		    }
		}

	    }
	    return res;
	}

	private boolean isPalindrome(String word) {
	    int start = 0, end = word.length() - 1;
	    while (start < end) {
		if (word.charAt(start) != word.charAt(end)) {
		    return false;
		}
		start++;
		end--;
	    }
	    return true;
	}
    }
}
