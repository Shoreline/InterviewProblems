package string;

import java.util.Arrays;

public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(new StringTest().new Solution()
		.isMatch("aaaaaaaaaaaaaaaaaaaaaaa", "*aaaaaaaaaaaaaaaaaaaaaaa*"));
	new MultiplyStrings().new Solution().multiply("9", "9");

	PalindromeNumber.isPalindrome(1);

	System.out.println("hello word");

	String str1 = "hello fuck";
	String str2 = "fuck helosl";

	System.out.println(PermutationCheck.isPermutation(str1, str2));

	String strSort = "23omlske402lskf";
	char[] aCharArray = strSort.toCharArray();
	Arrays.sort(aCharArray);
	// Arrays.sort(aCharArray, Comparator<char a1, char a2>)
	String strSorted = new String(aCharArray);
	System.out.println(strSorted);

	String strPalindrome = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	System.out.println(LongestPalindrome
		.getLongestPalindrome(strPalindrome));

	System.out.println("=============");
	System.out.println(AddBinary.addBinary2("1101", "1111"));

	System.out.println("=============");
	int fib = PrimeFib.getPrimeFib(227000);
	System.out.println(fib);
	System.out.println(PrimeFib.getPrimeDiversorSum(fib + 1));

	System.out.println("=============");
	System.out.println(DecodeWays.numDecodings("01"));

	System.out.println("=============");
	System.out.println(DivideTwoIntegers.divideHighHand(207, 32));

	System.out.println("=============");
	System.out.println(EditDistance.minDistance("ab", "a"));

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
}
