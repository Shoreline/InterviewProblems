package string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrome {
    /*
     * Know Character.isLetter(char c) and Character.isDigit(char c)
     */
    public class Solution {
	public boolean isPalindrome(String s) {
	    if (s == null) {
		return false;
	    }

	    s = s.toLowerCase();

	    int i = 0;
	    int j = s.length() - 1;
	    while (i < j) {
		char front = s.charAt(i);
		char back = s.charAt(j);
		if (!Character.isLetter(front) && !Character.isDigit(front)) {
		    i++;
		    continue;
		} else if (!Character.isLetter(back)
			&& !Character.isDigit(back)) {
		    j--;
		    continue;
		}

		if (front != back) {
		    return false;
		}

		i++;
		j--;
	    }

	    return true;
	}
    }
}
