package string;

import java.util.ArrayList;

public class RestoreIPAddresses {
    /**
     * Restore IP Addresses
     * 
     * Given a string containing only digits, restore it by returning all
     * possible valid IP address combinations.
     * 
     * For example: Given "25525511135",
     * 
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */

    /*
     * The actual addresses are required. DP can only give the number of
     * possible addresses. So, recursion?
     * 
     * Recursion. Each time cut a possible segment and check if the rest String
     * is still possible for part of an IP address
     * 
     * rule for each segment:
     * 
     * 1. if length >1, first digit cannot be 0.
     * 
     * 2. cannot exceed 255
     * 
     * rule for the rest sub-string:
     * 
     * length must bigger than (remaining segNum-1);
     * 
     * length must smaller than 3*(remaining segNum)
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
	ArrayList<String> result = new ArrayList<String>();
	int segNum = 4;

	result = restoreIpAddresses(s, segNum);

	return result;
    }

    private static ArrayList<String> restoreIpAddresses(String s, int segNum) {
	ArrayList<String> result = new ArrayList<String>();

	if (s.length() == 0) {
	    return result;
	}

	if (segNum == 1) {
	    if (s.length() <= 3 && s.length() > 0) {

		if (Integer.valueOf(s) > 256) {
		    return result;
		}

		if (s.length() > 1 && s.charAt(0) == '0') {
		    return result;
		}

		result.add(s);
		return result;
	    }
	}

	for (int i = s.length() - 1; i >= s.length() - 3; i--) {
	    if (!canCut(s, segNum - 1, i)) {
		continue;
	    }
	    String aSeg = s.substring(i, s.length());

	    ArrayList<String> temp = restoreIpAddresses(s.substring(0, i),
		    segNum - 1);
	    for (String aString : temp) {
		String newString = aString + "." + aSeg;
		result.add(newString);
	    }
	}

	return result;
    }

    private static boolean canCut(String s, int segNum, int index) {
	int restLength = index;
	if (index <= (segNum - 1) || index > 3 * segNum) {
	    return false;
	}
	if (Integer.valueOf(s.substring(index, s.length())) > 255) {
	    return false;
	}
	if (s.length() - index > 1 && s.charAt(index) == '0') {
	    return false;
	}

	return true;
    }
}
