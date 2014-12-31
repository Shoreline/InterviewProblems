package string;

public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using
     * the following mapping:
     * 
     * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
     * digits, determine the total number of ways to decode it.
     * 
     * For example, Given encoded message "12", it could be decoded as "AB" (1
     * 2) or "L" (12).
     * 
     * The number of ways decoding "12" is 2.
     */

    /*
     * the tricky part is 1) how to deal with "10" and "20" 2) get rid of "0"s
     * in the beginning
     */
    public static int numDecodings(String s) {
	int result = 0;

	int i = 0;
	while (i < s.length() && s.charAt(i) == '0') {
	    i++;
	}
	s = s.substring(i);

	if (s.length() == 0) {
	    return 0;
	} else if (s.length() < 2) {
	    return 1;
	}

	if (s.length() > 1 && Integer.valueOf(s.substring(0, 2)) <= 26) {
	    if (s.charAt(1) == '0') {
		result = numDecodings(s.substring(2));
	    }

	    result = (1 + numDecodings(s.substring(2)))
		    + numDecodings(s.substring(1));
	} else {
	    result = numDecodings(s.substring(1));
	}
	return result;
    }

    public static int numDecodingsHighHand(String s) {
	if (s == null || s.length() == 0)
	    return 0;

	int len = s.length();
	int[] dp = new int[len + 1];

	dp[len] = 1;

	for (int i = len - 1; i >= 0; i--) {
	    if (s.charAt(i) != '0') {
		dp[i] = dp[i + 1];
		if (i < len - 1
			&& Integer.parseInt(s.substring(i, i + 2)) <= 26)
		    dp[i] += dp[i + 2];
	    }
	}

	return dp[0];
    }
}
