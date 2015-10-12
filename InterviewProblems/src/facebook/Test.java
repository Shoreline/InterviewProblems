package facebook;

import java.util.*;

public class Test {

    public static void main(String[] args) {
	System.out.println(isOneEditDistance("ab", "acd"));
    }

    public static boolean isOneEditDistance(String s, String t) {
	    if (s.length() > t.length()) {
		return isOneEditDistance(t, s);
	    }
	    if (t.length() - s.length() > 1) {
		return false;
	    }

	    boolean hasDiff = false;

	    for (int i = 0, j = 0; i < s.length(); i++, j++) {
		if (s.charAt(i) != t.charAt(j)) {
		    if (hasDiff) {
			return false;
		    }
		    hasDiff = true;
		    if (s.length() < t.length()) {
			/* 
			 * cannot use j++. fail on "ab", "acd"
			 * 
			 */
			i--;
		    }
		}
	    }

	    return hasDiff || s.length() < t.length();
	}

}
