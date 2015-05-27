package string;

public class IsOneEditDistance {
    
    public class Solution {	
	public boolean isOneEditDistance(String s, String t) {
	    
	    if(s.length()<t.length()){
		return isOneEditDistance(t,s);
	    }	    

	    if (s.length() - t.length() > 1) {
		return false;
	    } else if (s.length() == 0 && t.length() == 0) {
		return false;
	    } else if (t.length() == 0) {
		return true;
	    }

	    boolean diff = false;
	    int i = 0;
	    int j = 0;
	    while (i < t.length()) {
		if (t.charAt(i) != s.charAt(j)) {
		    if (diff) {
			return false;
		    } else if (s.length() > t.length()) {
			j++;
		    }
		    diff = true;
		}

		i++;
		j++;
	    }

	    if (diff && j< s.length()) {
		return false;
	    }

	    return diff;
	}
	}
    
    
    /*
     * Time limit exceeded?
     */
    public class Method {	
	public boolean isOneEditDistance(String s, String t) {
	    String strS = s.length() >= t.length() ? t : s;
	    String strL = s.length() >= t.length() ? s : t;

	    if (strL.length() - strS.length() > 1) {
		return false;
	    } else if (strS.length() == 0 && strL.length() == 0) {
		return false;
	    } else if (strS.length() == 0) {
		return true;
	    }

	    boolean diff = false;
	    int i = 0;
	    int j = 0;
	    while (i < strS.length()) {
		if (strS.charAt(i) != strL.charAt(j)) {
		    if (diff) {
			return false;
		    } else if (strL.length() > strS.length()) {
			j++;
		    }
		    diff = true;
		}

		i++;
		j++;
	    }

	    if (diff && j< strL.length()) {
		return false;
	    }

	    return diff;
	}
	}
}
