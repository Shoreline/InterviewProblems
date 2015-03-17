package string;

public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers beginning as
     * follows: 1, 11, 21, 1211, 111221, ...
     * 
     * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
     * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
     * nth sequence.
     * 
     * Note: The sequence of integers will be represented as a string.
     */

    public class Solution {
	public String countAndSay(int n) {
	    String input = "1";

	    int round = 1;
	    while (round < n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
		    char c = input.charAt(i);
		    int count = 1;
		    while (i + count < input.length()
			    && input.charAt(i + count) == c) {
			count++;
		    }
		    i += (count - 1);

		    sb.append(count);
		    sb.append(c);
		}
		input = sb.toString();
		round++;
	    }

	    return input;
	}
    }

    // recursive solution
    public class Solution2 {
	public String countAndSay(int n) {

	    return countAndSayHelper("1", n);

	}

	private String countAndSayHelper(String input, int n) {
	    if (n < 2) {
		return input;
	    }

	    StringBuilder sb = new StringBuilder();

	    int len = input.length();
	    for (int i = 0; i < len; i++) {
		char c = input.charAt(i);
		int count = 1;
		while (i + count < len && input.charAt(i + count) == c) {
		    count++;
		}
		i += (count - 1);

		sb.append(count);
		sb.append(c);
	    }

	    return countAndSayHelper(sb.toString(), n - 1);
	}
    }

}
