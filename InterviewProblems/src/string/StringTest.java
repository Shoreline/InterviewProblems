package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println("a".substring(0, 1));
	
//	Set<String> ssss = new HashSet<String>();
//	ssss.add("a");
//	new StringTest().wordBreak("a",ssss);
//	
//	System.out.println(new StringTest().new Solution()
//		.isMatch("aaaaaaaaaaaaaaaaaaaaaaa", "*aaaaaaaaaaaaaaaaaaaaaaa*"));

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
     * if s = "aaaaaaaa...a" and p = "*aaaaa...a*" then stack over flow: 
     * too many recursion calls
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
    
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null||s.length()==0){
            return true;
        }
        else if(dict==null || dict.size()==0){
            return false;
        }
        
        // dp[i] means whether there is a perfect word break ends for the first i characters
        // array size is s.length() + 1 since we need to include when zero character is included
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j <=i; j++){
                String piece = s.substring(j-1,i+1);
                
                if(dict.contains(piece)&&dp[j-1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length-1];
    }
}
