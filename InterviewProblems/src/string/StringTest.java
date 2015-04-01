package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(Character.isLetter('c'));
	new StringTest().isPalindrome("ab");
	String haha = "";
	
	//System.out.println(new StringTest().wordBreak("catsanddog", new HashSet<String>({{add("cat"),}})));

	// Set<String> ssss = new HashSet<String>();
	// ssss.add("a");
	// new StringTest().wordBreak("a",ssss);
	//
	// System.out.println(new StringTest().new Solution()
	// .isMatch("aaaaaaaaaaaaaaaaaaaaaaa", "*aaaaaaaaaaaaaaaaaaaaaaa*"));

    }
    
    public boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }
        else if(s.length() == 0){
            return true;
        }
        
        s = s.toLowerCase();
        
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char front = s.charAt(i);
            char back = s.charAt(j);
            if(!Character.isLetter(front)||!Character.isDigit(front)){
                i++;
                continue;
            }
            else if(!Character.isLetter(back)||!Character.isDigit(back)){
                j--;
                continue;
            }
            
            if(front!=back){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }

    /*
     * deal with corner cases: lenS = 0 and lenP > 0
     */
    public class Solution2 {
	public boolean isMatch(String s, String p) {
	    if (s == null || p == null) {
		return false;
	    } else if (s.length() == 0 && p.length() == 0) {
		return true;
	    } else if (s.length() == 0 && p.charAt(0) == '*') {
		// corner case: s = "" and p = "***"
		return isMatch(s, p.substring(1));
	    } else if (s.length() == 0 || p.length() == 0) {
		return false;
	    }

	    char s0 = s.charAt(0);
	    char p0 = p.charAt(0);
	    char p1 = (p.length() > 1 ? p.charAt(1) : '0');

	    if (p0 == '*') {
		if (p.length() == 1) {
		    return true;
		}

		int i = 0;
		while (i < s.length() && s.charAt(i) != p1) {
		    i++;
		}

		return isMatch(s.substring(i), p.substring(1));
	    } else if (p0 == '?' || p0 == s0) {

		return isMatch(s.substring(1), p.substring(1));
	    } else {
		return false;
	    }
	}
    }

    /*
     * if s = "aaaaaaaa...a" and p = "*aaaaa...a*" then stack over flow: too
     * many recursion calls
     */
    public class Solution {
	public boolean isMatch(String s, String p) {
	    if (s == null || p == null) {
		return false;
	    } else if (s.length() == 0 && p.length() == 0) {
		return true;
	    } else if (s.length() == 0 && p.charAt(0) == '*') {
		// corner case: s = "" and p = "***"
		return isMatch(s, p.substring(1));
	    } else if (s.length() == 0 || p.length() == 0) {
		return false;
	    }

	    char s0 = s.charAt(0);
	    char p0 = p.charAt(0);
	    char p1 = (p.length() > 1 ? p.charAt(1) : '0');

	    if (p0 == '*') {
		if (p.length() == 1) {
		    return true;
		}

		int i = 0;
		while (i < s.length() && s.charAt(i) != p1) {
		    i++;
		}

		return isMatch(s.substring(i), p.substring(1));
	    } else if (p0 == '?' || p0 == s0) {
		return isMatch(s.substring(1), p.substring(1));
	    } else {
		return false;
	    }
	}
    }

    // MLE
    public List<String> wordBreak(String s, Set<String> dict) {
	List<String> res = new ArrayList<String>();

	if (s == null || s.length() == 0) {
	    res.add("");
	    return res;
	} else if (dict == null || dict.isEmpty()) {
	    return res;
	}

	Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
	dp.put(0, new ArrayList<String>(Arrays.asList("")));

	for (int i = 1; i <= s.length(); i++) {
	    dp.put(i, new ArrayList<String>()); // just create a list for each
						// index
	    for (int j = 0; j < i; j++) {
		String piece = s.substring(j, i);
		if (dict.contains(piece)) {
		    for (String str : dp.get(j)) {
			dp.get(i).add(str + " " + piece);
		    }
		}
	    }
	}

	return dp.get(s.length());
    }

}
